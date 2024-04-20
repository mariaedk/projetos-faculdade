import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from numpy.linalg import inv

from sklearn.linear_model import LinearRegression
from sklearn.metrics import r2_score


def calc_eqm(x, y, deg):
  p = np.polyfit(x, y, deg)
  y_pred = sum(p[i] * x ** (deg - i) for i in range(len(p)))
  return np.mean((y - y_pred) ** 2), y_pred



if __name__ == "__main__":
  # a) baixar o arquivo
  df = pd.read_csv("./assets/data_preg.csv", header=None)

  # separar os valores do arquivo em coluna de X e Y
  x = df[0].values
  y = df[1].values

  # criar a figura
  figure = plt.figure()

  # b) gráfico de dispersão em azul (bolinhas)
  plt.scatter(x, y, color='blue')

  # c) linha de regressão na cor vermelha
  eqm1, y_pred1 = calc_eqm(x,y, 1)
  plt.plot(x, y_pred1, '-', color='red', label='Reta de Regressão grau 1')

  # d) linha de regressão n=2 na cor verde
  eqm2, y_pred2 = calc_eqm(x, y, 2)
  plt.plot(x, y_pred2, '-', color='green', label='Reta de Regressão grau 2')

  # e) linha de regressão n=3 na cor preta
  eqm3, y_pred3 = calc_eqm(x, y, 3)
  plt.plot(x, y_pred3, '-', color='black', label='Reta de Regressão grau 3')

  # f) linha de regressão n=4 na cor amarela
  eqm8, y_pred8 = calc_eqm(x, y, 8)
  plt.plot(x, y_pred8, '-', color='yellow', label='Reta de Regressão grau 8')

  # colocar legenda na direita
  plt.legend(loc='upper right')
  plt.show()

  # EQM= (soma(residuo)) / size(y,1)
  # g) Calcule o Erro Quadrático Médio (EQM) para cada linha de regressão. Qual é o mais preciso?
  print("Erro Quadrático Médio (EQM) para cada linha de regressão:")
  print("Linha Vermelha: ", eqm1)
  print("Linha Verde: ", eqm2)
  print("Linha Preta: ", eqm3)
  print("Linha Amarela: ", eqm8, "\n")

  #h) Para evitar o overfitting, divida os dados aleatoriamente em Dados de Treinamento e Dados de Teste. Use os primeiros 10% dos dados como conjunto de teste, e o resto como de treinamento.
  x_train = x[5:]
  y_train = y[5:]
  x_test = x[:5]
  y_test = y[:5]
  
  #i) Repita os passos de c - f, mas agora use apenas os dados de treinamento para ajustar a linha de regressão.
  # polyfit retorna coeficientes
  eqm_train1, y_pred_train1 = calc_eqm(x_train,y_train, 1)
  print("Erro Quadrático Médio Train (EQM) para grau 1:", eqm_train1)
  plt.plot(x_train, y_pred_train1, '-', color='red', label='Reta de Regressão grau 1')

  eqm_train2, y_pred_train2 = calc_eqm(x_train, y_train, 2)
  print("Erro Quadrático Médio Train (EQM) grau 2:", eqm_train2)
  plt.plot(x_train, y_pred_train2, '-', color='green', label='Reta de Regressão grau 2')

  eqm_train3, y_pred_train3 = calc_eqm(x_train, y_train, 3)
  print("Erro Quadrático Médio Train (EQM) grau 2:", eqm_train3)
  plt.plot(x_train, y_pred_train3, '-', color='black', label='Reta de Regressão grau 3')

  eqm_train8, y_pred_train8 = calc_eqm(x_train, y_train, 8)
  print("Erro Quadrático Médio Train (EQM) grau 8:", eqm_train8)
  plt.plot(x_train, y_pred_train8, '-', color='yellow', label='Reta de Regressão grau 8')


  # colocar legenda na direita
  plt.legend(loc='upper right')
  plt.show()

  #J) Repita o passo g, mas agora utilize somente os dados de Teste para calcular o erro.
  eqm_test1, y_pred_test1 = calc_eqm(x_test, y_test, 1)
  print("Erro Quadrático Médio Teste (EQM) para grau 1:", eqm_test1)
  plt.plot(x_test, y_pred_test1, '-', color='red', label='Reta de Regressão grau 1')

  eqm_test2, y_pred_test2 = calc_eqm(x_test, y_test, 2)
  print("Erro Quadrático Médio Teste (EQM) grau 2:", eqm_test2)
  plt.plot(x_test, y_pred_test2, '-', color='green', label='Reta de Regressão grau 2')

  eqm_test3, y_pred_test3 = calc_eqm(x_test, y_test, 3)
  print("Erro Quadrático Médio test (EQM) grau 2:", eqm_test3)
  plt.plot(x_test, y_pred_test3, '-', color='black', label='Reta de Regressão grau 3')

  eqm_test8, y_pred_test8 = calc_eqm(x_test, y_test, 8)
  print("Erro Quadrático Médio test (EQM) grau 8:", eqm_test8)
  plt.plot(x_test, y_pred_test8, '-', color='yellow', label='Reta de Regressão grau 8')

  # colocar legenda na direita
  plt.legend(loc='upper right')
  plt.show()

  #k) Calcule o R2 para os dados de treino e teste (veja a função r2_score da biblioteca sklearn.metrics). O que se pode concluir com os resultados?


  r2_train = r2_score(y_train, calc_eqm(x_train, y_train, 1)[1])
  r2_test = r2_score(y_test, calc_eqm(x_test, y_test, 1)[1])
  print("R2 para os dados de treino: ", r2_train)
  print("R2 para os dados de teste: ", r2_test)
  print("Conclusão: O modelo está com overfitting, pois o R2 para os dados de treino é maior que o R2 para os dados de teste.")

  # model = LinearRegression()
  # model.fit(x_train, y_train)

  # r2 = r2_score(y_test, model.predict(x_test))
  # print("R2 para os dados de teste: ", r2)



