'''

O algoritmo de Feitosa [7], também usado neste
trabalho, utiliza o acompanhamento da região de
movimentação do veículo.
Este algoritmo utiliza filtros de média e baixa intensidade para construir uma imagem
de fundo.

Inicialmente, o método utiliza um histórico das imagens de um vídeo e faz a média dos valores de pixels.
A partir destas médias obtém uma imagem de fundo para ser subtraída da imagem atual do vídeo.
Então, um threshold é aplicado nas imagens.
Estas imagens são somadas, formando assim uma região de interesse.
Logo que esta região de interesse é formada os objetos dentro desta região são segmentados,
utilizando o filtro de detecção de bordas.
Em seguida, ocorre a localização dos veículos e a contagem a partir da apresentação do número de objetos segmentados.

'''

import cv2
import numpy as np

cascade_src = 'cars.xml'
video_src = 'cars.avi'

cap = cv2.VideoCapture(video_src)
car_cascade = cv2.CascadeClassifier(cascade_src)

history = []
# 25 -> teste empírico
history_length = 25

while cap.isOpened():
    ret, frame = cap.read()
    if type(frame) == type(None):
        break

    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    # adiciona o frame atual a um "histórico"
    # enquanto for menor significa que precisa de mais frames pra criar um historico
    if len(history) < history_length:
        history.append(gray)
    else:
        # atualiza o histórico removendo o mais antigo e adicionando o mais recente ao fim
        history.pop(0)
        history.append(gray)

    # se possui histórico suficiente para processar
    if len(history) == history_length:
        # faz a média dos valores de pixels.
        # a partir das médias obtém imagem de fundo
        imagem_fundo = np.mean(history, axis=0).astype(np.uint8)

        # subtrai a imagem de fundo da atual
        diff = cv2.absdiff(gray, imagem_fundo)

        # aplica o threshold
        _, thresh = cv2.threshold(diff, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)

        # filtro de detecção de bordas
        contours, _ = cv2.findContours(thresh, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

        # localizar os veículos
        for contour in contours:
            if cv2.contourArea(contour) > 500:  # Filtra áreas pequenas
                (x, y, w, h) = cv2.boundingRect(contour)
                cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 0), 2)

    cv2.imshow('video', frame)

    if cv2.waitKey(33) == 27:
        break

cap.release()
cv2.destroyAllWindows()
