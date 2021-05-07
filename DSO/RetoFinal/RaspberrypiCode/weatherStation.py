import Adafruit_DHT
import uuid
import threading
from publisher import *
import serial
import pynmea2

temp_global = 0
hum_global = 0


def temperatureSensor():
    dht_sensor = Adafruit_DHT.DHT11
    dht_pin = 4

    new_temperature = 0
    while True:
        temperature_measurement = Adafruit_DHT.read(dht_sensor, dht_pin)[1]
        if temperature_measurement is not None:
            if new_temperature != temperature_measurement:
                new_temperature = temperature_measurement
                temp_global = temperature_measurement
                # send_temperature(temperature_measurement)
            print("Temp={0:0.1f}C".format(temperature_measurement))
        else:
            print("Sensor failure. Check wiring.")
            time.sleep(1)
        time.sleep(6)


def humiditySensor():
    dht_sensor = Adafruit_DHT.DHT11
    dht_pin = 4

    new_humidity = 0
    while True:
        humidity_measurement = Adafruit_DHT.read(dht_sensor, dht_pin)[0]
        if humidity_measurement is not None:
            if new_humidity != humidity_measurement:
                new_humidity = humidity_measurement
                hum_global = humidity_measurement
                # send_humidity(humidity_measurement)
            print("Hum={0:0.1f}%".format(humidity_measurement))
        else:
            print("Sensor failure. Check wiring.")
            time.sleep(1)
        time.sleep(6)


def weatherSensor():
    make_connection()
    identifier = ':'.join(['{:02x}'.format((uuid.getnode() >> ele) & 0xff)
                           for ele in range(0, 8 * 6, 8)][::-1])
    print(identifier)
    send_id(identifier + " - Raspberry 1")

def gpsSensor():
    while True:
        port = "/dev/ttyAMA0"
        ser = serial.Serial(port, baudrate=9600, timeout=0.5)
        dataout = pynmea2.NMEAStreamReader()
        newdata = ser.readline()

        if newdata[0:6] == "$GPRMC":
            newmsg = pynmea2.parse(newdata)
            lat = newmsg.latitude
            lng = newmsg.longitude
            gps = "Latitude=" + str(lat) + " and Longitude=" + str(lng)
            print(gps)

if __name__ == "__main__":
    # weatherSensor()
    temperature = threading.Thread(target=temperatureSensor)
    humidity = threading.Thread(target=humiditySensor)

    temperature.start()
    time.sleep(3)
    humidity.start()

    ## Pruebas
    gps = threading.Thread(target=gpsSensor)
    gps.start()
