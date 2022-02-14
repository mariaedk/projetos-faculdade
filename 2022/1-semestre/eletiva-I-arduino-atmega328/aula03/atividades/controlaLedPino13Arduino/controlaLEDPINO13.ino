const int LED = 13;
 
void setup() {
  Serial.begin(9600);    
  pinMode(LED,OUTPUT);   
}
 
void loop() {
   if (Serial.available()) //se byte pronto para leitura
   {
    
    switch(Serial.read())      //verifica qual caracter recebido
    {
      case 'A':                  //caso 'A'
      
        digitalWrite(LED,LOW); //inverte estado do LED
        
      break;

      case 'B':                  //caso 'B'
      
        digitalWrite(LED,HIGH); //inverte estado do LED
        
      break;
    }
  }
}
