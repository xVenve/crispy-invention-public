import RPi.GPIO as GPIO
import time
import Adafruit_DHT


def Sensor():
    DHT_SENSOR = Adafruit_DHT.DHT11
    DHT_PIN = 4

    while True:
        humidity, temperature = Adafruit_DHT.read(DHT_SENSOR, DHT_PIN)
        if humidity is not None and temperature is not None:
            print("Temp={0:0.1f}C Humidity={1:0.1f}%".format(temperature, humidity))
            if temperature > 20:
                Servo(temperature - 24)
        else:
            print("Sensor failure. Check Wiring")
        time.sleep(3)


def Servo(vel):
    GPIO.setmode(GPIO.BCM)
    GPIO.setup(17, GPIO.OUT)
    p = GPIO.PWM(17, 50)
    p.start(7.5)

    try:
        y = 0

        if vel >= 10:
            y = 0.01
        if 8 <= vel < 10:
            y = 0.03
        if 6 <= vel < 8:
            y = 0.1
        if 4 <= vel < 6:
            y = 0.2
        if 2 <= vel < 4:
            y = 0.5

        for x in range(125, 15, -1):
            p.ChangeDutyCycle(x / 10)
            time.sleep(y)
        for x in range(15, 125, 1):
            p.ChangeDutyCycle(x / 10)
            time.sleep(y)
    except KeyboardInterrupt:
        p.stop()
        GPIO.cleanup()


if __name__ == "__main__":
    Sensor()
