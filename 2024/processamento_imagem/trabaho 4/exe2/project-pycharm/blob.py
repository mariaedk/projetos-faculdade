"""
Alunos: Luan Lavandoski Guarnieri, Maria Eduarda Krutzsch
"""
import cv2
import numpy as np

video = 'cars.avi'

def detectar_blob(imagem, subtrator_fundo, area_minima=100):
    # Aplicando subtração de fundo
    mascara_fg = subtrator_fundo.apply(imagem)
    
    # Aplicando uma operação de abertura para remover ruídos
    kernel = cv2.getStructuringElement(cv2.MORPH_ELLIPSE, (5, 5))
    mascara_fg = cv2.morphologyEx(mascara_fg, cv2.MORPH_OPEN, kernel)
    
    # Encontrando os contornos na máscara de foreground
    contornos, _ = cv2.findContours(mascara_fg, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    
    # Inicializando a lista de blobs
    blobs = []
    
    # Loop sobre todos os contornos encontrados
    for contorno in contornos:
        # Calculando a área do contorno
        area = cv2.contourArea(contorno)
        
        # Se a área for muito pequena, provavelmente não é um veículo, então ignoramos
        if area < area_minima:
            continue
        
        # Calculando o menor círculo envolvente para o contorno
        (x, y), raio = cv2.minEnclosingCircle(contorno)
        centro = (int(x), int(y))
        raio = int(raio)
        
        # Adicionando o centro e a área do blob à lista de blobs
        blobs.append((centro, raio, area))
        
        # Desenhando um círculo ao redor do blob
        cv2.circle(imagem, centro, raio, (0, 255, 0), 2)
    
    # Retornando a lista de blobs e a imagem com os blobs desenhados
    return blobs, imagem

# Carregando o vídeo
cap = cv2.VideoCapture(video)

# Inicializando o modelo de subtração de fundo
subtrator_fundo = cv2.createBackgroundSubtractorMOG2()

while cap.isOpened():
    ret, frame = cap.read()
    if not ret:
        break
    
    # Detectando blobs no frame atual
    blobs, frame_resultado = detectar_blob(frame, subtrator_fundo)
    
    # Exibindo o resultado
    cv2.imshow('Detecção de Blob', frame_resultado)
    
    # Ajuste a velocidade
    if cv2.waitKey(50) == 27: 
        break

cap.release()
cv2.destroyAllWindows()
