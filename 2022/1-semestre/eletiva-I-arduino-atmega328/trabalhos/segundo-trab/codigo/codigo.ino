#include <LiquidCrystal.h>

const int sensorPin = A0; //PINO ANALÓGICO UTILIZADO PELO SENSOR
int temperatura = 0; //VARIÁVEL DO TIPO FLOAT
int divisao = 0;
int resto = 0;

float tempNaoConvertida;

byte Vazio[] = {
  B00000,
  B00000,
  B00000,
  B00000,
  B00000,
  B00000,
  B00000,
  B00000
};

byte UmaBarra[] = {
  B10000,
  B10000,
  B10000,
  B10000,
  B10000,
  B10000,
  B10000,
  B10000
};

byte DuasBarras[] = {
  B11000,
  B11000,
  B11000,
  B11000,
  B11000,
  B11000,
  B11000,
  B11000
};

byte TresBarras[] = {
  B11100,
  B11100,
  B11100,
  B11100,
  B11100,
  B11100,
  B11100,
  B11100
};

byte QuatroBarras[] = {
  B11110,
  B11110,
  B11110,
  B11110,
  B11110,
  B11110,
  B11110,
  B11110
};

byte CincoBarras[] = {
  B11111,
  B11111,
  B11111,
  B11111,
  B11111,
  B11111,
  B11111,
  B11111
};

LiquidCrystal lcd(22, 23, 24, 25, 26, 27);

void setup()
{
  Serial.begin(9600); //INICIALIZAÇÃO DA SERIAL
  lcd.begin(16, 2);
  lcd.createChar(0, Vazio);
  lcd.createChar(1, UmaBarra);
  lcd.createChar(2, DuasBarras);
  lcd.createChar(3, TresBarras);
  lcd.createChar(4, QuatroBarras);
  lcd.createChar(5, CincoBarras);
}

float tempFloat;
int tempInt;
float sub;

void loop()
{

  tempNaoConvertida = analogRead(sensorPin);
  temperatura = (analogRead(sensorPin) * 0.0048828125 * 100);//VARIÁVEL RECEBE A TEMPERATURA MEDIDA
  
  tempFloat = (analogRead(sensorPin) * 0.0048828125 * 100);
  tempInt = (int) tempFloat;
  sub = (tempFloat - tempInt);
  
  if(sub >= 0.5)
  {
    tempInt++;
  }
  temperatura = tempInt;
  
  if (temperatura > 80)
  {
    lcd.clear();
    lcd.setCursor(0,0);
    lcd.print("TEMPERATURA ALTA");
  }
  else if (temperatura < 81)
  {
  
    lcd.clear();
    lcd.setCursor(0,0);
    
    lcd.print(String("TEMPERATURA: ") + String(temperatura));
    divisao = temperatura/5;
    resto = temperatura%5;

    lcd.setCursor(0,1);
    
    
    while(divisao > 0) 
    {
      lcd.write((byte) 5); // barra inteira
      divisao--;
    }
    switch(resto) 
    {
      case 0:
      lcd.write((byte) 0); // vazio
      break;
      case 1:
      lcd.write((byte) 1); // uma barra
      break;
      case 2:
      lcd.write((byte) 2); // 2 barra
      break;
      case 3:
      lcd.write((byte) 3); // 3 barra
      break;
      case 4:
      lcd.write((byte) 4); // 4 barra
      break;
    }
  }

  delay(1000); //INTERVALO DE 1 SEGUNDO (1000 MILISSEGUNDOS)
}
