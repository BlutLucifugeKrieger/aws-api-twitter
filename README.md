
Repositorio creado por Juan Camilo Castro Velasquez

-------------------------------PRUEBA DE FUNCIONAMIENTO-----------------------------------------
ejecucion local:

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/2346855d-147c-404b-9931-16dfca65cad6)

API corriendo en el puerto 4567, entonces al probar con Postman:

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/32429e5f-de57-486a-b421-09f2389f95f5)
![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/1f165535-b237-4325-b70f-9f38b61f43e6)

Al observar en la base de datos de mongodb, obtenemos lo siguiente: 

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/ae815565-e81b-4f3d-b3ed-a64c6fd95cb7)

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/d586ba7e-2d3f-4a14-872d-58316f23ae08)

Ahora, realicemos una prueba con un post (crear un tweet):

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/201820f6-2622-4cd8-8435-b16303d52c1b)


Despues, al volver a revisar la base de datos obtenemos:

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/0caf8c89-e062-42e7-a54b-3c9bd33dbf11)

Ahora, para poder llegar a visualizar de una manera mas comoda la ejecucion de la API, se creo una interfaz legacy sencilla (HTML,Javascript,CSS):

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/a58a5443-7fdc-42b8-bb63-89887313212c)

Como se observa, los tweets se visualizan mediante una tabla (stream) y por otro lado, los tweets se pueden crear utilizando un textarea.
Bien, ahora si creo un nuevo tweet y lo ejecuto, queda de la siguiente forma: 

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/d078ff25-5ffb-4341-9c25-0b8f4ca78c35)

y al presionar el boton, se ejecuta y se actualiza la tabla: 
![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/65770214-1695-46e2-ba3e-28d1db7437b4)

------------------------------------DOCKERIZACION------------------------------------------------------------------------

Creamos la imagen del proyecto:
En mi caso, la llame test_final
![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/b88febe8-4bb8-4f40-8a96-f39da048fb5f)

Ahora la montamos a DockerHub, link de mi imagen: https://hub.docker.com/r/blutlucifugekrieger/twitter-api-camilocastro

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/71930537-eb87-4ee6-8045-8445e5cd6c76)

Vamos al servicio AWS de vitualizacion (EC2) y creamos nuestra instacia:

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/a6bcbc46-053c-461e-ba8f-316db84828c5)

, a su vez, desplegamos una instacia de un contenedor docker en la maquina vitual:

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/03e42b72-4918-4219-b427-28f755fe6ae7)

Hacemos las comprobaciones necesarias mediante Postman: 

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/646825a7-0ad6-4b91-b23c-e5d716db2180)

Por parte del post:

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/2f4927b2-5a7a-4c11-b832-cafa114b2cfb)

Despues, revisamos en la base de datos: 

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/844f0594-d28c-407b-b939-d9e97552028f)

Inclusive, probamos a consumir el endpoint atraves de la direccion DNS publica que nos dio la virtualizacion: 

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/a5c95172-48a9-40af-ad44-a3b70fe9f503)
![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/f1449279-3b80-4d8e-928c-0f2b774a9fb3)

Esto fue lo que obtuve:

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/b196735a-23f0-4a73-99ad-a9cfd4e6b9f6)

La peticion atraves del protocolo HTTP GET, funciono correctamente, ahora provemos con el POST:

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/9071fead-4094-4673-bf2a-d649e2da6097)

Al presionar el boton obtuve:

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/08b33211-9a13-48a5-b067-b1047a0a68bf)

---------------------------------LAMBDA----------------------------------------------------

En primer lugar, debemos de subir el artefacto .JAR del proyecto al apartado de code, del dashboard de Lambda
Una vez cargado, nos vamos a configurar el handle, y despues a test:

1. Crear las funciones (una para GET y otra para POST) ---> GET(twitterFunction) Y POST(twitter-post-function)

   ![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/e743aed0-6abc-4829-a44b-40e07affd9b0)

3. Subir el archivo .JAR

   ![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/0bd10b1b-7b26-4a6b-a55b-89f311ab4b99)

4. Configurar el handle

   ![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/2a8d00a4-d505-4133-917c-53a33a86376c)

5. Realizar los test (Funcion)

   ![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/f25f6cca-1563-409c-b503-1b0d99472162)
   ![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/7e6b4043-00bb-4fcb-b9c7-9dd2b1424c42)


----------------------------API GATEWAY------------------------------------------------------

En primer lugar asociamos la funcion al APIGETWAY:

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/124769f5-c2c7-47c5-b7e9-c4322e19c000)

Realizamos las configuraciones del Request, la integracion y el mapeo correspondiente.
Al ejecutar los test obtuve lo siguiente:

![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/2ede476d-cb43-40b5-93bd-f31f19d5ca46)
![image](https://github.com/BlutLucifugeKrieger/aws-api-twitter/assets/130005378/32871018-d26c-4bcc-802d-cc4af03567c8)
























