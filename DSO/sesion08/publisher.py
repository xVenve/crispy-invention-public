import paho.mqtt.client as mqtt
import time


def on_connect(client, userdata, flags, rc):
    print("Connected with result code ", rc)


client = mqtt.Client()
client.username_pw_set(username="dso_server27", password="JoCa18")
client.on_connect = on_connect
client.connect("34.89.221.241", 1883, 60)
for i in range(5):
    client.publish('raspberry/topic', payload=i, qos=0, retain=False)
    print("send ", {i}, "to raspberry/topic")
    time.sleep(1)
client.loop_forever()
