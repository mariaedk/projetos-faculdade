// controla brilho da lâmpada ao mexer no potenciometro
// mesmo código pode ser usado para controlar o motor no potenciometro também


int analog;


void setup()
{
  
  Serial.begin(9600);
  
  analogReference(DEFAULT);

  pinMode(36, OUTPUT);

  //tone(38, 740, 200);
  //analogWrite(2,120);
}

void loop() 
{  
  analogRead(A1); // 0..1023 (0v e 5v) ==> 0..255

  // 5 parâmetros -> variável, mínimo, máximo q vc vai ler, mínimo, máximo que vai gerar
  analog = map(analogRead(A1), 0, 1023, 0, 255);

  analogWrite(2, analog);
}
