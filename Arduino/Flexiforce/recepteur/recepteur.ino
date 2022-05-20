#include <SPI.h>
#include <RF24.h>
#include "packet.h"

RF24 radio(9, 10);
uint8_t address[6] = {122, 0xCE, 0xCC, 0xCE, 0xCC}; // Adresse du pipe
int rcv_val = 0;

packet_flexiforce recv;

void  print_packet(packet_flexiforce packet){
  for(int i=0;i<32;i++){
    Serial.print(packet.data[i]);
    Serial.print(" ");
  }
  Serial.println("");
}

void setup()
{
    Serial.begin(115200); // Initialiser la communication série
    Serial.println(F("Starting my first test"));

    radio.begin();
    radio.setChannel(122);
    radio.setDataRate(RF24_2MBPS);

    radio.openReadingPipe(0, address); // Ouvrir le Pipe en lecture
    radio.startListening();
}

void loop(void)
{
    unsigned long wait = micros();
    boolean timeout = false;

    while (radio.available())
    {
        radio.read(&recv, sizeof(packet_flexiforce));
        Serial.println(F("Packet received "));
        print_packet(recv);
    }
}
