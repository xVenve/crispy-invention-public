import paho.mqtt.client as mqtt


def on_connect(client, userdata, flags, rc):
    if rc == 0:
        print("Connected successfully")
    else:
        print("Connected fail with code", {rc})


client = mqtt.Client()
client.username_pw_set(username="dso_server27", password="JoCa18")
client.on_connect = on_connect
client.connect("34.89.221.241", 1883, 60)
client.loop_forever()
