#include <ESP8266WiFi.h>
#include <WiFiClientSecure.h>
#include <TelegramBot.h>

 
const char* ssid = "SF2";
const char* password = "9214336478";
const char BotToken[] = "829470729:AAHgoo9woTpGms1vxY6SVPDymLTvUPn_gQA";

WiFiClientSecure net_ssl; 
TelegramBot bot (BotToken, net_ssl); 
void setup()  
{   
Serial.begin(115200);   
while (!Serial) {}
delay(3000);   
// пытаемся соединиться с сетью Wifi   
Serial.print("Connecting Wifi: ");   
Serial.println(ssid);   
while (WiFi.begin(ssid, password) != WL_CONNECTED)  
      {   
  Serial.print(".");   
  delay(500);   
}   
Serial.println("");   
Serial.println("WiFi connected");   
bot.begin();   
}   
void loop()  
{   
message m = bot.getUpdates(); // Читаем новые сообщения   
if (m.text.equals("on"))  
      {   
  bot.sendMessage(m.chat_id, "The Led is now ON");   
}   
else if (m.text.equals("off"))  
      {   
  bot.sendMessage(m.chat_id, "The Led is now OFF");   
}   
}
