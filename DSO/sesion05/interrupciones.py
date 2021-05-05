import time
import RPi.GPIO as GPIO

BUTTON_GPIO = 16

if __name__ == '__main__':
    GPIO.setmode(GPIO.BCM)
    GPIO.setup(BUTTON_GPIO, GPIO.IN, pull_up_down=GPIO.PUD_UP)

    pressed = False

    while True:
        if not GPIO.input(BUTTON_GPIO):
            if not pressed:
                print("You've pressed the Button!")
                pressed = True
            else:
                pressed = False
            time.sleep(0.1)
