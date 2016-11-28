# Appministrator

Appministrator es una demostración de habilidades técnicas en Java y concretamente en Spring MVC. Implementa las operaciones CRUD sobre una entidad que representa usuarios (`User`).

## Tecnologías utilizadas
Este proyecto está basado en el proyecto [Spring Boot](http://projects.spring.io/spring-boot/) y utiliza las siguientes dependencias:
- Maven
- Spring Data (Hibernate & MySQL)
- Spring MVC (Tomcat)
- [Thymleaf](http://www.thymeleaf.org/)
- [DataTables](https://datatables.net/)

## Requisitos
- Java 8 (JDK 1.8)
- MySQL 5.6
- Maven 3 (La aplicación cuenta con un script para ejecutar maven, llamado `mvnw`, así que, no es necesario tenerlo instalado)
- Tomcat (La aplicación tiene este servidor embebido)
- GNU / Linux
- Un navegador web
- [JUnit](http://junit.org/junit4/)

## Configuración de la base de datos
Esta configuración se realiza automáticamente cuando se ejecuta el script `appministrator.sh` (tendrás que ingresar tu contraseña de root de MySQL). El rollback también se ejecuta automáticamente con el script `rollback.sh`

El script de configuración se encuentra en `/database/db.sql`. Adicionalmente, se provée un script de rollback en `/database/rollback.sql`

En el caso de que se quiera probar con otras credenciales, se pueden modificar en el archivo `/resources/application.properties`

Las credenciales por defecto son:

```
spring.datasource.url=jdbc:mysql://localhost:3306/appministrator
spring.datasource.username=user
spring.datasource.password=password
```

Luego de realizar los cambios, tendrás que ejecutar la aplicación con el comando `./mvnw spring-boot:run`, y luego acceder a tu [localhost](http://localhost:8080/).

## Ejecución
Es importante validar que los scripts: `appministrator.sh`, `rollback.sh` y `mvnw` tengan permiso de ejecución. Para mayor facilidad, otorgarle permisos completos al directorio: `sudo chmod -R 777 appministrator/`.

Ahora, ejecuta el script `appministrator.sh` que se encuentra en la raíz del proyecto. Luego, en tu navegador preferido, ingresa a [http://localhost:8080/](http://localhost:8080/).

## Rollback
Ejecuta el script `rollback.sh` que se encuentra en la raíz del proyecto. Tendrás que otorgarle permisos de ejecución, si es necesario.
