import cv2

cascade_src = 'cars.xml'
video_src = 'cars.avi'

cap = cv2.VideoCapture(video_src)
car_cascade = cv2.CascadeClassifier(cascade_src)

ret, prev_frame = cap.read()
prev_gray = cv2.cvtColor(prev_frame, cv2.COLOR_BGR2GRAY)

while cap.isOpened():
    ret, frame = cap.read()
    if type(frame) == type(None):
        break

    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    diff = cv2.absdiff(gray, prev_gray)

    blurred = cv2.blur(diff, (5, 5))
    _, thresh = cv2.threshold(blurred, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)

    blurred2 = cv2.blur(thresh, (5, 5))
    _, final_thresh = cv2.threshold(blurred2, 0, 255, cv2.THRESH_BINARY + cv2.THRESH_OTSU)

    cars = car_cascade.detectMultiScale(final_thresh, 1.1, 2)

    for (x, y, w, h) in cars:
        cv2.circle(frame, (x + w // 2, y + h // 2), int((w + h) / 4), (0, 255, 0), 2)

    cv2.imshow('video', frame)

    if cv2.waitKey(33) == 27:
        break

    prev_gray = gray.copy()

cv2.destroyAllWindows()
