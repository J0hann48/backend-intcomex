# Prueba Software developer - Intcomex

Proyecto de prueba en donde se valida una API que crea caterorias, productos y lista productos para ofrecer información sus clientes, así como procesos internos.

## Instrucciones para su prueba

El servicio se encuentra deployado en [http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/](http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/)

### Autenticación

La prueba con un sistema de autenticación JWT por lo cual para consumir los endpoints de categoria y productos deben enviar un token

* Register User (POST/api/v1/auth/register) Se debe crear un usuario para el cual se generará un token y se validará en cada consumo. <br><br>

Curl: <br><br>
<code>curl --location 'http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com//api/v1/auth/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "name",
    "email": "name@gmail.com",
    "password": "soyname"
}'</code>
 <br><br>

 Luego de esto se generara un token Bearer el cual debe ser enviado en cada consumo. 
  
* Authenticate User (POST/api/v1/auth/authenticate) Existe la posibilidad de logearse con el usuario creado y la contraseña para genearar un nuevo token. <br><br>

Curl
<br><br>

<code>
  curl --location 'http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/api/v1/auth/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "name@gmail.com",
    "password": "soyname"
}'
</code>

### Categorias

El servicio actualmente cuenta con los siguientes métodos:

* Crear Categoría (POST//api/v1/categories/register) Para crear una categoria, ya se encuentran creadas las categorias CLOUD y SERVIDORES <br><br>
Curl
<br><br>
<code>
  curl --location 'http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/api/v1/categories/register' \
--header 'Authorization: Bearer token' \
--form 'categoryName="SERVIDORES"' \
--form 'description="Servidores description"' \
--form 'picture=@"path/imageServer.jfif"'
</code>

### Productos
•	Cumpliendo el punto,
- Por medio del API Crear Producto, genere datos aleatorios para insertar 100.000 productos asociados a las dos categorías creadas anteriormente.
<br><br>
Se genero el siguiente endpoint
- Crear Producto (POST/api/v1/products/create)
<br><br>
<code>
curl --location --request POST 'http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/api/v1/products/create' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer token' \
--data ''
</code>
<br><br>

•	Cumpliendo el punto,
•	Por medio del api de listar productos, liste los 100.000 productos creados anteriormente, esta opción deberá poder paginarse y por medio de parámetros decidir cuantos productos se mostraran.

- Se genero el siguiente endpoint
- listar productos (GET/api/v1/products)
<br><br>
Curl
<br><br>
<code>
curl --location 'http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/api/v1/products?page=0&size=20' \
--header 'Authorization: Bearer token'
</code>
<br><br>

•	Cumpliendo el punto,
•	Por ultimo el endpoint de listar productos, podrá buscar un producto de la DB y traer la foto de la categoría a la que corresponde.
- Se genero el siguiente endpoint
- listar productos por ID (GET/api/v1/products/id)

<br><br>
Curl
<br><br>
<code>
curl --location 'http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/api/v1/products/3' \
--header 'Authorization: Bearer token'
</code>
<br><br>
Se puede probar utilizando [Postman](https://www.getpostman.com/).

## Environment
### Pre-requisitos 📋

* [Java17](https://www.oracle.com/co/java/technologies/javase-jdk17-downloads.html)
* IDE: [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Maven](https://maven.apache.org/)
* [JUnit 4](https://junit.org/junit5/)


## Descarga del código fuente
   
   Este proyecto utiliza Apache Maven. Antes de empezar, asegurese de descargarlo e instalarlo. Luego, Maven descargará automáticamente las librerias requeridas por el proyecto
   
   #### Repositorio
   
   El código se encuentra alojado en github. Para descargarlo necesita un cliente git, que puede encontrarlo en https://git-scm.com/downloads
   
   * Cree una carpeta en donde se incluirá el código fuente<br>
   * Abra su consola y posicionese en la carpeta previamente creada<br>
   * Ejecute el comando<br>
   
    git clone https://github.com/J0hann48/backend-intcomex.git
   
   Luego de que termine la descarga, usted tendrá clonado el branch master en la carpeta previamente creada.

### Instalación 🔧

## Despliegue 📦

_Se despliega en elastic beanstalk [EBS](http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/) de AWS_

## Construido con 🛠️

* [Spring Boot](https://spring.io/projects/spring-boot) - API-REST
* [Maven](https://maven.apache.org/) - Manejador de dependencias
*  [JUnit 4](https://junit.org/junit4/) - Test de pruebas



## Versionado 📌

Se uso [Github](https://github.com/) para el versionado. 

## Autor ✒️

* **Johann Sebastian Torres** - *Trabajo Inicial* - [J0hann48](https://github.com/J0hann48)

