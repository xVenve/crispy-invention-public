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


def measurements_retriever():
    mydb = connect_database()
    r = {}
    with mydb.cursor() as mycursor:
        mycursor.execute("SELECT temperature, humidity, date, device FROM sensor_data ORDER BY date;")
        myresult = mycursor.fetchall() # MIRAR AQUI Y EN MEDIDAS SI SE PUEDE PASAR DIRECTANEMNTE MYRESULT Y EN EL JS RECORREMOS EL ARRAY DE LISTAS QUE SALE CON LOS VALORES Y ASI RELLENAMOS LA TABLA CADA VEZ
        for temperature, humidity, date, device in myresult:
            r = {"temperature": temperature, "humidity": humidity, "date": date, "device": device}
        mydb.commit()
    return r


def measurements_register(params):
    mydb = connect_database()
    with mydb.cursor() as mycursor:
        sql = "INSERT INTO sensor_data (temperature, humidity, date, device) VALUES (%s, %s, %s, %s)"
        val = (params["temperature"], params["humidity"], params["date"], params["device"])
        mycursor.execute(sql, val)
        mydb.commit()
        print(mycursor.rowcount, "record inserted.")
