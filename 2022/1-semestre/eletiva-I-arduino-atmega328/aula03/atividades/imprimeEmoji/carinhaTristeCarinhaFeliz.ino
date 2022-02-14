// C++ code
//


// Escreve carinha triste e carinha feliz
// include the library code:
#include <LiquidCrystal.h>

LiquidCrystal lcd(2, 3, 4, 5, 6, 7);

byte customChar_happy[] = {
  B00000,
  B00000,
  B01010,
  B00000,
  B10001,
  B01110,
  B00000,
  B00000
};

byte customChar_sad[] = {
  B00000,
  B00000,
  B01010,
  B00000,
  B00000,
  B01110,
  B10001,
  B00000
};


void setup() 
{
  lcd.begin(16, 2);
  lcd.createChar(0, customChar_happy);
  lcd.createChar(1, customChar_sad);
  lcd.home();
  lcd.write((byte)0);
}

void loop() 
{
  lcd.home();
  lcd.write((byte) 0);
  lcd.home();
  delay(1000);
  lcd.write((byte) 1);
  delay(1000);
}



