
#define VERDE A0
#define AMARELO A2

#define TEC1 A1
#define TEC2 A3

unsigned char contador;

void setup()
{
  pinMode(LED_BUILTIN, OUTPUT);
  
  pinMode(VERDE, OUTPUT);
  pinMode(AMARELO, OUTPUT);
  
  pinMode(TEC1, INPUT);
  pinMode(TEC2, INPUT);

  Serial.begin(9600);
}

void loop()
{
  digitalWrite(VERDE, digitalRead(TEC1));
  digitalWrite(AMARELO, digitalRead(TEC2));
  
  // gerar sinal analógico
  // faz o arduíno gerar o valor do multímetro
  Serial.println(analogRead(A4)* 0.0048828125);
}

