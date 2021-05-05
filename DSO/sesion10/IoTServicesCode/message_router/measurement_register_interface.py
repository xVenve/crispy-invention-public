import requests
from utils.load_preferences import getPreferences


def submit_data_to_store(data):
    params = getPreferences("measurements_microservice_connector.yaml")
    response = requests.post('http://' + params["server"] + ':' + params["port"] + '/measurements/register', json=data)
    return response.content