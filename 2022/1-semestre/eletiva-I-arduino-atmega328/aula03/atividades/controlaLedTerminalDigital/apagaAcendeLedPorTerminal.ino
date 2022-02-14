// C++ code
//


// Escreve carinha triste e carinha feliz
// include the library code:
#include <LiquidCrystal.h>

LiquidCrystal lcd(2, 3, 4, 5, 6, 7);

void setup() 
{
  Serial.begin(9600);
  pinMode(A0,OUTPUT);
}

void loop() 
{
  // Digitar 0 para apagar led e 1 para acender led
  // Enquanto há caracteres, leia
  while (Serial.available() > 0)
  {
    // se o que vem na serial é 
    if (Serial.read() == '0')
    {
      digitalWrite(A0,LOW);
    }
    else
    {
    	digitalWrite(A0,HIGH);
    }
  }
}



