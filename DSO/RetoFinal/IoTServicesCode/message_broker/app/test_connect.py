import paho.mqtt.client as mqtt


def on_connect(client, userdata, flags, rc):
    if rc == 0:
        print("Connected success")
    else:
        print("Connected fail with code", {rc})


client = mqtt.Client()
client.username_pw_set(username="dso_server27", password="JoCa18")
client.on_connect = on_connect
client.connect("34.89.191.75", 1883, 60)  # IP message_broker
client.loop_forever()
