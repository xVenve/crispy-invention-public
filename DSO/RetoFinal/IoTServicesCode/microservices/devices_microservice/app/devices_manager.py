import mysql.connector
import os
import json


def connect_database():
    mydb = mysql.connector.connect(
        host=os.getenv('DBHOST'),
        user=os.getenv('DBUSER'),
        password=os.getenv('DBPASSWORD'),
        database=os.getenv('DBDATABASE')
    )
    return mydb


def devices_retriever():
    mydb = connect_database()
    r = []
    with mydb.cursor() as mycursor:
        mycursor.execute(
            "SELECT device_id, location, date, status FROM devices ORDER BY date;")
        myresult = mycursor.fetchall()
        for device_id, location, date, status in myresult:
            r.append({"device_id": device_id, "location": location,
                 "date": date, "status": status})
        mydb.commit()
    result = json.dumps(r, sort_keys=True)
    return result

def devices_regiter(params):
	mydb = connect_database()
	with mydb.cursor() as mycursor:
         sql = "INSERT INTO devices (device_id, location, date, status) VALUES (%s, %s, %s, %s)"
         val = (params["device"], params["location"],
                params["date"], params["status"])
         try:
             mycursor.execute(sql, val)
             mydb.commit()
             print(mycursor.rowcount, "record inserted.")
         except:
             sql = "UPDATE devices SET location=%s, date=%s, status=%s WHERE device_id=%s"
             val = (params["location"], params["date"], params["status"], params["device"])
             mycursor.execute(sql, val)
             mydb.commit()
             print("Error inserting the device")
