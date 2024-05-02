import numpy as np
import matplotlib.pyplot as pylt

x1 = [10, 8, 13, 9, 11, 14, 6, 4, 12, 7, 5]
y1 = [8.04, 6.95, 7.58, 8.81, 8.33, 9.96, 7.24, 4.26, 10.84, 4.82, 5.68]

x2 = [10, 8, 13, 9, 11, 14, 6, 4, 12, 7, 5]
y2 = [9.14, 8.14, 8.47, 8.77, 9.26, 8.10, 6.13, 3.10, 9.13, 7.26, 4.74]

x3 = [8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 19]
y3 = [6.58, 5.76, 7.71, 8.84, 8.47, 7.04, 5.25, 5.56, 7.91, 6.89, 12.50]

BETA_0 = []
BETA_1 = []

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

print(f"Coeficiente de relação para o dataset 1: {calcula_coeficiente_relacao(x1, y1):.4f}")
print(f"Coeficiente de relação para o dataset 2: {calcula_coeficiente_relacao(x2, y2):.4f}")
print(f"Coeficiente de relação para o dataset 3: {calcula_coeficiente_relacao(x3, y3):.4f}")

print("Regressão para o dataset 1: ", reta_regressao(x1, y1), "\n")
print("Regressão para o dataset 2: ", reta_regressao(x2, y2), "\n")
print("Regressão para o dataset 3: ", reta_regressao(x3, y3), "\n")

# cria um novo gráfico 16x4
figure = pylt.figure(figsize=(16, 4))

label1 = f"r = {calcula_coeficiente_relacao(x1, y1):.4f}, b0 = {BETA_0[0]:.4f}, b1 = {BETA_1[0]:.4f}"
label2 = f"r = {calcula_coeficiente_relacao(x2, y2):.4f}, b0 = {BETA_0[1]:.4f}, b1 = {BETA_1[1]:.4f}"
label3 = f"r = {calcula_coeficiente_relacao(x3, y3):.4f}, b0 = {BETA_0[2]:.4f}, b1 = {BETA_1[2]:.4f}"

pylt.subplot(1, 3, 1)
pylt.scatter(x1, y1, color='yellow') # 1. gráfico dispersão
pylt.plot(x1, reta_regressao(x1, y1), color='yellow') # 3. linha regressão
pylt.title(label1)
pylt.xlabel("Eixo X")
pylt.ylabel("Eixo Y")

pylt.subplot(1, 3, 2)
pylt.scatter(x2, y2, color='purple') # 1. gráfico dispersão
pylt.plot(x2, reta_regressao(x2, y2), color='purple') # 3. linha regressão
pylt.title(label2)
pylt.xlabel("Eixo X")
pylt.ylabel("Eixo Y")

pylt.subplot(1, 3, 3)
pylt.scatter(x3, y3, color='blue') # 1. gráfico dispersão
pylt.plot(x3, reta_regressao(x3, y3), color='blue') # 3. linha regressão
pylt.title(label3)
pylt.xlabel("Eixo X")
pylt.ylabel("Eixo Y")

# Resposta pergunta 3)
# O dataset 3, pois os valores de x estão quase todos agrupados, e há um outlier
# no último valor de y, fazendo com que os dados não sigam uma tendência linear clara.

pylt.show()