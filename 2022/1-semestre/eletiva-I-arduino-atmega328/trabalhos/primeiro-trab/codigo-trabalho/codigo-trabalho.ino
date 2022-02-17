/*
  INSTRUÇÕES DE USO:
    * DIGITE AS HORAS E OS MINUTOS NO TERMINAL, CASO SEJAM INVÁLIDOS, SERÁ PEDIDO NOVAMENTE;
    * USE A TECLA '1' DO KEYPAD PARA DECREMENTAR AS HORAS;
    * USE A TECLA '2' DO KEYPAD PARA INCREMENTAR AS HORAS;
    * USE A TECLA '4' DO KEYPAD PARA DECREMENTAR OS MINUTOS;
    * USE A TECLA '5' DO KEYPAD PARA INCREMENTAR OS MINUTOS;
    * A HORA ATUAL SERÁ EXIBIDA TANTO NO TERMINAL QUANTO NO DISPLAY.
*/

#include <LiquidCrystal.h>
#include <Keypad.h>

const byte ROWS = 4;
const byte COLS = 4; 
static const unsigned long REFRESH_INTERVAL = 1000;
static unsigned long lastMillis = 0;
int H = 55;
int M = 100;

char hexaKeys[ROWS][COLS] = {
{'7','8','9','/'},
{'4','5','6','X'},
{'1','2','3','-'},
{'C','0','=','+'}
};

byte rowPins[ROWS] = {28, 29, 30, 31};
byte colPins[COLS] = {32, 33, 34, 35}; 

Keypad customKeypad = Keypad( makeKeymap(hexaKeys), rowPins, colPins, ROWS, COLS);
LiquidCrystal lcd(22, 23, 24, 25, 26, 27);

void setup()
{
  
  lcd.begin(16, 2);
  
  Serial.begin(9600);
  
  iniciaRelogio();

}

void iniciaRelogio()
{
  
  Serial.setTimeout(1000);
  
  while(H > 23)
  {
    Serial.println("DIGITE A HORA: ");
    Serial.setTimeout(1000);
    
    while(Serial.available()==0);
      H = Serial.parseInt();
      
    Serial.println(H);
  }
  
  while(M>59)
  {
    Serial.println("DIGITE OS MINUTOS: ");
    Serial.setTimeout(10000);
    
    while(Serial.available()==0);
      M = Serial.parseInt();
      
    Serial.println(M);
  } 
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
  if (millis() - lastMillis >= REFRESH_INTERVAL)
  {
    lastMillis = millis(); //get ready for the next iteration
    imprimirHora();
  }
}
