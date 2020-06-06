import re
import ssl
import urllib.request
import gspread
from oauth2client.service_account import ServiceAccountCredentials

from bs4 import BeautifulSoup

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

scope = ['https://spreadsheets.google.com/feeds', 'https://www.googleapis.com/auth/drive']
creds = ServiceAccountCredentials.from_json_keyfile_name('TorneoLoL-91e815443db5.json', scope)
client = gspread.authorize(creds)

sheet = client.open('SOLOQCHALLENGE').sheet1

col = sheet.col_values(3)

for i in range(5, len(col)):
    nombre = col[i]
    if not nombre:
        exit(0)

    url = 'https://euw.op.gg/summoner/userName=' + nombre
    html = urllib.request.urlopen(url, context=ctx).read()
    soup = BeautifulSoup(html, 'lxml')

    # Lista de tags pedidos
    tags = soup('div')
    lst = list()

    # <div class="TierRank">Bronze 2</div>

    for j in tags:
        k = re.findall(".*TierRank\">([A-Za-z]+\s[0-9])", str(j))
        if k:
            print('Rank', nombre, ':\t \t ', k[0])
            break