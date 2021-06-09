import time
import paho.mqtt.client as paho
from measurement_register_interface import *
from device_register_interface import *
import os

current_temperature = "0"
current_temperature = 0
current_humidity = 0


def on_connect(client, userdata, flags, rc):
    if rc == 0:
        print("Connected success")
        client.subscribe("/uc3m/classrooms/leganes/myclass/temperature")
        client.subscribe("/uc3m/classrooms/leganes/myclass/humidity")
        client.subscribe("/uc3m/classrooms/leganes/myclass/device_info")
    else:
        print("Connected fail with code", {rc})


def on_message(client, userdata, message):
    global current_temperature, current_humidity
    print("received message =", str(message.payload.decode("utf-8")))
    if message.topic == "/uc3m/classrooms/leganes/myclass/temperature":
        current_temperature = float(message.payload.decode("utf-8"))
        data = {"temperature": current_temperature, "humidity": current_humidity}
        submit_data_to_store(data)
        print(data)
    if message.topic == "/uc3m/classrooms/leganes/myclass/humidity":
        current_humidity = float(message.payload.decode("utf-8"))
        data = {"temperature": current_temperature, "humidity": current_humidity}
        submit_data_to_store(data)
        print(data)
    if message.topic == "/uc3m/classrooms/leganes/myclass/device_info":
        r = message.payload.decode("utf-8")
        data = {"device": r}
        submit_device_info_to_store(data)
        print(data)


client = paho.Client()
client.username_pw_set(username=os.getenv('BROKER_USER'), password=os.getenv('BROKER_PWD'))
client.on_connect = on_connect
client.on_message = on_message
print("connecting to broker ", os.getenv('BROKER_ADDRESS'))
client.connect(os.getenv('BROKER_ADDRESS'), int(os.getenv('BROKER_PORT')), int(os.getenv('BROKER_KEEP_ALIVE')))  # connect
client.loop_forever()