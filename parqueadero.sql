CREATE DATABASE IF NOT EXISTS parqueadero;
USE parqueadero;

CREATE TABLE IF NOT EXISTS parqueadero.tipovehiculo(
idtipovehiculo bigint(19) primary key,
descripcion varchar(10) not null
);

INSERT INTO tipovehiculo VALUES (1, 'Automovil'), (2,'Moto');

CREATE TABLE IF NOT EXISTS parqueadero.espacio(
idespacio bigint(19)  primary key,
idtipovehiculo bigint(19) not null,
cantidadespacio integer not null,
CONSTRAINT FOREIGN KEY (idtipovehiculo) REFERENCES tipovehiculo(idtipovehiculo)
);

CREATE TABLE IF NOT EXISTS parqueadero.tarifa(
idtarifa bigint(19) primary key,
idtipovehiculo bigint(19) not null,
costohora bigint(19) not null,
costodia bigint(19) not null,
horascobrodia integer not null,
CONSTRAINT FOREIGN KEY (idtipovehiculo) REFERENCES tipovehiculo(idtipovehiculo)
);

CREATE TABLE IF NOT EXISTS parqueadero.vehiculo(
idvehiculo bigint(19) primary key,
placa varchar(10) not null,
idtipovehiculo bigint(19) not null,
cilindraje integer not null,
CONSTRAINT FOREIGN KEY (idtipovehiculo) REFERENCES tipovehiculo(idtipovehiculo)
);

CREATE TABLE IF NOT EXISTS parqueadero.registro(
idregistro bigint(19) primary key,
idvehiculo bigint(19) not null,
fechaentrada date not null,
fechasalida date not null,
horasparqueadero integer,
costoparquedareo bigint(19),
CONSTRAINT FOREIGN KEY (idvehiculo) REFERENCES vehiculo(idvehiculo)
);
