// Biblioteca LCD
#include <LiquidCrystal.h>

LiquidCrystal lcd(2, 3, 4, 5, 6, 7);
// Em que pinos do arduíno foram conectados os seguintes abaixos:
// Pino rs, pino Enable, pinos db4 até db7 

#define VERDE    A0
#define AMARELO  A2

#define TEC1 A1
#define TEC2 A3


void setup()
{
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(VERDE,    OUTPUT);
  pinMode(AMARELO,  OUTPUT);

  pinMode(TEC1, INPUT);
  pinMode(TEC2, INPUT);
  
  Serial.begin(9600);
  
  // define numero de colunas e linhas
  // quanto mais linha e coluna mais memória ele tem
  lcd.begin(16,2);
  
  // Automaticamente posiciona um cursor invisível na primeira linha e coluna (0,0)
  // Também configura o sentido da escrita
  	// Esquerda para a direita (padrão)
  
  lcd.print("Hello, world!");
  delay(1000);
  // Faz o cursor ir para coluna 0 linha 0
  lcd.home();
  lcd.print("R");
  delay(30000);
}

void loop()
{ 
  // Limpa a área antes de imprimir novamente
  lcd.setCursor(0,1);
  lcd.print("   ");
  // Posiciona o cursor na coluna 0 linha 1
  lcd.setCursor(0,1);
  lcd.print(analogRead(A5));
  if(analogRead(A5)<=1)
  {
    digitalWrite(VERDE,    HIGH);
    digitalWrite(AMARELO, HIGH);
  }
  else
  {
    digitalWrite(VERDE,    LOW);
    digitalWrite(AMARELO, LOW);
  }
  delay(100);
}

