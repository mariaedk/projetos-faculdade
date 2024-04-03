import numpy as np
import matplotlib.pyplot as pylt

x1 = [10, 8, 13, 9, 11, 14, 6, 4, 12, 7, 5]
y1 = [8.04, 6.95, 7.58, 8.81, 8.33, 9.96, 7.24, 4.26, 10.84, 4.82, 5.68]

x2 = [10, 8, 13, 9, 11, 14, 6, 4, 12, 7, 5]
y2 = [9.14, 8.14, 8.47, 8.77, 9.26, 8.10, 6.13, 3.10, 9.13, 7.26, 4.74]

x3 = [8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 19]
y3 = [6.58, 5.76, 7.71, 8.84, 8.47, 7.04, 5.25, 5.56, 7.91, 6.89, 12.50]

# é possível calcular direto usando uma lib do numpy
# coeficienteCorrelacao1 = np.corrcoef(x1, y1)[0, 1]
# coeficienteCorrelacao2 = np.corrcoef(x2, y2)[0, 1]
# coeficienteCorrelacao3 = np.corrcoef(x3, y3)[0, 1]

def calcula_coeficiente_relacao(array_x, array_y):
    # subtrai a média do array de cada elemento do mesmo
    media_array_x = array_x - np.mean(array_x)
    media_array_y = array_y - np.mean(array_y)
    # multiplica cada elemento do array 1 por cada elemento do array 2
    resultado_numerador = np.sum(media_array_x * media_array_y)
    resultado_denominador = np.sqrt(np.sum(media_array_x ** 2) * np.sum(media_array_y ** 2))
    return np.divide(resultado_numerador, resultado_denominador)


print(f"Coeficiente de relação para o dataset 1: {calcula_coeficiente_relacao(x1, y1):.4f}")
print(f"Coeficiente de relação para o dataset 2: {calcula_coeficiente_relacao(x2, y2):.4f}")
print(f"Coeficiente de relação para o dataset 3: {calcula_coeficiente_relacao(x3, y3):.4f}")

# cria um novo gráfico 16x4
figure = pylt.figure(figsize=(16, 4))

# DataSet 1
# subplot -> cria cada dataset em gráficos separados
# scatter -> cria gráfico de dispersão (ponto em plano cartesiano)
pylt.subplot(1, 3, 1)
pylt.scatter(x1, y1, color='purple')
pylt.title("Dataset 1")
pylt.xlabel("Eixo X")
pylt.ylabel("Eixo Y")

# DataSet 2
pylt.subplot(1, 3, 2)
pylt.scatter(x2, y2, color='red')
pylt.title("Dataset 2")
pylt.xlabel("Eixo X")
pylt.ylabel("Eixo Y")

# DataSet 3
pylt.subplot(1, 3, 3)
pylt.scatter(x3, y3, color='blue')
pylt.title("Dataset 3")
pylt.xlabel("Eixo X")
pylt.ylabel("Eixo Y")

pylt.show()

