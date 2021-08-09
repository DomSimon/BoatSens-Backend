
CREATE TABLE IF NOT EXISTS sensordata
(
    id   VARCHAR(60) DEFAULT  RANDOM_UUID() PRIMARY KEY,
    sensorname VARCHAR NOT NULL,
    sensordate VARCHAR NOT NULL,
    sensorvalue VARCHAR NOT NULL,
    sensortype VARCHAR NOT NULL


    );