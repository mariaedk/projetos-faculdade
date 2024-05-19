import cv2

cascade_src = 'cars.xml'
video_src = 'cars.avi'

cap = cv2.VideoCapture(video_src)
car_cascade = cv2.CascadeClassifier(cascade_src)

# capturar primeiro frame do primeiro frame
ret, prev_frame = cap.read()
prev_gray = cv2.cvtColor(prev_frame, cv2.COLOR_BGR2GRAY)

while cap.isOpened():
    ret, frame = cap.read()
    if type(frame) == type(None):
        break

    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    # é necessário, primeiramente, realizar a subtração de imagens
    diff = cv2.absdiff(gray, prev_gray)

    # utilizado o filtro de média e em seguida, o filtro de limiarização
    blurred = cv2.blur(diff, (3, 3))
    _, thresh = cv2.threshold(blurred, 20, 255, cv2.THRESH_BINARY)

    # necessária a aplicação de outro filtro de média e de threshold sobre a imagem.
    blurred2 = cv2.blur(thresh, (3, 3))
    _, final_thresh = cv2.threshold(blurred2, 40, 255, cv2.THRESH_BINARY)

    cv2.imshow('video', final_thresh)

    if cv2.waitKey(33) == 27:
        break

    # atualizar frame anterior
    prev_gray = gray.copy()

cv2.destroyAllWindows()
