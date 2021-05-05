import RPi.GPIO as GPIO
import time
import Adafruit_DHT
import datetime
from datetime import date
from openpyxl import load_workbook
from publisher import *


def weatherSensor():
    DHT_SENSOR = Adafruit_DHT.DHT11
    DHT_PIN = 4

    make_connection()
    newtemperature = 0
    newhumidity = 0

    while True:
        today = date.today()
        now = datetime.datetime.now().time()
        humidity, temperature = Adafruit_DHT.read(DHT_SENSOR, DHT_PIN)

        if humidity is not None and temperature is not None:
            if newtemperature != temperature:
                newtemperature = temperature
                send_temperature(temperature)
            if newhumidity != humidity:
                newhumidity = humidity
                send_humidity(humidity)
            print("Temp={0:0.1f}C Humidity={1:0.1f}%".format(temperature, humidity))
        else:
            print("Sensor failure. Check wiring.")
        time.sleep(3)


if __name__ == '__main__':
    weatherSensor()
