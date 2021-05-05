import paho.mqtt.client as mqtt
import time


def on_connect(client, userdata, flags, rc):
    if rc == 0:
        print("Connected successfully")
    else:
        print("Connected fail with code", {rc})


client = mqtt.Client()


def make_connection():
    client.username_pw_set(username="dso_server27", password="JoCa18")
    client.on_connect = on_connect
    client.connect("35.198.78.34", 1883, 60)


def send_temperature(temperature):
    client.publish('temperature', payload=temperature, qos=0, retain=False)
    time.sleep(1)


def send_humidity(humidity):
    client.publish('humidity', payload=humidity, qos=0, retain=False)
    time.sleep(1)
