import mysql.connector
from load_preferences import getPreferences


def connect_database():
    file = 'db_conf.yaml'
    params = getPreferences(file)

    mydb = mysql.connector.connect(
        host=params["dbhost"],
        user=params["dbuser"],
        password=params["dbpassword"],
        database=params["dbdatabase"]
    )
    return mydb


def devices_retriever():
    mydb = connect_database()
    r = {}
    with mydb.cursor() as mycursor:
        mycursor.execute("SELECT device_id, location, date FROM devices ORDER BY date;")
        myresult = mycursor.fetchall()
        for device_id, location, date in myresult:
            r = {"device_id": device_id, "location": location, "date": date}
        mydb.commit()
    return r


def devices_regiter(params):
    mydb = connect_database()
    with mydb.cursor() as mycursor:
        sql = "INSERT INTO devices (device_id, location, date) VALUES (%s, %s, %s)"
        val = (params["device"], params["location"], params["date"])
        try:
            mycursor.execute(sql, val)
            mydb.commit()
            print(mycursor.rowcount, "record inserted.")
        except:
            print("Error inserting the device")
# --------------------------------LEER---------------------------------------------------------------
        sql = "UPDATE devices SET location =%s, date=%s WHERE device_id='"+params["device"]+"'"
        val = (params["location"], params["date"])
        try:
            mycursor.execute(sql, val)
            mydb.commit()
            print(mycursor.rowcount, "record updated.")
        except:
            try:
                sql = "INSERT INTO devices (device_id, location, date) VALUES (%s, %s, %s)"
                val = (params["device"], params["location"], params["date"])
                mycursor.execute(sql, val)
                mydb.commit()
                print(mycursor.rowcount, "record inserted.")
            except:
                print("Error inserting the device")