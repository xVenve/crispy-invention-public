import Adafruit_DHT
import uuid
import threading
from datetime import datetime

from RPi import GPIO

from publisher import *
import serial
import pynmea2
import I2C_LCD_driver

temp_global = 0
hum_global = 0
end = 0
showTemp = True
error = False
clear_lcd = False


def change_display(channel):
    global showTemp
    global clear_lcd
    showTemp = not showTemp
    clear_lcd = True


def tempHumSensor():
    dht_sensor = Adafruit_DHT.DHT11
    dht_pin = 4
    identifier = ':'.join(['{:02x}'.format((uuid.getnode() >> ele) & 0xff)
                           for ele in range(0, 8 * 6, 8)][::-1])

    minute = False
    start = time.time()
    global end
    new_temperature = 0
    new_humidity = 0

    global temp_global
    global hum_global
    global error

    while True:
        humidity, temperature = Adafruit_DHT.read(dht_sensor, dht_pin)

        end = time.time() - start
        if end >= 60:
            minute = True
            start = time.time()
        if temperature is not None and humidity is not None:
            if new_temperature != temperature or minute:
                new_temperature = temperature
                temp_global = temperature
                start = time.time()
                send_temperature(temperature, datetime.now().strftime("%d/%m/%Y %H:%M:%S"), identifier + " - Raspberry")
            if new_humidity != humidity or minute:
                new_humidity = humidity
                hum_global = humidity
                start = time.time()
                send_humidity(humidity, datetime.now().strftime("%d/%m/%Y %H:%M:%S"), identifier + " - Raspberry")
            if minute:
                minute = False
        else:
            error = True
        time.sleep(2)


def display():
    lcd = I2C_LCD_driver.lcd()

    global temp_global
    global hum_global
    global clear_lcd
    global error

    GPIO.setmode(GPIO.BCM)
    GPIO.setup(16, GPIO.IN, pull_up_down=GPIO.PUD_UP)
    GPIO.add_event_detect(16, GPIO.RISING, callback=change_display, bouncetime=50)

    try:
        while True:
            if clear_lcd:
                lcd.lcd_clear()
                clear_lcd = False
            if showTemp:
                lcd.lcd_display_string("Temp: %d%s C" % (temp_global, chr(223)), 1)
                lcd.lcd_display_string("Next update: %d" % (60 - end), 2)
            else:
                lcd.lcd_display_string("Humidity: %d %%" % hum_global, 1)
                lcd.lcd_display_string("Next update: %d" % (60 - end), 2)
            if error:
                lcd.lcd_clear()
                lcd.lcd_display_string("Sensor failure.", 1)
                lcd.lcd_display_string("Next update: %d" % (60 - end), 2)
                time.sleep(2)
                error = False
                lcd.lcd_clear()
    except KeyboardInterrupt:
        lcd.lcd_clear()


def weatherSensor():
    make_connection()
    identifier = ':'.join(['{:02x}'.format((uuid.getnode() >> ele) & 0xff)
                           for ele in range(0, 8 * 6, 8)][::-1])
    while True:
        send_id(identifier + " - Raspberry"+","+getLocation()+","+datetime.now().strftime("%d/%m/%Y %H:%M:%S"))
        print(identifier + " - Raspberry"+","+getLocation()+","+datetime.now().strftime("%d/%m/%Y %H:%M:%S"))
        time.sleep(3600)


def getLocation():
    while True:
        port = "/dev/ttyAMA0"
        ser = serial.Serial(port, baudrate=9600, timeout=0.5)
        dataout = pynmea2.NMEAStreamReader()
        newdata = ser.readline()

        if newdata[0:6] == "$GPRMC":
            newmsg = pynmea2.parse(newdata)
            lat = newmsg.latitude
            lng = newmsg.longitude
            gps = str(lat) + "; " + str(lng)
            return gps


if __name__ == "__main__":
    weatherSensor()
    sensor = threading.Thread(target=tempHumSensor)
    lcd = threading.Thread(target=display)

    sensor.start()
    lcd.start()
