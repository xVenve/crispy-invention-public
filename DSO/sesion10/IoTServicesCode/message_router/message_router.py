import paho.mqtt.client as mqtt
from measurement_register_interface import submit_data_to_store
from device_register_interface import submit_device_info_to_store
from utils.load_preferences import getPreferences

current_temperature = "0"
current_humidity = "0"


def on_connect(client_connected, userdata, flags, rc):
    if rc == 0:
        print("Connected success")
        client_connected.subscribe("/uc3m/classrooms/leganes/myclass/temperature")
        client_connected.subscribe("/uc3m/classrooms/leganes/myclass/humidity")
        client_connected.subscribe("/uc3m/classrooms/leganes/myclass/device_info")
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


params = getPreferences("conf.yaml")
client = mqtt.Client()
client.username_pw_set(username=params["broker_user"], password=params["broker_pwd"])
client.on_connect = on_connect
client.on_message = on_message
print("connecting to broker ", params["broker_address"])
client.connect(params["broker_address"], params["broker_port"], params["broker_keep_alive"])
client.loop_forever()
