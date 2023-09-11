import random


class AgenteSimples:
    # depende de ambiente para executar suas ações, entao tem um ambiente dentro dele
    def __init__(self, ambiente, x_inicial=1, y_inicial=1):
        self.ambiente = ambiente

        # posição aonde o agente está
        self.x = x_inicial
        self.y = y_inicial

    def acao(self):
        return random.choice(['cima', 'direita', 'esquerda', 'baixo'])

    def executar_acao(self, acao):
        #limpar
        if self.ambiente.matriz[self.x, self.y] == 2:
            self.ambiente.limpar_bloco(self.x, self.y)

        parede = self.ambiente.verificar_parede(acao, self.x, self.y)
        while parede == 1:
            acao = self.acao()
            parede = self.ambiente.verificar_parede(acao, self.x, self.y)

        if acao == 'cima':
            self.x -= 1
        elif acao == 'baixo':
            self.x += 1
        elif acao == 'direita':
            self.y += 1
        elif acao == 'esquerda':
            self.y -= 1

        self.ambiente.exibir(self.x, self.y)
