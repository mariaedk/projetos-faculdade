#include <LiquidCrystal.h>



LiquidCrystal lcd(8, 3, 4, 5, 6, 7); // RS, E, D4, D5, D6, D7




int H,M,S;



bool Atualizei = false;




//QUEREMOS ALGUEM QUE CHAME ESTA ROTINA
//A CADA 1 SEGUNDO!!!!!!!!!!!!!!!!!!!
void Atualiza_Hora()
{
S=S+1;
if(S==60)
{
S=0;
M=M+1;
if(M==60)
{
M=0;
H=H+1;
if(H==24)
H=0;
}
}
Atualizei = true;
}



void setup() {
H=23;
M=59;
S=57;
lcd.begin(16,2);
lcd.clear();
attachInterrupt(digitalPinToInterrupt(2), Atualiza_Hora, FALLING);
}



void loop()
{
delay(10000);
if(Atualizei==true)
{
lcd.setCursor(5,1);
if(H<10)
lcd.print('0');
lcd.print(H);
lcd.print(':');
if(M<10)
lcd.print('0');
lcd.print(M);
lcd.print(':');
if(S<10)
lcd.print('0');
lcd.print(S);
Atualizei = false;
}
}