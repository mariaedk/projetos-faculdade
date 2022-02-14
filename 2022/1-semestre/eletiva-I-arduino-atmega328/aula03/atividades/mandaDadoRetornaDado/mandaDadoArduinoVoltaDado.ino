// C++ code
//


// Escreve carinha triste e carinha feliz
// include the library code:
#include <LiquidCrystal.h>

LiquidCrystal lcd(2, 3, 4, 5, 6, 7);

void setup() 
{
  Serial.begin(9600);
  // Pausa para ocupar o arduíno
  delay(10000);
  // Enquanto ele está ocupado, mando a mensagem "LED ACENDA" no terminal
}

void loop() 
{
  // Enquanto há caracteres, leia
  while (Serial.available() > 0)
  {
    // write imprime o caracter correspondente ao código ascii
    // se usar println ele imprime o código ascii
	Serial.write(Serial.read());
  }
}



