// C++ code
// arquivo.h -> define as funções

#define VERDE A0
#define AMARELO A2
#define VERMELHO A4

// char = 8 bits  (sinal)
// int = 16 bits  (sinal)
// long = 32 bits (sinal)
// unsigned char  (sem sinal)
// unsigned int   (sem sinal)
// unsigned long  (sem sinal)

unsigned char contador;

void setup()
{
  
  // preparação do hardware para que ele possa atender a execução
  // qualquer pino pode ser entrada ou saída
  
  // para escrever no pino 13, configurar como saída
  // LED_BULTIN  = pino 13
  pinMode(LED_BUILTIN, OUTPUT);
  
  // configurar os pinos analógicos como output
  pinMode(VERDE, OUTPUT);
  pinMode(AMARELO, OUTPUT);
  pinMode(VERMELHO, OUTPUT);
  
  digitalWrite(VERDE, HIGH); 
  digitalWrite(AMARELO, LOW);  
  digitalWrite(VERMELHO, LOW); 
  
  //------------------------------------------------
  
  // Abrir o canal de comunicação
  Serial.begin(9600);
}

void loop()
{
  // Escrevendo nível lógico alto (5v)
  // digitalWrite(LED_BUILTIN, HIGH); // HIGH, TRUE, 1
  // delay(1000); // 1000ms = 1000/1000 = 1s
  // Escrevendo nível lógico baixo (0v)
  // digitalWrite(LED_BUILTIN, LOW);  
  // delay(1000); // 1000ms = 1000/1000 = 1
  
  COR_VERDE_SEMAFORO();
  COR_AMARELO_SEMAFORO();
  COR_VERMELHO_SEMAFORO();
  Serial.println("SEMAFORO! PARE");
  contador++;
  
  // mandar um dado para o canal serial
  Serial.println(contador);
}


// SEMÁFORO
void COR_VERDE_SEMAFORO()
{
  digitalWrite(VERDE, HIGH);
  digitalWrite(AMARELO, LOW);
  digitalWrite(VERMELHO, LOW);
  delay(1000);
}

void COR_AMARELO_SEMAFORO()
{
  digitalWrite(VERDE, LOW);
  digitalWrite(AMARELO, HIGH);
  digitalWrite(VERMELHO, LOW);
  delay(1000);
}

void COR_VERMELHO_SEMAFORO()
{
  digitalWrite(VERDE, LOW);
  digitalWrite(AMARELO, LOW);
  digitalWrite(VERMELHO, HIGH);
  delay(1000);
}