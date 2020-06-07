import re
import ssl
import urllib.request
import gspread
import threading
from oauth2client.service_account import ServiceAccountCredentials

from bs4 import BeautifulSoup

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

lock = threading.Lock()


def getRank(nick):
    url = 'https://euw.op.gg/summoner/userName=' + nick
    html = urllib.request.urlopen(url, context=ctx).read()
    soup = BeautifulSoup(html, 'lxml')

    # List of tags
    tags = soup('div')

    # <div class="TierRank">Bronze 2</div>

    for j in tags:
        k = re.findall('.*TierRank">([A-Za-z]+\s[0-9])', str(j))
        if k:
            lock.acquire()
            print('Rank', nick, ':\t \t ', k[0])
            lock.release()
            break


if __name__ == "__main__":

    scope = ['https://spreadsheets.google.com/feeds', 'https://www.googleapis.com/auth/drive']
    credentials = ServiceAccountCredentials.from_json_keyfile_name('TorneoLoL-91e815443db5.json', scope)
    client = gspread.authorize(credentials)

    sheet = client.open('SOLOQCHALLENGE').sheet1

    col = sheet.col_values(3)
    threads = list()

    for i in range(5, len(col)):
        name = col[i]
        if not name:
            exit(0)
        exe = threading.Thread(target=getRank, args=(name,))
        threads.append(exe)
        exe.start()

    for i, thread in enumerate(threads):
        thread.join()
