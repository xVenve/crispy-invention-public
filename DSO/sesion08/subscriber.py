import paho.mqtt.client as mqtt


def on_connect(client, userdata, flags, rc):
    print("Connected with result code ", rc)
    client.subscribe("raspberry/topic")


def on_message(client, userdata, msg):
    print({msg.topic}, {msg.payload})


client = mqtt.Client()
client.username_pw_set(username="dso_server27", password="JoCa18")
client.on_connect = on_connect
client.on_message = on_message
client.will_set('raspberry/topic', '{"status":"Off"}')
client.connect("34.89.221.241", 1883, 60)
client.loop_forever()
