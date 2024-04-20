import numpy as np
import pandas as pd
import matplotlib.pyplot as pylt
from numpy.linalg import inv
from sklearn.linear_model import LinearRegression

BETA_0 = []
BETA_1 = []
BETA = []

def calcula_coeficiente_relacao(array_x, array_y):
    # subtrai a média do array de cada elemento do mesmo
    media_array_x = array_x - np.mean(array_x)
    media_array_y = array_y - np.mean(array_y)
    # multiplica cada elemento do array 1 por cada elemento do array 2
    resultado_numerador = np.sum(media_array_x * media_array_y)
    resultado_denominador = np.sqrt(np.sum(media_array_x ** 2) * np.sum(media_array_y ** 2))
    return np.divide(resultado_numerador, resultado_denominador)

def reta_regressao(array_x, array_y):
    media_array_x = array_x - np.mean(array_x)
    media_array_y = array_y - np.mean(array_y)
    resultado_numerador = np.sum(np.multiply(media_array_x, media_array_y))
    resultado_denominador = np.sum(np.power(media_array_x, 2))
    beta1 = resultado_numerador / resultado_denominador
    BETA_1.append(beta1)
    beta0 = np.mean(array_y) - np.multiply(beta1, np.mean(array_x))
    BETA_0.append(beta0)
    return beta0 + (np.array(array_x) * beta1)

def regressao_multipla(matriz_X_t, y):
    matriz_X = list(map(list, zip(*matriz_X_t)))
    term0 = np.dot(matriz_X_t, matriz_X)
    term0 = inv(term0)
    term1 = np.dot(matriz_X_t, y)
    BETA.append(np.dot(term0, term1))
    return np.dot(matriz_X, BETA[0])

if __name__ == "__main__":
  df = pd.read_csv("./assets/data.csv", header=None)

  # b) Utilize o comando python .describe() para fazer uma primeira análise estatística da sua base de dados. Qual a média de preço das casas? Quanto custa a menor casa? Quantos quartos tem a casa mais cara?
  #                  0          1              2
  # count    47.000000  47.000000      47.000000
  # mean   2000.680851   3.170213  340412.765957 - Média
  # std     794.702354   0.760982  125039.911223
  # min     852.000000   1.000000  169900.000000 Mais barata
  # 25%    1432.000000   3.000000  249900.000000
  # 50%    1888.000000   3.000000  299900.000000
  # 75%    2269.000000   4.000000  384450.000000
  # max    4478.000000   5.000000  699900.000000 - 5 Quartos na casa mais cara

  # a) Análise estatística dos dados
  print(df.describe())

  # b) Média de preço das casas
  media_preco = df[2].mean()
  print("Média de preço das casas:", media_preco)

  # Menor preço da casa
  menor_preco = df[2].min()
  print("Menor preço da casa:", menor_preco)

  # Número de quartos da casa mais cara
  casa_mais_cara = df[df[2] == df[2].max()]
  quartos_casa_mais_cara = casa_mais_cara[1].values[0]
  print("Número de quartos da casa mais cara:", quartos_casa_mais_cara)

  # c) Gerando matriz X e vetor y
  uns = []
  for _ in range(len(df[0])):
      uns.append(1)

  matriz_X = [uns, list(df[0].values), list(df[1].values)]
  y = list(df[2].values)
  print(y)

  # d), e)
  figure = pylt.figure(figsize=(16, 4))

  pylt.subplot(1, 3, 1)
  pylt.scatter(matriz_X[1], y, color='blue') # 1. gráfico dispersão
  pylt.plot(matriz_X[1], reta_regressao(matriz_X[1], y), color='orange') # 3. linha regressão
  label1 = f"r = {calcula_coeficiente_relacao(matriz_X[1], y):.4f}, b0 = {BETA_0[0]:.4f}, b1 = {BETA_1[0]:.4f}"
  pylt.title(label1)
  pylt.xlabel("Tamanho")
  pylt.ylabel("Preço")

  pylt.subplot(1, 3, 2)
  pylt.scatter(matriz_X[2], y, color='red') # 1. gráfico dispersão
  pylt.plot(matriz_X[2], reta_regressao(matriz_X[2], y), color='green') # 3. linha regressão
  label2 = f"r = {calcula_coeficiente_relacao(matriz_X[2], y):.4f}, b0 = {BETA_0[1]:.4f}, b1 = {BETA_1[1]:.4f}"
  pylt.title(label2)
  pylt.xlabel("Número de quartos")
  pylt.ylabel("Preço")

  regressao = regressao_multipla(matriz_X, y)

  fig = pylt.figure()
  ax = fig.add_subplot(111, projection="3d")
  ax.set_xlabel("Tamanho da casa")
  ax.set_ylabel("Número de quartos")
  ax.set_zlabel("Preço da casa")

  # f
  ax.scatter(matriz_X[1], matriz_X[2], y)
  pylt.plot(matriz_X[1], matriz_X[2], regressao, color='red', label='Linha de Regressão')

  pylt.show()

  # h)
  matriz_H = np.array([[1, 1650, 5]])
  preco_casa = np.dot(matriz_H, BETA[0])

  for _ in range(len(preco_casa)):
    print(f"O preço da casa com tamanho de 1650 e 3 quartos é: {preco_casa[_]:.2f}")

  # Se a quantidade de quartos aumenta o preço diminui. A correlação é ruim
  # pois a quantidade de quartos não é um bom parâmetro para se basear.
  # A base de dados só tem um exemplo com 1 quarto e um exemplo com 5
  # assim, dificulta para o modelo em efetuar a previsão.

  # i
  model = LinearRegression()

  model.fit(np.array(matriz_X).T, y)

  coeficientes_sklearn = model.coef_

  print("Coeficientes do scikit-learn:", coeficientes_sklearn)
  print("Coeficientes calculados manualmente:", BETA[0])

  print(model.predict(matriz_H))