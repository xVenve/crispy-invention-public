import json
import paho.mqtt.client as mqtt

my_json = []
current_temperature = "0"
current_humidity = "0"


def on_connect(client, userdata, flags, rc):
    print("Connected with result code ", rc)
    client.subscribe("temperature")
    client.subscribe("humidity")


def on_message(client, userdata, msg):
    global current_temperature, current_humidity, my_json
    if msg.topic == "temperature":
        current_temperature = msg.payload.decode()
        print(msg.topic, "is", current_temperature)
    if msg.topic == "humidity":
        current_humidity = msg.payload.decode()
        print(msg.topic, "is", current_humidity)
    print(current_temperature, current_humidity)
    my_json.append({'temperature': current_temperature, 'humidity': current_humidity})
    with open('weather.json', 'w') as json_file:
        json.dump(my_json, json_file)


client = mqtt.Client()
client.username_pw_set(username="dso_server27", password="JoCa18")
client.on_connect = on_connect
client.on_message = on_message
client.will_set('temperature', '{"status":"Off"}')
client.will_set('humidity', '{"status":"Off"}')
client.connect("35.198.78.34", 1883, 60)
client.loop_forever()
