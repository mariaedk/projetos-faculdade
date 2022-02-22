#include <LiquidCrystal.h>

int tfreq1, tfreq2, tfreq3, tfreq4;
int freq1Calculada, freq2Calculada, freq3Calculada, freq4Calculada;

int systick_freq1 = 0;
int systick_freq2 = 0;
int systick_freq3 = 0;
int systick_freq4 = 0;

void setup()
{
  Serial.begin(9600); //INICIALIZAÇÃO DA SERIAL
  pinMode(A0, OUTPUT);
  pinMode(A1, OUTPUT);
  pinMode(A2, OUTPUT);
  pinMode(A3, OUTPUT);

  digitalWrite(A0,LOW);
  digitalWrite(A1,LOW);
  digitalWrite(A2,LOW);
  digitalWrite(A3,LOW);

  leituraFrequencias();
}

void leituraFrequencias(){
  
  Serial.setTimeout(1000);

  Serial.println("DIGITE A FREQUENCIA PARA O PRIMEIRO LED: ");
  Serial.setTimeout(1000);
  
  while(Serial.available() == 0){}
  tfreq1 = Serial.parseInt();
 
  Serial.println(tfreq1);
 
  Serial.println("DIGITE A FREQUENCIA PARA O SEGUNDO LED: ");
  
  Serial.setTimeout(10000);
  while(Serial.available() == 0){}
  tfreq2 = Serial.parseInt();
    
  Serial.println(tfreq2);
  
  Serial.println("DIGITE A FREQUENCIA PARA O TERCEIRO LED: ");
  
  Serial.setTimeout(100000);
  while(Serial.available() == 0){}
  tfreq3 = Serial.parseInt();
    
  Serial.println(tfreq3);
  
  Serial.println("DIGITE A FREQUENCIA PARA O QUARTO LED: ");
  
  Serial.setTimeout(1000000);
  while(Serial.available() == 0){}
  tfreq4 = Serial.parseInt();
    
  Serial.println(tfreq4);

  converteFrequencias();
  } 

void converteFrequencias(){
  freq1Calculada = ((1000/tfreq1)/2);
 //Serial.println("CALCULADA 1");
 // Serial.println(freq1Calculada);
  freq2Calculada = ((1000/tfreq2)/2);
  // Serial.println("CALCULADA 2");
 // Serial.println(freq2Calculada);
  freq3Calculada = ((1000/tfreq3)/2);
   // Serial.println("CALCULADA 3");
 // Serial.println(freq3Calculada);
  freq4Calculada = ((1000/tfreq4)/2);
  // Serial.println("CALCULADA 4");
  //Serial.println(freq4Calculada);
}

void loop()
{
  if(systick_freq1 == freq1Calculada){
    digitalWrite(A0,!digitalRead(A0));
    systick_freq1 = 0;
  }
  if(systick_freq2 == freq2Calculada){
    digitalWrite(A1,!digitalRead(A1));
    systick_freq2 = 0;
  }
  if(systick_freq3 == freq3Calculada){
     digitalWrite(A2,!digitalRead(A2));
     systick_freq3 = 0;
  }
  if(systick_freq4 == freq4Calculada) {
     digitalWrite(A3,!digitalRead(A3));
     systick_freq4 = 0; 
  }
  systick_freq1++;
  systick_freq2++;
  systick_freq3++;
  systick_freq4++;
  delay(1);
}
