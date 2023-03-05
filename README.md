# AREP 
# Descripción

Para este taller se implementara un servidor Web (tipo Apache) en Java. El servidor debe ser capaz de entregar páginas html e imágenes tipo PNG. Igualmente el servidor debe proveer un framework IoC para la construcción de aplicaciones web a partir de POJOS. Usando el servidor se debe construir una aplicación Web de ejemplo. El servidor debe atender múltiples solicitudes no concurrentes.

# Prerequisitos del sistemas
- Maven
- Git
- Java

# Instalacion

Primero vamos a clonar el repositorio con el siguiente comando:

`git clone https://github.com/Andres7498/AREP-Taller3`

Una vez descargado, ingresamos a la carpeta con nuestros archivos e ingresamos el siguiente comando:

`mvn package`

una vez se haya ejecutado de manera correcta, podremos ejecutar la aplicacion con el siguiente comando ingresando a un navegador y escribiendo localhost:35000

`java -cp target/AREP_META_PROTOCOLOS-1.0-SNAPSHOT.jar co.edu.escuelaing.microspringboot.SprintBoot`

# Como usar

![image](https://user-images.githubusercontent.com/46855679/191393729-cef88696-f82f-426b-bf32-6f19c8a2701b.png)

Veremos un mensaje por default, podremos visualizar diferentes mensajes agregando al url lo siguiente, 

/status

/hello

/status

![image](https://user-images.githubusercontent.com/46855679/191394042-a0b91f9c-4f43-422f-82f2-c2911adb7c96.png)

Si se desea también se pueden ver imágenes en formato PNG, para ellos agregaremos 

/page/nombre_imagen.PNG

Las imágenes que tenemos disponibles se encuentran en la siguiente carpeta

![image](https://user-images.githubusercontent.com/46855679/191399023-e3c13d21-958d-4c2e-a1ed-c9e8eb3aedc6.png)

Por ejemplo 

![image](https://user-images.githubusercontent.com/46855679/191399163-40eab8ff-8e87-4705-8cb2-438f614f2740.png)

Si no especificamos una imagen, nos lanzara una imagen por default

![image](https://user-images.githubusercontent.com/46855679/191399316-080b7581-6740-4872-b560-ae97502e2b29.png)

# Documentación

Para este taller se implementara un servidor Web (tipo Apache) en Java. El servidor debe ser capaz de entregar páginas html e imágenes tipo PNG. Igualmente el servidor debe proveer un framework IoC para la construcción de aplicaciones web a partir de POJOS. Usando el servidor se debe construir una aplicación Web de ejemplo y desplegarlo en Heroku. El servidor debe atender múltiples solicitudes no concurrentes.

# Prerequisitos del sistemas
- Maven
- Git
- Java

# Instalacion

Primero vamos a clonar el repositorio con el siguiente comando:

`git clone https://github.com/DDRBernal/AREP_arquitectura_de_servidores`

Una vez descargado, ingresamos a la carpeta con nuestros archivos e ingresamos el siguiente comando:

`mvn package`

una vez se haya ejecutado de manera correcta, podremos ejecutar la aplicacion con el siguiente comando ingresando a un navegador y escribiendo localhost:35000

`java -cp target/AREP_META_PROTOCOLOS-1.0-SNAPSHOT.jar co.edu.escuelaing.microspringboot.SprintBoot`

# Como usar

Una vez este ejecutándose la aplicación en heroku,

![image](https://user-images.githubusercontent.com/46855679/191393524-dd4f8a9d-457b-42fa-a42e-17d25af92ca2.png)

o con el comando antes mencionado

![image](https://user-images.githubusercontent.com/46855679/191393729-cef88696-f82f-426b-bf32-6f19c8a2701b.png)

Veremos un mensaje por default, podremos visualizar diferentes mensajes agregando al url lo siguiente,

** /status

** /hello

** /status

![image](https://user-images.githubusercontent.com/46855679/191394042-a0b91f9c-4f43-422f-82f2-c2911adb7c96.png)

Si se desea también se pueden ver imágenes en formato PNG, para ellos agregaremos

** /page/nombre_imagen.PNG

Las imágenes que tenemos disponibles se encuentran en la siguiente carpeta

![image](https://user-images.githubusercontent.com/46855679/191399023-e3c13d21-958d-4c2e-a1ed-c9e8eb3aedc6.png)

Por ejemplo

![image](https://user-images.githubusercontent.com/46855679/191399163-40eab8ff-8e87-4705-8cb2-438f614f2740.png)

Si no especificamos una imagen, nos lanzara una imagen por default

![image](https://user-images.githubusercontent.com/46855679/191399316-080b7581-6740-4872-b560-ae97502e2b29.png)

Tambien podemos visualizar un archivo html

![image](https://user-images.githubusercontent.com/46855679/191414150-a3a3ea9e-9155-424b-8292-3a25035f03c2.png)

Si el archivo especificado no existe, arrojara un html por defecto.

![image](https://user-images.githubusercontent.com/46855679/191414095-47003d7d-fe2d-445e-97c1-ce24543fd73a.png)

# Documentación

Para crear la documentación, lo podremos hacer con ayuda del siguiente comando:

`mvn javadoc:javadoc`

# Tecnologías usadas

- Intellij IDEA
- Maven
- Java 18


