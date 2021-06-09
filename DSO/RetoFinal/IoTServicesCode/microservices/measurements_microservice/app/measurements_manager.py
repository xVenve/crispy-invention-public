import json

import mysql.connector
import os


def connect_database():
    mydb = mysql.connector.connect(
        host=os.getenv('DBHOST'),
        user=os.getenv('DBUSER'),
        password=os.getenv('DBPASSWORD'),
        database=os.getenv('DBDATABASE')
    )
    return mydb


def measurements_retriever():
    mydb = connect_database()
    r = []
    with mydb.cursor() as mycursor:
        mycursor.execute(
            "SELECT temperature, humidity, date, device FROM sensor_data ORDER BY date;")
        myresult = mycursor.fetchall()
        for temperature, humidity, date, device in myresult:
            r.append({"temperature": temperature, "humidity": humidity,
                      "date": date, "device": device})
        mydb.commit()
    result = json.dumps(r, sort_keys=True)
    return result


def measurements_register(params):
    mydb = connect_database()
    with mydb.cursor() as mycursor:
        sql = "INSERT INTO sensor_data (temperature, humidity, date, device) VALUES (%s, %s, %s, %s)"
        val = (params["temperature"], params["humidity"], params["date"], params["device"])
        mycursor.execute(sql, val)
        mydb.commit()
        print(mycursor.rowcount, "record inserted.")
