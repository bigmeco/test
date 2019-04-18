#include <MemoryFree.h>
#include <EEPROM.h>
#include <Servo.h> 
#define PIN_LED 13    // вывод светодиода
String inString;
// Пин для сервопривода
int servoPin = 3;
// Создаем объект
Servo Servo1;
// Настройка
void setup() {
  // Инициализация портов и выходов
  Serial.begin(115200);
  Serial3.begin(115200);
  pinMode(PIN_LED, OUTPUT);
  digitalWrite(PIN_LED, LOW);
    Servo1.attach(servoPin);
}








void loop(){

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
          delay(1000);
          Servo1.write(45);
                    delay(1000);

 Servo1.write(85);
           delay(1000);

 Servo1.write(5);
           delay(1000);

  Servo1.write(45);
            delay(1000);

          Servo1.write(0);
        digitalWrite(PIN_LED, LOW);

      }
      else if (inString.indexOf("[OFF]")>0) {
        digitalWrite(PIN_LED, LOW);
          Servo1.write(180);

      }
      else
      {
        Serial.println("Wrong command");
      }
      inString = "";
    }
  }
}
