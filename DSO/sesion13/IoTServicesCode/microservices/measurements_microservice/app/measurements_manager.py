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
    r = {}
    with mydb.cursor() as mycursor:
        mycursor.execute("SELECT temperature, humidity FROM sensor_data ORDER BY id DESC LIMIT 1;")
        myresult = mycursor.fetchall()
        for temperature, humidity in myresult:
            r = {"temperature": temperature, "humidity": humidity}
        mydb.commit()
    return r

def measurements_register(params):
    mydb = connect_database()
    with mydb.cursor() as mycursor:
        sql = "INSERT INTO sensor_data (temperature, humidity) VALUES (%s, %s)"
        val = (params["temperature"], params["humidity"])
        mycursor.execute(sql, val)
        mydb.commit()
        print(mycursor.rowcount, "record inserted.")