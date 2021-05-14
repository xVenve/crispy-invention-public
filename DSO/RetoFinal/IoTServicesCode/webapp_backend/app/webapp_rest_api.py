from flask import Flask
from flask_cors import CORS
import requests
import os

app = Flask(__name__)
CORS(app)


@app.route('/dso/measurements/')
def get_sensor_data():
    response = requests.get(
        'http://' + os.getenv('MEASUREMENTS_MICROSERVICE_ADDRESS') + ':' + str(os.getenv('MEASUREMENTS_MICROSERVICE_PORT')) + '/measurements/retrieve/')
    return response.content


@app.route('/dso/devices/')
def get_device_list():
    response = requests.get(
        'http://' + os.getenv('DEVICES_MICROSERVICE_ADDRESS') + ':' + str(os.getenv('DEVICES_MICROSERVICES_PORT')) + '/devices/retrieve/')
    return response.content


app.run(host=os.getenv('HOST'), port=os.getenv('PORT'))
