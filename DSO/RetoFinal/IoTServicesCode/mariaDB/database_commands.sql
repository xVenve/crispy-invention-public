create database iot_data;

grant all privileges on iot_data.* TO 'iot_user'@'%' identified by '9R[-RP#64nY7*E*H';

flush privileges;

use iot_data;

CREATE TABLE sensor_data (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    humidity float NOT NULL,
    temperature float NOT NULL,
    device varchar(50) NOT NULL,
    date varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

SELECT * FROM sensor_data ORDER BY id DESC;

CREATE TABLE devices (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    device_id varchar(50) NOT NULL,
    location varchar(50) NOT NULL,
    date varchar(50) NOT NULL,
    status varchar(50) NOT NULL,
    UNIQUE (device_id),
    PRIMARY KEY (id)
);

SELECT * FROM devices ORDER BY id DESC;