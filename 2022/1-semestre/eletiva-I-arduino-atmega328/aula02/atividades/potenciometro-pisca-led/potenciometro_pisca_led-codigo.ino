
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
  // PISCA PISCA LED CONTROLADO PELO POTENCIOMETRO
  digitalWrite(VERDE, HIGH);
  digitalWrite(AMARELO, HIGH);
  // Dar um delay aonde quem define este é a entrada analogica a4
  delay(analogRead(A4));
  digitalWrite(VERDE, LOW);
  digitalWrite(AMARELO, LOW);
  delay(analogRead(A4));
  
  // Ou seja, quanto maior a pausa (valor no potenciometro), menor o pisca
  // Quanto menor a pausa, mais vão piscar
  
  
}

