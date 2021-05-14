import requests
import os

def submit_device_info_to_store(data):
    r = requests.post('http://' + os.getenv('DEVICES_MICROSERVICE_ADDRESS') + ':' + os.getenv('DEVICES_MICROSERVICE_PORT') + '/devices/register', json=data)
