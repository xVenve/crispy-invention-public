import requests
from utils.load_preferences import getPreferences


def submit_device_info_to_store(data):
    params = getPreferences("devices_microservice_connector.yaml")
    response = requests.post('http://' + params["server"] + ':' + params["port"] + '/devices/register', json=data)
    return response.content