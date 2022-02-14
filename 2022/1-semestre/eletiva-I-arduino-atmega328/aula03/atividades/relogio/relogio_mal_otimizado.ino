#include <LiquidCrystal.h>

LiquidCrystal lcd(2, 3, 4, 5, 6, 7);

int H,M,S;

void setup() 
{
  Serial.begin(9600);
  
  H = 0;
  M = 0;
  S = 0;
  lcd.begin(16,2);
  lcd.clear();
}


void loop() 
{
  lcd.setCursor(5,1);
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
  
  lcd.print(':');
  
  if (S < 10)
  {
  	lcd.print('0');
  }
  
  lcd.print(S);
  
  delay(1000);
  
  atualizaHora();
}

void atualizaHora()
{
  S = S + 1;
  if (S == 60)
  {
  	S = 0;
    M = M + 1;
    
    if (M == 60)
    {
      M = 0;
      H = H + 1;
      
      if (H = 24)
      {
      	H = 0;
      }
    }
  }
}



