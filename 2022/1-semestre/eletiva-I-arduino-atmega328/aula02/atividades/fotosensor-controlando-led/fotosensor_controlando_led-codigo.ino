
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
  // Para um resistor de 150 ohms, quando retornar 234 signficia que amanheceu
  // noite = 4,17 mv = 1
  // dia = 1,14v = 234
  Serial.println(analogRead(A5));
  
  if (analogRead(A5) <= 1)
  {
  	digitalWrite(VERDE, HIGH);
    digitalWrite(AMARELO, HIGH);
  }
  else
  {
  	digitalWrite(VERDE, LOW);
    digitalWrite(AMARELO, LOW);
  }
  
  
}

