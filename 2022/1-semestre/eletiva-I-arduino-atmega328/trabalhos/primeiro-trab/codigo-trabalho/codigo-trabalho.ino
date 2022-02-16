#include <LiquidCrystal.h>
#include <Keypad.h>

const byte ROWS = 4; //four rows
const byte COLS = 4; //four columns

int H;
String ENTRADA;
int M;

boolean digitouHora = false;
boolean digitouMinutos = false;

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

  lcd.begin(16, 2);
  
  Serial.begin(9600);

  Serial.println("DIGITE A HORA:");
  while(Serial.available() == 0)
  {
    H = Serial.parseInt();
    while (H > 24)
    {
      Serial.println("HORA INVALIDA, DIGITE NOVAMENTE");
      H = Serial.parseInt();
    }
  }

  Serial.println(H);
  
  Serial.println("DIGITE OS MINUTOS:");
  while(Serial.available() == 0)
  {
    M = Serial.parseInt();  
    while (M > 59)
    {
        Serial.println("MINUTOS INVALIDOS, DIGITE NOVAMENTE");
        H = Serial.parseInt();
    }  
  }
  Serial.println(M);
  
  analogReference(DEFAULT);
}


void loop()
{
  char customKey = customKeypad.getKey();
  
  if (customKey == '1')
  {
    if (H > 0)
    {
      H--;
    }
    else
    {
      H = 23;
    }
  }
  else if (customKey == '2')
  {
    if (H < 23)
    {
      H++;
    }
    else
    {
      H = 0;
    }
  }
  else if (customKey == '4')
  {
    if (M > 0)
    {
      M--;
    }
    else
    {
      M = 59;
    }
  }
  else if (customKey == '5')
  {
    if (M < 59)
    {
      M++;
    }
    else
    {
      M = 0;
    }
  }
  imprimirHora();

}

void imprimirHora()
{
  if (H < 10)
  {
    Serial.print('0');
  }
  Serial.print(H);
  
  Serial.write(':');

  if (M < 10)
  {
    Serial.print('0');
  }
  
  Serial.print(M);
  
  Serial.println();
  
  lcd.setCursor(0,0);
  lcd.print("HORA ATUAL:");

  lcd.setCursor(0,1);
  if (H < 10)
  {
    lcd.print('0');
  }
  lcd.print(H);
  lcd.print(':');
  
  if (M < 10)
  {
    lcd.print('0');
  }
  
  lcd.print(M);
  
  delay(1000);
}

void validaHora()
{

}
