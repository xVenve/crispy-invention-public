import I2C_LCD_driver
from time import *

# Load the driver and set it to "display"
# If you use something from the driver library use the "display." prefix first
display = I2C_LCD_driver.lcd()

# Main body of code
try:
    while True:
        # Remember that your sentences can only be 16 characters long!
        print("Writing to display")
        display.lcd_display_string("Hola papa!", 1)  # Write line of text to first line of display
        display.lcd_display_string("Lo he conseguido", 2)  # Write line of text to second line of display
        sleep(2)                                           # Give time for the message to be read
        display.lcd_clear()                                # Clear the display of any data
        sleep(2)                                           # Give time for the message to be read
except KeyboardInterrupt:
    # If there is a KeyboardInterrupt (when you press ctrl+c), exit the program and cleanup
    print("Cleaning up!")
    display.lcd_clear()