# Trabajo final: Agencia de publicidad

Integrantes:
- Adan Elio Chambi Mamani
- Andy Nelson Barreda Vilcahuaman
- Juan Franklin Huamanga Torres

## Planteamiento

![image](assets/trabajo_final.png)

## Bocetos

![image2](assets/bocetos.png)

## Diseño

Este proyecto trabajo final presenta un diseño basado en capas:

- [Capa de Datos](<#Capa de Datos>) Conexion a base de datos.
- [Capa de Entidades](<#Capa de Entidades>) Declaracion de variables de entidades a usar.
- [Capa de Interfaces](<#Capa de Interfaces>) Firma de metodos a usar.
- [Capa de Logica](<#Capa de Logica>) Logica de negocio concentrada para cada proposito.
- [Capa de Presentacion](<#Capa de Presentacion>) Vista final del programa.

### Capa de Datos

Encapsulacion de la logica para la conexion a la base de datos.

```java
package datos;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private String url = "jdbc:postgresql://localhost/agenpub2";
	private String user = "postgres";
	private String password = "123";
	
	public Connection conectar() throws SQLException {
		Connection cn = DriverManager.getConnection(url,user,password);
		return cn;
	}
}  
```

### Capa de Entidades
### Capa de Interfaces
### Capa de Logica
### Capa de Presentacion
