from flask import Flask
from flask_cors import CORS
import requests
from load_preferences import getPreferences

app = Flask(__name__)
CORS(app)


@app.route('/dso/measurements/')
def get_sensor_data():
    params = getPreferences("webapp_conf.yaml")
    measurements_microservice_server = params["measurements_microservice_server"]
    measurements_microservice_port = str(params["measurements_microservice_port"])
    response = requests.get(
        'http://' + measurements_microservice_server + ':' + measurements_microservice_port + '/measurements/retrieve/')
    return response.content


@app.route('/dso/devices/')
def get_device_list():
    params = getPreferences("webapp_conf.yaml")
    devices_microservice_server = params["devices_microservice_server"]
    devices_microservice_port = str(params["devices_microservice_port"])
    response = requests.get(
        'http://' + devices_microservice_server + ':' + devices_microservice_port + '/devices/retrieve/')
    return response.content


params = getPreferences("webapp_conf.yaml")
app.run(host=params["host"], port=params["port"])
