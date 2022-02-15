/*
  descrição:
  * faz um led acender
*/

void setup() 
{
  pinMode(13, OUTPUT);
  Serial.begin(9600);
}

void loop() 
{
  digitalWrite(13, HIGH);
  delay(1000);
  digitalWrite(13, LOW);
  delay(1000);

  //Serial.println("Hello world!");

  // Há algum dado memorizado?
  if (Serial.available() > 0)
  {
    Serial.write(Serial.read());
  }
}
