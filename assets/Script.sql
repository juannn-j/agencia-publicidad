CREATE TABLE EMPLEADO (
    id_emp SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    dni VARCHAR(20) NOT NULL,
    usuario VARCHAR(50) NOT NULL,
    passwd VARCHAR(100) NOT NULL
);

CREATE TABLE PUBLICIDAD (
    id_pub SERIAL PRIMARY KEY,
    descp TEXT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    contacto INT NOT NULL,
    imagen TEXT NOT NULL
);

CREATE TABLE CLIENTE (
    id_cli SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    birthdate DATE NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    direccion TEXT NOT NULL,
    dni VARCHAR(20) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    gusto TEXT NOT NULL
);

CREATE TABLE PUB_EMP_CLI (
    id_pub_cli SERIAL PRIMARY KEY,
    fecha DATE NOT NULL,
    id_emp INT NOT NULL,
    id_cli INT NOT NULL,
    id_pub INT NOT NULL,
    CONSTRAINT fk_pubempcli_empleado FOREIGN KEY (id_emp) REFERENCES EMPLEADO(id_emp),
    CONSTRAINT fk_pubempcli_cliente FOREIGN KEY (id_cli) REFERENCES CLIENTE(id_cli),
    CONSTRAINT fk_pubempcli_publicidad FOREIGN KEY (id_pub) REFERENCES PUBLICIDAD(id_pub)
);

CREATE TABLE CLIENTE_CORREO (
    id_cli_cor SERIAL PRIMARY KEY,
    correo VARCHAR(100) NOT NULL,
    proveedor VARCHAR(50) NOT NULL,
    id_cli INT NOT NULL,
    CONSTRAINT fk_clientecorreo_cliente FOREIGN KEY (id_cli) REFERENCES CLIENTE(id_cli)
);

CREATE TABLE CLIENTE_SOCIAL (
    id_cli_soc SERIAL PRIMARY KEY,
    usuario VARCHAR(100) NOT NULL,
    proveedor VARCHAR(50) NOT NULL,
    id_cli INT NOT NULL,
    CONSTRAINT fk_clientesocial_cliente FOREIGN KEY (id_cli) REFERENCES CLIENTE(id_cli)
);

-- Insertar empleados
INSERT INTO EMPLEADO (nombre, telefono, dni, usuario, passwd) VALUES
('Lucía Martínez', '987654321', '12345678L', 'lucia.m', 'clave123'),
('Carlos Pérez', '912345678', '87654321K', 'carlos.p', 'passw0rd');

SELECT * from empleado;

-- Insertar publicidades
INSERT INTO PUBLICIDAD (descp, tipo, contacto, imagen) VALUES
('Publicidad en redes sociales', 'Redes Sociales', 5, 'imagen1.jpg'),
('Anuncio en radio local', 'Radio', 2, 'imagen2.jpg');

-- Insertar clientes
INSERT INTO CLIENTE (nombre, apellido, birthdate, telefono, direccion, dni, sexo, gusto) VALUES
('Ana', 'Gómez', '1990-05-15', '612345678', 'Calle Falsa 123', '11112222A', 'Femenino', 'Moda, tecnología'),
('Luis', 'Ramírez', '1985-10-20', '698765432', 'Av. Real 456', '33334444B', 'Masculino', 'Deportes, autos');

-- Insertar relaciones PUB_EMP_CLI
INSERT INTO PUB_EMP_CLI (fecha, id_emp, id_cli, id_pub) VALUES
('2025-04-01', 1, 1, 1),
('2025-04-02', 2, 2, 2);

-- Insertar correos de clientes
INSERT INTO CLIENTE_CORREO (correo, proveedor, id_cli) VALUES
('ana.gomez@gmail.com', 'Gmail', 1),
('luis.ramirez@outlook.com', 'Outlook', 2);

-- Insertar redes sociales de clientes
INSERT INTO CLIENTE_SOCIAL (usuario, proveedor, id_cli) VALUES
('@ana_g', 'Instagram', 1),
('@luis_r', 'Facebook', 2);

-- Ver anuncios asignados a clientes
CREATE VIEW pubclientes AS
SELECT 
    c.id_cli,
    c.nombre || ' ' || c.apellido AS cliente,
    p.id_pub,
    p.descp AS descripcion_anuncio,
    p.tipo,
    pec.fecha
FROM PUB_EMP_CLI pec
JOIN CLIENTE c ON pec.id_cli = c.id_cli
JOIN PUBLICIDAD p ON pec.id_pub = p.id_pub
ORDER BY c.id_cli, pec.fecha;

CREATE VIEW pubclientes2 AS
SELECT 
    c.id_cli,
    c.nombre AS cliente,
    p.id_pub,
    p.descp AS descripcion_anuncio,
    p.tipo,
    pec.fecha
FROM PUB_EMP_CLI pec
JOIN CLIENTE c ON pec.id_cli = c.id_cli
JOIN PUBLICIDAD p ON pec.id_pub = p.id_pub
ORDER BY c.id_cli, pec.fecha;

-- Ver clientes atendidos por empleados
CREATE or replace VIEW cli_empleados AS
SELECT 
    e.id_emp,
    e.nombre AS empleado,
    c.id_cli,
    c.nombre as cliente,
    pec.fecha
FROM PUB_EMP_CLI pec
JOIN EMPLEADO e ON pec.id_emp = e.id_emp
JOIN CLIENTE c ON pec.id_cli = c.id_cli
JOIN PUBLICIDAD p ON pec.id_pub = p.id_pub
ORDER BY e.id_emp, pec.fecha;

-- Ver las redes sociales y correos de los clientes
CREATE VIEW redcorclientes AS
SELECT 
    c.id_cli,
    c.nombre || ' ' || c.apellido AS cliente,
    COALESCE(correos.correos, 'Sin correos') AS correos,
    COALESCE(redes.redes_sociales, 'Sin redes') AS redes_sociales
FROM CLIENTE c
LEFT JOIN (
    SELECT id_cli, STRING_AGG(correo || ' (' || proveedor || ')', ', ') AS correos
    FROM CLIENTE_CORREO
    GROUP BY id_cli
) correos ON c.id_cli = correos.id_cli
LEFT JOIN (
    SELECT id_cli, STRING_AGG(usuario || ' (' || proveedor || ')', ', ') AS redes_sociales
    FROM CLIENTE_SOCIAL
    GROUP BY id_cli
) redes ON c.id_cli = redes.id_cli
ORDER BY c.id_cli;
