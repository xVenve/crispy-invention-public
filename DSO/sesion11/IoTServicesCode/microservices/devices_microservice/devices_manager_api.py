from flask import Flask, request
from flask_cors import CORS
from load_preferences import getPreferences

from devices_manager import *

app = Flask(__name__)
CORS(app)


@app.route('/devices/register/', methods=['POST'])
def save_deviceinfo():
    params = request.get_json()
    devices_regiter(params)
    return {"result": "record inserted"}, 201


@app.route('/devices/retrieve/')
def retrieve_devices():
    return devices_retriever()


params = getPreferences("microservice_conf.yaml")
app.run(host=params["host"], port=params["port"])
