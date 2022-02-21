#include <LiquidCrystal.h>
#include <Keypad.h>
#include <Wire.h>
#include <DS1621.h>

byte addr = (0x90 >> 1) | 0;  // replace the 0 with the value you set on pins A2, A1 and A0
DS1621 sensor = DS1621(addr);

void setup() 
{
  pinMode(4, INPUT_PULLUP);
  pinMode(5, OUTPUT);

  
}

void loop() 
{  
  digitalWrite(5, digitalRead(4));
}
