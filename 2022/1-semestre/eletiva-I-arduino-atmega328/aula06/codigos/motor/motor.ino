// motor

void setup()
{

  
  Serial.begin(9600);
  
  analogReference(DEFAULT);

  pinMode(36, OUTPUT);

  //tone(38, 740, 200);
  // pino, velocidade
  analogWrite(2,120);
}

void loop() 
{  

}
