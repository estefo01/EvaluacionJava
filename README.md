# EvaluacionJava
Desarrollo sobre Evaluación de Java con respecto a microservicios.


Para probar esta solucion se debe realizar lo siguiente:

1) En caso de no tener instalado alguna aplicacion que sirva de API para consumir el Servicio Web Rest, se debe instalar (como por ejemplo POSTMAN).
2) Se debe abrir el proyecto de java con algun IDE de desarrollo, un ejemplo Eclipse.
3) Se debe ejecutar el proyecto dentro del IDE de desarrollo.
4) Se debe abrir la aplicacion, en este caso yo ocupe POSTMAN, donde ingresare la URL a consumir, estas son:
    - http://localhost:8080/guardarUsuario : Guardado de datos del Usuario en el formato indicado.
    - http://localhost:8080/listarUsuarios : Lista todos los usuarios creados.
    - http://localhost:8080/listarXUsuario/1 : Lista por ID de usuario especifico, a modo de ejemplo se esta realizando la busqueda por el ID 1.

Nota: El puerto por defecto es 8080, en caso de haber realizado alguna modificacion en el archivo de propiedades (application.properties), se debe colocar el puerto indicado.


