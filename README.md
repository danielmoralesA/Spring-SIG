# Spring-SIG
Spring boot Security Thymeleaf JPA Postgresql

Para poder generar la base de datos edite el archivo src/main/resources.

application.properties 

Establecer conexion
spring.datasource.url = jdbc:postgresql://direccion y puerto /nombre de la base de datos

Edite esas lineas 
spring.datasource.username = nombre usuario de la base de datos
spring.datasource.password = contraseña

Ingresar roles registre nombres en la base de datos

Archivo SeguridadConfig 
cambiar la linea .antMatchers("/admin/usuario").hasAuthority("ADMIN") a.
.antMatchers("/admin/usuario").permitAll()

Para poder acceder a la pantalla de registro de usuario
