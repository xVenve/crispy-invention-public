# insert IoT data into data store through REST API

import requests
from load_preferences import getPreferences


def submit_data_to_store(data):
    params = getPreferences("measurements_microservice_connector.yaml")
    r = requests.post('http://' + params["server"] + ':' + params["port"] + '/measurements/register', json=data)
