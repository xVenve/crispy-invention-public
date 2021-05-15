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
        raw_data = message.payload.decode("utf-8")
        tempTime = raw_data.split(",")
        current_temperature = float(tempTime[0])
        current_time = tempTime[1]
        current_device = tempTime[2]
        data = {"temperature": current_temperature, "humidity": current_humidity, "date": current_time,
                "device": current_device}
        submit_data_to_store(data)
        print(data)
    if message.topic == "/uc3m/classrooms/leganes/myclass/humidity":
        raw_data = message.payload.decode("utf-8")
        HumTime = raw_data.split(",")
        current_humidity = float(HumTime[0])
        current_time = HumTime[1]
        current_device = HumTime[2]
        data = {"temperature": current_temperature, "humidity": current_humidity, "date": current_time,
                "device": current_device}
        submit_data_to_store(data)
        print(data)
    if message.topic == "/uc3m/classrooms/leganes/myclass/device_info":
        raw_data = message.payload.decode("utf-8")
        idLocation = raw_data.split(",")
        r = idLocation[0]
        location = idLocation[1]
        date = idLocation[2]
        status = idLocation[3]
        data = {"device": r, "location": location, "date": date, "status": status}
        submit_device_info_to_store(data)
        print(data)


client = paho.Client()
client.username_pw_set(username=os.getenv('BROKER_USER'), password=os.getenv('BROKER_PWD'))
client.on_connect = on_connect
client.on_message = on_message
print("connecting to broker ", os.getenv('BROKER_ADDRESS'))
client.connect(os.getenv('BROKER_ADDRESS'), int(os.getenv('BROKER_PORT')), int(os.getenv('BROKER_KEEP_ALIVE')))  # connect
client.loop_forever()
