/*
  DESCRIÇÃO:
  * Lê o valor do sensor de temperatura e imprime no display
*/


// include the library code:
#include <LiquidCrystal.h>
#include <Keypad.h>

const byte ROWS = 4; //four rows
const byte COLS = 4; //four columns

//define the cymbols on the buttons of the keypads
char hexaKeys[ROWS][COLS] = {
  {'7','8','9','/'},
  {'4','5','6','X'},
  {'1','2','3','-'},
  {'C','0','=','+'}
};

byte rowPins[ROWS] = {A0, A1, A2, A3}; //connect to the row pinouts of the keypad
byte colPins[COLS] = {8, 9, 10, 11}; //connect to the column pinouts of the keypad

Keypad customKeypad = Keypad(makeKeymap(hexaKeys), rowPins, colPins, ROWS, COLS); 

LiquidCrystal lcd(6, 7, 2, 3, 4, 5);

void setup() {
  // set up the LCD's number of columns and rows:
  lcd.begin(16, 2);
  
  // Print a message to the LCD.
  lcd.print("hello, world!");

  Serial.begin(9600);
}

char formato[33];

void loop() {
  /*
  // Turn off the display:
  lcd.noDisplay();
  delay(500);
  
  // Turn on the display:
  lcd.display();
  delay(500);
  */

  char customKey = customKeypad.getKey();
  
  if (customKey)
  {
    
    Serial.println(customKey);
    lcd.setCursor(0,0);  // lcd.home()
    lcd.print(customKey);
  }

  lcd.setCursor(0,1);
  lcd.print("    ");
  lcd.setCursor(0,1);
  // mostra a temperatura formatada no display (multiplica pelo step para descobrir a temperatura real e multiplica por 100 para aparecer formatado)
  lcd.print((analogRead(A5)*0.0048828125)*100);
  delay(1000);

  // Se for imprimir apenas uma casa, vai colocar o zero na frente (02)
  // c = char d = int f = float
  sprintf(formato, "A temperatura atual e %02d", 23);
  Serial.println(formato);
}
