import requests
from load_preferences import getPreferences


def submit_device_info_to_store(data):
    params = getPreferences("devices_microservice_connector.yaml")
    r = requests.post('http://' + params["server"] + ':' + params["port"] + '/devices/register', json=data)
