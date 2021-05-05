from flask import Flask
from flask_cors import CORS
import requests
from utils.load_preferences import getPreferences

app = Flask(__name__)
CORS(app)

@app.route('/dso/measurements/')
def get_sensor_data():
    sensor_params = getPreferences("webapp_conf.yaml")
    response = requests.get('http://' + sensor_params["measurements_microservice_server"] + ':' + str(sensor_params["measurements_microservice_port"]) + '/measurements/retrieve/')
    return response.content

@app.route('/dso/devices/')
def get_device_list():
    device_params = getPreferences("webapp_conf.yaml")
    response = requests.get('http://' + device_params["devices_microservice_server"] + ':' + str(device_params["devices_microservice_port"]) + '/devices/retrieve/')
    return response.content

params = getPreferences("webapp_conf.yaml")
app.run(host=params["host"], port=params["port"])
