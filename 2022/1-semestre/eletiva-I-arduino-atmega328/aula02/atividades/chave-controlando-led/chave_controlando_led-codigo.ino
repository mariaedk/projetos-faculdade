
#define VERDE A0
#define AMARELO A2
#define VERMELHO A4

#define TEC1 A1
#define TEC2 A3
#define TEC3 A5

unsigned char contador;

void setup()
{
  pinMode(LED_BUILTIN, OUTPUT);
  
  pinMode(VERDE, OUTPUT);
  pinMode(AMARELO, OUTPUT);
  pinMode(VERMELHO, OUTPUT);
  
  pinMode(TEC1, INPUT);
  pinMode(TEC2, INPUT);
  pinMode(TEC3, INPUT);

}

void loop()
{
  // controla liga e desliga de leds por meio de uma chave
  // Mesma coisa que fazer os Ifs 
  digitalWrite(VERDE, digitalRead(TEC1));
  digitalWrite(AMARELO, digitalRead(TEC2));
  digitalWrite(VERMELHO, digitalRead(TEC3));
           
  /*
  // LED VERDE
  if(digitalRead(TEC1) == HIGH)
  {
     digitalWrite(VERDE, HIGH);
  }
  else
  {
    digitalWrite(VERDE, LOW);
  }
  
  // LED AMARELO
  if(digitalRead(TEC2) == HIGH)
  {
     digitalWrite(AMARELO, HIGH);
  }
  else
  {
    digitalWrite(AMARELO, LOW);
  }
  
  // LED VERMELHO
  if(digitalRead(TEC3) == HIGH)
  {
     digitalWrite(VERMELHO, HIGH);
  }
  else
  {
    digitalWrite(VERMELHO, LOW);
  }
  */
}

