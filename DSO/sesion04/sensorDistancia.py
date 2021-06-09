import signal
import RPi.GPIO as GPIO
import time
import sys

pingTrigger = 18
pinEcho = 24


def close(signal, frame):
    print("\nTurning off ultrasonic distance detection...\n")
    GPIO.cleanup()
    sys.exit(0)


signal.signal(signal.SIGINT, close)

GPIO.setmode(GPIO.BCM)
GPIO.setup(pingTrigger, GPIO.OUT)
GPIO.setup(pinEcho, GPIO.IN)

while True:
    GPIO.output(pingTrigger, True)
    time.sleep(0.00001)
    GPIO.output(pingTrigger, False)

    startTime = time.time()
    stopTime = time.time()

    while 0 == GPIO.input(pinEcho):
        startTime = time.time()

    while 1 == GPIO.input(pinEcho):
        stopTime = time.time()

    TimeElapse = stopTime - startTime

    distance = (TimeElapse * 34300) / 2

    print("Distance: %.1f cm" % distance)
    time.sleep(1)
