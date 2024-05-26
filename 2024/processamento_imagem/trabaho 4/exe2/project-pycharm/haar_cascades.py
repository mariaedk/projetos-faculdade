"""
Alunos: Luan Lavandoski Guarnieri, Maria Eduarda Krutzsch
"""
import cv2

cascade_src = 'cars.xml'
video_src = 'cars.avi'

# captura de frames
cap = cv2.VideoCapture(video_src)
car_cascade = cv2.CascadeClassifier(cascade_src)

# enquanto o vídeo estiver aberto
while cap.isOpened():
    # ret indica se a leitura foi bem sucedida e img contém o frame
    ret, img = cap.read()
    if type(img) == type(None):
        break

    # detecção de objetos é mais eficiente nesse espaço de cores
    imagem_cinza = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    # 1.1 -> o quanto cada imagem é reduzida em cada escala
    # 2 -> número mínimo de vizinhos que um retângulo deve ter para ser retido
    cars = car_cascade.detectMultiScale(imagem_cinza, 1.1, 2)

    for (x, y, w, h) in cars:
        # desenha o retângulo
        # (x + w, y + h) é o canto inferior direito
        # 2 é a espessura da linha
        cv2.rectangle(img, (x, y), (x + w, y + h), (0, 255, 0), 2)

    # exibe o frame com os retângulos desenhados
    cv2.imshow('video', img)

    # pressionar esc para sair
    if cv2.waitKey(33) == 27:
        break

cv2.destroyAllWindows()