'''
Alunos: 
  Arthur Pinotti
  Kaue Reblin
  Luan Guarnieri
  Maria Krutzsch

'''
import warnings
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

from numpy.linalg import inv
from sklearn.linear_model import LinearRegression
from sklearn.metrics import r2_score

'''
Ajustar o polinômio
Calcula as previsões do modelo
Calcula o erro quadrático médio

retorna o erro quadratico e a previsao do modelo
'''
def calc_eqm(x, y, deg):
    with warnings.catch_warnings():
        warnings.simplefilter("ignore", category=np.RankWarning)
        p = np.polyfit(x, y, deg)   
    y_pred = sum(p[i] * x ** (deg - i) for i in range(len(p)))   
    eqm = np.mean((y - y_pred) ** 2)
    
    return eqm, y_pred

def printaR2(train, test, coeficiente):
    print(f"R2 treino com coeficiente {coeficiente}: {train}")
    print(f"R2 teste com coeficiente {coeficiente}: {test}")

if __name__ == "__main__":
  # a) baixar o arquivo
  df = pd.read_csv("data_preg.csv", header=None)

     # separar os valores do arquivo em coluna de X e Y
  x = df[0].values
  y = df[1].values

      # Criar a figura e os subplots
  fig, axs = plt.subplots(1, 3, figsize=(15, 5))

  # b) Plotar os dados de dispersão em azul (bolinhas)
  axs[0].scatter(x, y, color='blue')

  # c) linha de regressão n=1 na cor vermelha
  eqm1, y_pred1 = calc_eqm(x, y, 1)
  axs[0].plot(x, y_pred1, color='red', linestyle='solid', label='Reta de Regressão grau 1')

  # d) linha de regressão n=2 na cor verde
  eqm2, y_pred2 = calc_eqm(x, y, 2)
  axs[0].plot(x, y_pred2, color='green', linestyle='solid', label='Reta de Regressão grau 2')

  # e) linha de regressão n=3 na cor preta
  eqm3, y_pred3 = calc_eqm(x, y, 3)
  axs[0].plot(x, y_pred3, color='black', linestyle='solid', label='Reta de Regressão grau 3')

  # f) linha de regressão n=8 na cor amarela
  eqm8, y_pred8 = calc_eqm(x, y, 8)
  axs[0].plot(x, y_pred8, color='yellow', linestyle='solid', label='Reta de Regressão grau 8')

      # Adicionar legenda na direita
  axs[0].legend(loc='lower left')
  axs[0].set_title('Regressão com Dados de Teste')

     # EQM= (soma(residuo)) / size(y,1)
  # g) Calcule o Erro Quadrático Médio (EQM) para cada linha de regressão. Qual é o mais preciso?
  print("Erro Quadrático Médio (EQM) para cada linha de regressão:\n")
  print("Linha Vermelha: ", eqm1)
  print("   Linha Verde: ", eqm2)
  print("   Linha Preta: ", eqm3)
  print(" Linha Amarela: ", eqm8)
  print("\n")

  # h) Para evitar o overfitting, divida os dados aleatoriamente em Dados de Treinamento e Dados de Teste. Use os primeiros 10% dos dados como conjunto de teste, e o resto como de treinamento.
  x_train = x[5:]
  y_train = y[5:]
  x_test = x[:5]
  y_test = y[:5]

  # i) Repetir os passos de c - f, mas agora usando apenas os dados de treinamento para ajustar a linha de regressão, polyfit retorna coeficientes
  eqm_train1, y_pred_train1 = calc_eqm(x_train,y_train, 1)
  axs[1].plot(x_train, y_pred_train1, color='red', linestyle='solid', label='Reta de Regressão grau 1')

  eqm_train2, y_pred_train2 = calc_eqm(x_train, y_train, 2)
  axs[1].plot(x_train, y_pred_train2, color='green', linestyle='solid', label='Reta de Regressão grau 2')

  eqm_train3, y_pred_train3 = calc_eqm(x_train, y_train, 3)
  axs[1].plot(x_train, y_pred_train3, color='black', linestyle='solid', label='Reta de Regressão grau 3')

  eqm_train8, y_pred_train8 = calc_eqm(x_train, y_train, 8)
  axs[1].plot(x_train, y_pred_train8, color='yellow', linestyle='solid', label='Reta de Regressão grau 8')

  print("Erro Quadrático Médio Train (EQM) grau 1: ", eqm_train1)
  print("Erro Quadrático Médio Train (EQM) grau 2: ", eqm_train2)
  print("Erro Quadrático Médio Train (EQM) grau 2: ", eqm_train3)
  print("Erro Quadrático Médio Train (EQM) grau 8: ", eqm_train8)
  print("\n")

      # Adicionar legenda na direita
  axs[1].legend(loc='lower left')
  axs[1].set_title('Regressão com dados de treinamento')


  # J) Repita o passo g, mas agora utilize somente os dados de Teste para calcular o erro.
  eqm_test1, y_pred_test1 = calc_eqm(x_test, y_test, 1)
  eqm_test2, y_pred_test2 = calc_eqm(x_test, y_test, 2)
  eqm_test3, y_pred_test3 = calc_eqm(x_test, y_test, 3)
  eqm_test8, y_pred_test8 = calc_eqm(x_test, y_test, 8)

  print("Erro Quadrático Médio Teste (EQM) grau 1: ", eqm_test1)
  print("Erro Quadrático Médio Teste (EQM) grau 2: ", eqm_test2)
  print("Erro Quadrático Médio Teste (EQM) grau 3: ", eqm_test3)
  print("Erro Quadrático Médio Teste (EQM) grau 8: ", eqm_test8)
  print("\n")

      # Plot dos resultados
  axs[2].plot(x_test, y_pred_test1, color='red', linestyle='solid', label='Reta de Regressão grau 1')
  axs[2].plot(x_test, y_pred_test2, color='green', linestyle='solid', label='Reta de Regressão grau 2')
  axs[2].plot(x_test, y_pred_test3, color='black', linestyle='solid', label='Reta de Regressão grau 3')
  axs[2].plot(x_test, y_pred_test8, color='yellow', linestyle='solid', label='Reta de Regressão grau 8')
  axs[2].set_title('Erro quadrático médio teste')

  # k) Calcule o R2 para os dados de treino e teste (veja a função r2_score da biblioteca sklearn.metrics). O que se pode concluir com os resultados?
  r1_train = r2_score(y_train, calc_eqm(x_train, y_train, 1)[1])
  r1_test = r2_score(y_test, calc_eqm(x_test, y_test, 1)[1])
  printaR2(r1_train, r1_test, 1)

  r2_train = r2_score(y_train, calc_eqm(x_train, y_train, 2)[1])
  r2_test = r2_score(y_test, calc_eqm(x_test, y_test, 2)[1])
  printaR2(r2_train, r2_test, 2)

  r3_train = r2_score(y_train, calc_eqm(x_train, y_train, 3)[1])
  r3_test = r2_score(y_test, calc_eqm(x_test, y_test, 3)[1])
  printaR2(r3_train, r3_test, 3)

  r8_train = r2_score(y_train, calc_eqm(x_train, y_train, 8)[1])
  r8_test = r2_score(y_test, calc_eqm(x_test, y_test, 8)[1])
  printaR2(r8_train, r8_test, 8)
  
  print("\n")
  print("Conclusão: O modelo está com overfitting, pois o R2 para os dados de treino é maior que o R2 para os dados de teste.")

'''
Adicionar legenda na direita
Ajustar layout
Exibir os gráficos
'''
plt.legend(loc='lower right')
plt.tight_layout()
plt.show()

# l) Visto o cálculo do erro e do coeficiente de determinação, qual o modelo mais preciso neste caso? Explique sua resposta.

'''
Para ver qual o modelo mais preciso, tem que comparar o EQM  e o R^2 para cada grau, onde o menor EQM e o maior R^2 é o melhor modelo
'''