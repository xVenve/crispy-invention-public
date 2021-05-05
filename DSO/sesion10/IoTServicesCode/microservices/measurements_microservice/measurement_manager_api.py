from flask import Flask, request
from flask_cors import CORS
from utils.load_preferences import getPreferences

from measurements_manager import *

app = Flask(__name__)
CORS(app)


@app.route('/measurements/register/', methods=['POST'])
def set_measurement():
    measurement_params = request.get_json()
    measurements_register(measurement_params)
    return {"result": "record inserted"}, 201


@app.route('/measurements/retrieve/')
def get_measurements():
    return measurements_retriever()


params = getPreferences("microservice_conf.yaml")
app.run(host=params["host"], port=params["port"])
