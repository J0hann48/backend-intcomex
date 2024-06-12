# Prueba Software developer - Intcomex

Proyecto de prueba en donde se valida una API que crea caterorias, productos y lista productos para ofrecer información sus clientes, así como procesos internos.

## Instrucciones para su prueba

El servicio se encuentra deployado en [http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/](http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/)


El servicio actualmente cuenta con los siguientes métodos:

* Crear Categoría (POST/Category/) Para crear una categoria, ya se encuentran creadas las categorias CLOUD y SERVIDORES <br><br>
  La URL del método es [http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/api/v1/categories/register](http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/api/v1/categories/register)
  Y sus parametros son de tipo RequestParam
  ````
  curl --location 'http://backendintcomex-env-2.eba-gmsay2yb.us-east-1.elasticbeanstalk.com/api/v1/categories/register' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb3NlQGdtYWlsLmNvbSIsImlhdCI6MTcxODE0ODEyMywiZXhwIjoxNzE4MjM0NTIzfQ.PA9SPaWGhnFS85XUTPE4FdvnC9_vN-ND6-aZK1b2PE8' \
--form 'categoryName="SERVIDORES"' \
--form 'description="Servidores description"' \
--form 'picture=@"/C:/Users/Toshiba/Pictures/imageServer.jfif"'

Crear Producto (POST/Product/)
listar productos (GET/Products/)
listar productos por ID (GET/Products/id/)

 
 * Método POST para enviar una serie de mensajes y distancias a stelites ya conocidos y de esta manera lograr detectar el mensaje y la posiciń exacta de la nave transportadora.<br><br>
  La URL del método es [Applicationprueba-env.eba-2gcey6ks.us-east-1.elasticbeanstalk.com/meli/api/topsecret/](Applicationprueba-env.eba-2gcey6ks.us-east-1.elasticbeanstalk.com/meli/api/topsecret/)
Se puede enviar un JSON con la distancias de los satelites y los posibles mensjes receibidos de la nave transportadora mediante un HTTP POST, el JSON pude contenerel siguiente formato:<br><br>
POST  → /topsecret
{
    "satelites": [
        {
            "name": "Kenobi",
            "distance": 100.0,
            "message": ["este", "", "", "", ""]
        },
        {
            "name": "Skywalker",
            "distance": 190.0,
            "message": ["", "es", "un", "", "secreto"]
        },
        {
            "name": "Sato",
            "distance": 120.0,
            "message": ["", "es", "", "mensaje", ""]
        }
]<br><br>

En caso de enviar dicho request el código de respuesta será un HTTP 200-OK, en caso contrario un
404-NOT-FOUND<br><br>
* Método POST para enviar la distancia y el posible mensaje a desencriptar para un solo satelite
La URL del método es [Applicationprueba-env.eba-2gcey6ks.us-east-1.elasticbeanstalk.com/meli/api/topsecret/topsecret_split/skywalker](Applicationprueba-env.eba-2gcey6ks.us-east-1.elasticbeanstalk.com/meli/api/topsecret/topsecret_split/{nameSatelite})<br><br>
Se puede enviar un JSON con la distancia del satelite y el posible mensaje recibido de la nave transportadora mediante un HTTP POST, el JSON pude contenerel siguiente formato:<br><br>
POST  → /topsecret_split{nameSatelite}
{
    "distance": 199.0,
    "message": ["", "es", "", "", "secreto"]
}<br><br>

En caso de enviar dicho request el código de respuesta será un HTTP 404-NOT-FOUND, ya que se deben enviar los tres satelites para así calcular la posición de la nave transportadora, en caso de enviar los tres satelites el código de respuesta será un 200-OK<br><br>

Se puede probar utilizando [Postman](https://www.getpostman.com/).

## Environment
### Pre-requisitos 📋

* [Java11](https://www.oracle.com/co/java/technologies/javase-jdk11-downloads.html)
* IDE: [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Maven](https://maven.apache.org/)
* [JUnit 4](https://junit.org/junit4/)


## Descarga del código fuente
   
   Este proyecto utiliza Apache Maven. Antes de empezar, asegurese de descargarlo e instalarlo. Luego, Maven descargará automáticamente las librerias requeridas por el proyecto
   
   #### Repositorio
   
   El código se encuentra alojado en github. Para descargarlo necesita un cliente git, que puede encontrarlo en https://git-scm.com/downloads
   
   * Cree una carpeta en donde se incluirá el código fuente<br>
   * Abra su consola y posicionese en la carpeta previamente creada<br>
   * Ejecute el comando<br>
   
    git clone [https://github.com/J0hann48/fuegoDeQuasarMeli.git](https://github.com/J0hann48/backend-intcomex.git)
   
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

