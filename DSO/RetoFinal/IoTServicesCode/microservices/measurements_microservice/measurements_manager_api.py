from flask import Flask, request
from flask_cors import CORS
from load_preferences import getPreferences

from measurements_manager import *

app = Flask(__name__)
CORS(app)


@app.route('/measurements/register/', methods=['POST'])
def set_measurement():
    params = request.get_json()
    measurements_register(params)
    return {"result": "record inserted"}, 201


@app.route('/measurements/retrieve/')
def get_measurements():
    return measurements_retriever()


params = getPreferences("microservice_conf.yaml")
app.run(host=params["host"], port=params["port"])
