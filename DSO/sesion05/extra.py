import signal
import RPi.GPIO as GPIO
import time
import sys

# set GPIO Pins
pingTrigger = 18
pinEcho = 24
pinLEDD = 2
pinLEDL = 19
pinLDR = 4
BUTTON_GPIO = 16


def close(signal, frame):
    print("\nStopping...\n")
    GPIO.cleanup()
    sys.exit(0)

def rc_time(pin_to_circuit):
    count = 0

    # output on the pin for
    GPIO.setup(pin_to_circuit, GPIO.OUT)
    GPIO.output(pin_to_circuit, GPIO.LOW)
    time.sleep(0.1)

    # change the pin back to input
    GPIO.setup(pin_to_circuit, GPIO.IN)

    # count until the pin goes HIGH
    while GPIO.input(pin_to_circuit) == GPIO.LOW:
        count += 1
    return count

signal.signal(signal.SIGINT, close)

# set GPIO input and output chanels
GPIO.setmode(GPIO.BCM)
GPIO.setup(pingTrigger, GPIO.OUT)
GPIO.setup(pinEcho, GPIO.IN)
GPIO.setup(pinLEDD, GPIO.OUT)
GPIO.setup(pinLEDL, GPIO.OUT)
GPIO.setup(BUTTON_GPIO, GPIO.IN, pull_up_down=GPIO.PUD_UP)

def light():
    while True:
        brightness = rc_time(pinLDR)
        print(brightness)
        if brightness > 700000:
            GPIO.output(pinLEDL, GPIO.HIGH)
            print("Esta oscuro")
        else:
            GPIO.output(pinLEDL, GPIO.LOW)

        if not GPIO.input(BUTTON_GPIO):
            print("Cambio a sensor de distancia")
            return 1
            time.sleep(0.1)

def distance():
    while True:
        # set Trigger to HIGH
        GPIO.output(pingTrigger, True)
        # set Trigger afete 0.01ms to LOW
        time.sleep(0.00001)
        GPIO.output(pingTrigger, False)

        startTime = time.time()
        stopTime = time.time()

        # save start time
        while 0 == GPIO.input(pinEcho):
            startTime = time.time()

        # save time of arrival
        while 1 == GPIO.input(pinEcho):
            stopTime = time.time()

        # time difference between start and arrival
        TimeElapse = stopTime - startTime
        # multiply with the sonic speec (34300 cm/s)
        # and divide by 2, because there and back
        distance = (TimeElapse * 34300) / 2
        # Consideramos que un objeto esta cerca del sensor si se encuentra a menos de 7cm del mismo
        if distance > 7:
            GPIO.output(pinLEDD, GPIO.LOW)
            print("El objeto no esta cerca")
        else:
            GPIO.output(pinLEDD, GPIO.HIGH)

        print("Distance: %.1f cm" % distance)
        time.sleep(1)
        if not GPIO.input(BUTTON_GPIO):
            print("Cambio a sensor de luz")
            return 1
            time.sleep(0.1)

if __name__ == '__main__':
    while True:
        light()
        distance()
