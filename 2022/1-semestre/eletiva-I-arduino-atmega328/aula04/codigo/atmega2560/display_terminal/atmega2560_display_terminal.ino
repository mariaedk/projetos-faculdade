#include <LiquidCrystal.h>
#include <Keypad.h>

const byte ROWS = 4; //four rows
const byte COLS = 4; //four columns

char Formato[64];

//define the symbols on the buttons of the keypads
char hexaKeys[ROWS][COLS] = {
  {'7','8','9','/'},
  {'4','5','6','X'},
  {'1','2','3','-'},
  {'C','0','=','+'}
  };

byte rowPins[ROWS] = {28, 29, 30, 31}; //connect to the row pinouts of the keypad
byte colPins[COLS] = {32, 33, 34, 35}; //connect to the column pinouts of the keypad

Keypad customKeypad = Keypad( makeKeymap(hexaKeys), rowPins, colPins, ROWS, COLS);

LiquidCrystal lcd(22, 23, 24, 25, 26, 27);

void setup()
{
  // set up the LCD's number of columns and rows:
  lcd.begin(16, 2);
  
  // Print a message to the LCD.
  lcd.print("hello, world!");
  
  Serial.begin(9600);
  
  analogReference(DEFAULT);
}

void loop() 
{
char customKey = customKeypad.getKey();

  if (customKey)
  {
    Serial.println(customKey);
    lcd.setCursor(0,0); //lcd.home();
    lcd.print(customKey);
  }
  // print no lcd
  lcd.setCursor(0,1);
  lcd.print(" ");
  lcd.setCursor(0,1);
  lcd.print((analogRead(A0)*0.0048828125)*100);
  delay(100);
  
  //c - caracter d - integer f - float
  // print no terminal
  sprintf(Formato, "A temperatura atual %d",(int) ((analogRead(A0)*0.0048828125)*100));
  Serial.println(Formato);
}
