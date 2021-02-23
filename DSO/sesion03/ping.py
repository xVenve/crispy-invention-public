import re
import subprocess

host = 'jetbrains.com'
ping_output = subprocess.check_output(["ping", host, "-c 5"])

for line in ping_output.split('\n'):
    if re.match("\d+ bytes from", line):
        print(line)