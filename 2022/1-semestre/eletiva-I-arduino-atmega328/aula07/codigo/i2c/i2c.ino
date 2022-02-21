#include <LiquidCrystal.h>
#include <Keypad.h>
#include <Wire.h>
#include <DS1621.h>

byte addr = (0x90 >> 1) | 0;  // replace the 0 with the value you set on pins A2, A1 and A0
DS1621 sensor = DS1621(addr);

void setup() 
{
  sensor.startConversion(false);                       // stop if presently set to continuous
  sensor.setConfig(DS1621::POL | DS1621::ONE_SHOT);                    // Tout = active high; 1-shot mode
  sensor.setThresh(DS1621::ACCESS_TH, 27);                     // high temp threshold = 80F
  sensor.setThresh(DS1621::ACCESS_TL, 24);

  Serial.begin(9600);

  analogReference(DEFAULT);

  int tHthresh = sensor.getTemp(DS1621::ACCESS_TH);
  Serial.print("High threshold = ");
  Serial.println(tHthresh);

  int tLthresh = sensor.getTemp(DS1621::ACCESS_TL);
  Serial.print("Low threshold = ");
  Serial.println(tLthresh);
}

void loop() 
{  
  int tC, tFrac;
  
  tC = sensor.getHrTemp();                             // read high-resolution temperature
  
  if (tC < 0) {
    tC = -tC;                                   // fix for integer division
    Serial.print("-");                          // indicate negative
  }
  
  tFrac = tC % 100;                             // extract fractional part
  tC /= 100;                                    // extract whole part
  
  Serial.print(tC);
  Serial.print(".");
  if (tFrac < 10)
    Serial.print("0");
  Serial.println(tFrac);
  
  delay(500);
}
