create database iot_data;

grant all privileges on iot_data.* TO 'iot_user'@'%' identified by '9R[-RP#64nY7*E*H';

flush privileges;

use iot_data;

CREATE TABLE sensor_data (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    humidity float NOT NULL,
    temperature float NOT NULL,
    PRIMARY KEY (id)
);

SELECT temperature, humidity FROM sensor_data ORDER BY id DESC LIMIT 1;

CREATE TABLE devices (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    device_id varchar(50) NOT NULL,
    UNIQUE (device_id),
    PRIMARY KEY (id)
);

SELECT device_id FROM devices ORDER BY id DESC LIMIT 1;