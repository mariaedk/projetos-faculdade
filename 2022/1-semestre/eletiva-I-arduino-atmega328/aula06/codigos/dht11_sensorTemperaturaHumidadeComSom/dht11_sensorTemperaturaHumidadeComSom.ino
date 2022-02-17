// Lê a temperatura e a humidade, printa no terminal, e também produz som

#include "DHT.h"

#define DHTPIN 37
#define DHTTYPE DHT11   // DHT 11

DHT dht(DHTPIN, DHTTYPE);

void setup()
{
  
  Serial.begin(9600);
  
  analogReference(DEFAULT);

  dht.begin();

  pinMode(36, OUTPUT);

  tone(38, 300, 200);
}

void loop() 
{  

  delay(1000);
  float h = dht.readHumidity();
  float t = dht.readTemperature();
  Serial.println(h);
  Serial.println(t);

  if (t > 36)
  {
    digitalWrite(36, HIGH);
  }
  else
  {
    digitalWrite(36, LOW);  
  }
  
}
