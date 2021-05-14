import requests
import os

def submit_data_to_store(data):
    r = requests.post('http://' + os.getenv('MEASUREMENTS_MICROSERVICE_ADDRESS') + ':' + os.getenv('MEASUREMENTS_MICROSERVICE_PORT') + '/measurements/register', json=data)
