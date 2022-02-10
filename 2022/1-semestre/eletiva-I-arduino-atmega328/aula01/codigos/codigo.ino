void setup() 
{
  // CONFIGURANDO PINO 13 COMO SAIDA
  pinMode(13, OUTPUT);
  
  //pinMode(13, INPUT); --> DETERMINANDO COMO ENTRADA
}

void loop() 
{
  
  // FAZER O LED PISCAR -> MANDA SINAL ALTO E BAIXO -> ACENDE E APAGA
  // PINO 13 É DIGITAL
  
  // MANDOU ESCREVER ALTO NO PINO 13
  digitalWrite(13, HIGH);

  // parâmetro em milisegundos (1 segundo)
  delay(1000);

  // APAGA PINO 13 (SINAL BAIXO)
  digitalWrite(13, LOW);
  
}
