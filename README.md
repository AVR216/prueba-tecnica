# Documentación para prueba técnica
## Desiciones y justificaciones
### Arquitectura
Se implementó una arquitectura por capas, la cual permite entre otras cosas: separar responsabilidades, reutilizar código, escalabilidad, mantenibilidad y cumple con ciertos principios SOLID
muy importantes. Es una arquitectura bastante conocida, así que será facil darle soporte o mantenimiento.

### Pruebas unitarias

No se pudo realizar esta parte, debido a que no alcanzó el tiempo. Pero la idea era utilizar Junit5 y Mockito. Con mockito simular comportamientos de los servicios y con JUnit
Probar con estos comportamientos simulados (mocks).

## Instrucciones para ejecución de solución
#### Imagen docker: 
Archivo prueba.tar
#### Importar imagen: 
docker load -i prueba.tar
#### Comando docker para ejecutar el contenedor basado en la imagen: 
docker run -p 8080:8081 -d javr/prueba:prueba

## Descripción de propuesta de despliegue
