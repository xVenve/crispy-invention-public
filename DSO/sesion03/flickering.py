import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(23, GPIO.OUT)
for i in range(50):
    GPIO.output(23, GPIO.HIGH)
    time.sleep(.02)
    GPIO.output(23, GPIO.LOW)
    time.sleep(.02)
