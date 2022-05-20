int ffs1 = A1;
int ffs2 = A2;
int ffs3 = A3;
int ffs4 = A4; // FlexiForce sensor is connected analog pin A0 of arduino or mega.

float vout;
void setup()
{
  Serial.begin(9600);
  pinMode(ffs1, INPUT);
  pinMode(ffs2, INPUT);
  pinMode(ffs3, INPUT);
  pinMode(ffs4, INPUT);
}

void loop()
{
  int ffsdata1 = analogRead(ffs1);
  int ffsdata2 = analogRead(ffs2);
  int ffsdata3 = analogRead(ffs3);
  int ffsdata4 = analogRead(ffs4);
  //vout = (ffsdata * 5.0) / 1023.0;
  //vout = vout * cf ;
  Serial.println("Flexi Force sensor: ");
  Serial.print(ffsdata1);
  Serial.print(" ");
  Serial.print(ffsdata2);
  Serial.print(" ");
  Serial.print(ffsdata3);
  Serial.print(" ");
  Serial.print(ffsdata4);
  Serial.print(" ");
  Serial.println("");
  delay(100);
}
