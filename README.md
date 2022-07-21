# EvaluacionJava

Desarrollo sobre Evaluación de Java con respecto a microservicios.

### Preparación IDE Java
Para realizar estas pruebas se debe tener instalado algún IDE, como por ejemplo Eclipse. Los pasos son:

1) Descargar IDE Eclipse.
2) Posterior a instalar el IDE y una vez adentro, se debe instalar el plugin "Spring Tools" (ver imagen de la url)
https://prnt.sc/rrrJAiMcMwoJ
3) Se debe importar el proyecto descargado desde del GitHub.

### Preparación PostMan
Para realizar estas pruebas se debe tener instalado alguna API para consumir el Servicio Web expuesto. En este caso instalaremos PostMan

## Como realizar las pruebas

1) Se debe ejecutar el proyecto dentro del Eclipse. Para realizar esto, ver imagen de la siguiente url https://prnt.sc/i-ptCFR_NV4n
2) Se debe abrir el PostMan donde ingresare la URL a consumir, estas son:

- http://localhost:8080/guardarUsuario : Guardado de datos del Usuario en el formato indicado.
- http://localhost:8080/listarUsuarios : Lista todos los usuarios creados.
- http://localhost:8080/listarXUsuario/1 : Lista por ID de usuario especifico, a modo de ejemplo se esta realizando la busqueda por el ID 1.

## Documentación

Para revisar la documentación del Servicio desarrollado, se debe ingregar al siguiente URL (es importante tener corriendo el proyecto).
http://localhost:8080/swagger-ui.html#/

Nota: El puerto por defecto es 8080, en caso de haber realizado alguna modificacion en el archivo de propiedades (application.properties), se debe colocar el puerto indicado.
