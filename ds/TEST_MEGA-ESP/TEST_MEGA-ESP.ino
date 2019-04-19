#include <MemoryFree.h>
#include <EEPROM.h>
#include <Servo.h> 

#define PIN_LED 13    // вывод светодиода
#define PIN_LED_JSON 3    // вывод светодиода
int servoPin = 3;

String inString;

Servo Servo1;

// Настройка
void setup() {
  // Инициализация портов и выходов
  Serial.begin(115200);
  Serial3.begin(115200);
  pinMode(PIN_LED, OUTPUT);
    pinMode(PIN_LED_JSON, OUTPUT);

  digitalWrite(PIN_LED, LOW);
    digitalWrite(PIN_LED_JSON, LOW);
      Servo1.attach(servoPin);

}

// Выполнение
void loop() {
}

// Проверка события на порту Serial3
void serialEvent3() {
  while (Serial3.available()) {
    // Чтение данных из порта Serial3
    char inChar = Serial3.read();
    // Вывод прочитанных данных в порт Serial
    Serial.write(inChar);
    // Поиск команды в полученных данных (команда должна быть в квадратных скобках)
    inString += inChar;
    if (inChar == ']') {
      if (inString.indexOf("[ON]")>0) {
        digitalWrite(PIN_LED, HIGH);
      }
      else if (inString.indexOf("[OFF]")>0) {
        digitalWrite(PIN_LED, LOW);
      }
       else if (inString.indexOf("[json]")>0) {

                         // Servo1.write(a);
                                  Serial.println(inString+"  test");
      }
      else
      {
        String T1=inString.substring(inString.indexOf("[")+1,inString.indexOf("]")); 
                  delay(1000); 

                  Servo1.write(T1.toInt()*3); 
                                                    Serial.println(String(T1.toInt())+"  test");
   
                  delay(1000); 


      }
      inString = "";
    }
  }
}
