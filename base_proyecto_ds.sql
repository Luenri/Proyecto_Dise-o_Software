drop database myhome;
create database myhome;
 use myhome;
 
 create  table  persona(
nombre varchar(30),
apellido varchar(30),
cedula varchar(10) primary key,
celular varchar(10),
correo varchar(100),
domicilido varchar(100),
telefonoTrabajo varchar(10),
estadoCivil varchar(15),
edad int,
activo int
);


create table empleado(
cargo varchar(30),
cedulaEmp varchar(10) primary key,
foreign key (cedulaEmp) references persona(cedula)
);


create table cliente (
direccionTrabajo varchar(100),
empresa varchar(20),
numhijos int,
cedulaClient varchar(10) primary key,
foreign key (cedulaClient) references persona(cedula)
);

create table casa (
metrosCuadrados decimal,
numPlantas int,
esquinera int,
orientacion varchar (30),
patioGrande int,
patiopequeño int,
numHabitaciones int,
numBaños int,
pisoPorcelanato varchar (30),
griferia varchar (30),
iluminacion varchar (30),
bañosInsonorizados int,
aislanteTermico int,
clienteID varchar (10),
foreign key (clienteID) references cliente(cedulaClient)
);

create table registro (
usuario varchar(10),
contrasena varchar(10),
cliente varchar(10),
foreign key (cliente) references empleado(cedulaEmp),
foreign key (cliente) references cliente(cedulaClient)
);