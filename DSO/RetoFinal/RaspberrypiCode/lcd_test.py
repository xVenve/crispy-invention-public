import time

import Adafruit_DHT

import I2C_LCD_driver

display = I2C_LCD_driver.lcd()

dht_sensor = Adafruit_DHT.DHT11
dht_pin = 4

try:
    while True:
        humidity, temperature = Adafruit_DHT.read(dht_sensor, dht_pin)
        if temperature is not None and humidity is not None:
            display.lcd_display_string("Temp: %d%s C" % (temperature, chr(223)), 1)
            display.lcd_display_string("Humidity: %d %%" % humidity, 2)
        else:
            display.lcd_clear()
            display.lcd_display_string("Sensor failure.", 1)
            display.lcd_display_string("Check wiring.", 2)
            display.lcd_clear()
        time.sleep(3)
except KeyboardInterrupt:
    display.lcd_clear()
