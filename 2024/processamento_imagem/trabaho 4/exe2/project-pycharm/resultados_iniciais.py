import numpy as np
import cv2
import matplotlib.pyplot as plt

'''
Resultados iniciais obtidos em software, processamentos de baixo e médio nível.

No quadro superior à esquerda, é aplicado o filtro de média de ordem 3, 
no quadro superior à direita é aplicado um filtro Sobel vertical, 
no quadro inferior à esquerda, o filtro laplaciano, que é um filtro convolucional 
semelhante ao do filtro Sobel, 
e no quadro inferior à direita está a imagem original.
'''

# aplicar os filtros médios em uma imagem de teste
image = cv2.imread('teste-pi.jpg')
image_rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)

# transformar para cinza
imagegray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

# aplicar filtro de média de ordem 3
filtro_media = cv2.blur(imagegray, (3, 3))

# filtro sobel
filtro_sobel_vertical = cv2.Sobel(imagegray, cv2.CV_64F, 0, 1, ksize=3)
filtro_sobel_vertical = np.uint8(np.absolute(filtro_sobel_vertical))

# filtro laplaciano
filtro_laplaciano = cv2.Laplacian(filtro_media, cv2.CV_64F)
filtro_laplaciano = np.uint8(np.absolute(filtro_laplaciano))

plt.figure(figsize=(8, 8))

plt.subplot(2, 2, 1)
plt.imshow(filtro_media, cmap='gray')
plt.title('Filtro de média de ordem 3')
plt.axis('off')

plt.subplot(2, 2, 2)
plt.imshow(filtro_sobel_vertical, cmap='gray')
plt.title('Filtro Sobel vertical')
plt.axis('off')

plt.subplot(2, 2, 3)
plt.imshow(filtro_laplaciano, cmap='gray')
plt.title('Filtro Laplaciano')
plt.axis('off')

plt.subplot(2, 2, 4)
plt.imshow(image_rgb)
plt.title('Imagem original')
plt.axis('off')

plt.waitforbuttonpress()