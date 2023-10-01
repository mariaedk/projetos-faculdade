import numpy as np
import matplotlib.pyplot as plt
import random


class Ambiente:

    # construtor da classe
    # self se refere ao próprio objeto da classe
    # cria o atributo matriz sem precisar de parâmetro pois é "interno", n precisa ser fornecido
    def __init__(self, tamanho=6, quantidade_sujeira=5):
        self.tamanho = tamanho

        # cria matriz cheia de zeros
        self.matriz = np.zeros((tamanho, tamanho))

        # ":" seleciona todos os elementos de uma dimensão do array
        # coloca paredes que são representadas por 1
        self.matriz[0, :] = 1
        self.matriz[tamanho-1, :] = 1
        self.matriz[:, 0] = 1
        self.matriz[:, tamanho-1] = 1
        self.adicionar_sujeira(quantidade_sujeira)
        # criar uma matriz de cores
        # ela é tridimensional pois armazena a cor que deve ser inserida aonde tem determinado número
        # ex = se tiver o número 1, insira a cor RGB (0, 0.5, 0) que é verde, ou seja, parede
        self.cores = np.zeros(self.matriz.shape + (3,))
        self.cores[self.matriz == 1] = [0, 0.5, 0]  # paredes são verdes escuros
        self.cores[self.matriz == 2] = [1, 1, 0]    # sujeira é amarela
        self.cores[self.matriz == 0] = [0, 0, 0]    # quadrados não sujos nem limpos são pretos



    def adicionar_sujeira(self, quantidade):
        for i in range(quantidade):
            # tamanho - 2 pois são duas paredes
            x = random.randint(1, self.tamanho-2)
            y = random.randint(1, self.tamanho-2)

            # coloca 2 que simboliza a sujeira
            self.matriz[x, y] = 2

    def limpar_bloco(self, x, y):
        self.matriz[x, y] = 0
        self.cores[x, y] = [0, 0, 1]  # define a cor para azul após limpar

    def verificar_sujeira(self):
        # se tiver algum bloco com 2 (sujeira), n esta tudo limpo
        return np.any(self.matriz == 2)

    def verificar_parede(self, acao, x, y):
        if acao == 'cima':
            parede = self.matriz[x-1][y]
        elif acao == 'baixo':
            parede = self.matriz[x+1][y]
        elif acao == 'direita':
            parede = self.matriz[x][y+1]
        elif acao == 'esquerda':
            parede = self.matriz[x][y-1]
        else:
            parede = 0  # nenhuma parede
        return parede

    def exibir(self, x, y):

        plt.imshow(self.cores)
        plt.plot([y], [x], marker='o', color='r', ls='')
        plt.show(block=False)
        plt.pause(0.5)
        plt.clf()
