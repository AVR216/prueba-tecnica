# Documentación para prueba técnica
## Desiciones y justificaciones
### Arquitectura
Se implementó una arquitectura por capas, la cual permite entre otras cosas: separar responsabilidades, reutilizar código, escalabilidad, mantenibilidad y cumple con ciertos principios SOLID
muy importantes. Es una arquitectura bastante conocida, así que será facil darle soporte o mantenimiento.

### Desarrollo

Se utiliza el tipo de Carga perezosa al momento de relacionar las diferentes entidades, esto con la finalidad de que las relaciones con las demás entidades solo se carguen cuando
sea necesario.


### Pruebas unitarias

No se pudo realizar esta parte, debido a que no alcanzó el tiempo. Pero la idea era utilizar Junit5 y Mockito. Con mockito simular los comportamientos de los servicios y con JUnit
Probar con estos comportamientos simulados (mocks).

## Instrucciones para ejecución de solución
#### Imagen docker: 
Archivo prueba.tar enviado por correo
#### Importar imagen: 
docker load -i prueba.tar
#### Comando docker para ejecutar el contenedor basado en la imagen: 
docker run -p 8080:8081 -d javr/prueba:prueba

## Descripción de propuesta de despliegue

A continuación se describe cómo desplegar la aplicación en AWS, utilizando los servicios de
Lambda y ECS.
### Lambda:
1. Empaqueta el backend: Se limpia y compila la aplicación en un archivo JAR que
pueda ejecutarse.
2. Entrar a AWS y dirigirse al servicio de Lambda.
3. Crea la función: Se crea una nueva función en Lambda.
4. Elegir Java: Para la función, se selecciona Java como el entorno de desarrollo.
5. Subir JAR: Se sube el archivo JAR que se creó en el primer paso a la función
Lambda.
6. Configuración del trigger: En la sección de triggers de la función Lambda, se
configura uno como API Gateway.
7. Ajustar los métodos HTTP: En la consola de API Gateway, se ajustan los métodos
HTTP de la API REST.
8. Configurar las variables de entorno: Se Agregan las siguientes variables de entorno
la función Lambda y las que se requieras:
- Para la Base de Datos PostgreSQL:
`SPRING_DATASOURCE_URL`: La dirección para conectarse a la base de datos.
`SPRING_DATASOURCE_USERNAME`: El nombre de usuario para la conexión a la
base de datos.
`SPRING_DATASOURCE_PASSWORD`: La contraseña para la conexión a la base
de datos.
9. Desplegar
Lambda tiene beneficios como la ejecución sin necesidad de un servidor y la capacidad de
escalar automáticamente. No obstante, tiene limitaciones en cuanto al tiempo de ejecución y
el tamaño del código, lo cual puede ser un problema para trabajos que requieren muchos
recursos. Además, manejar información persistente puede ser complicado.
### ECS:
1. Crear un repositorio: En la sección de Repositorios en ECS, crear uno nuevo.
2. Configurar el repositorio: Durante la creación del repositorio, se realizan las
configuraciones iniciales. Donde se establece el nombre del repositorio, entre otras
configuraciones.
3. Subir la imagen al repositorio: Se utilizan los comandos que AWS proporciona para
subir la imagen Docker al repositorio que se acaba de crear.
4. Creación de un cluster: Ahora, en la sección de Clusters se crea uno nuevo.
Asegurando de seleccionar el tipo de cluster como Fargate, para no utilizar S2.
5. Configuración del cluster: Durante la creación del cluster, se establece su nombre y
se realizan las configuraciones necesarias.
6. Creación de una nueva tarea: Una vez que el cluster esté listo, se crea una nueva
task que luego será agregada al cluster.
7. Configura la task: Durante la creación de la task, se establece su nombre, el nombre
del contenedor y la URL de la imagen Docker que se subió al repositorio.
8. Desplegar un nuevo servicio en el cluster: En el cluster, se despliega un nuevo
servicio. Durante la configuración del servicio, se selecciona la tarea que se creó en
los pasos anteriores.
9. Monitoreo constante a logs de la o las tareas que se creen.
ECS hace más fácil trabajar con contenedores Docker en AWS, ya que permite escalar y
gestionar de manera eficiente. Se integra bien con otros servicios de AWS, pero puede
necesitar un poco más de configuración en comparación con soluciones totalmente sin
servidor
