201710_CSOF5101_01 - CONCEP. AVAN. DE INGENI. SOFTW
Tarea 3 psp2 - Regresion lineal
Daniel Melgarejo Rodriguez
7/3/2017 10:40

Link de github: https://github.com/dhmelgarejo/psp2

Cloar el repositorio ejecutando :
git clone https://github.com/dhmelgarejo/psp2.git

Ingresar a la carpeta psp2, el programa fue realizado con JRE 1.8

Debe tener instalado Maven y luego ejecutar 
mvn package

Se ejecutaran las pruebas y se generara un jar de ejecucion el cual puede probar corriendo el comando
java -jar .\Tarea3-0.0.1-SNAPSHOT.jar

Se le preguntara una ruta al archivo a analizar el cual debera tener la siguiente estructura:
La primera linea tendra un solo numero indicando en valor de X para encontrar el valor de Y en la funcion lineal
Las lineas siguientes seran 2 numeros separados por un espacio los cuales seran las columnas X y Y de datos para calcular las respectivas variables
Se pueden apreciar y ejecutar las pruebas con los archivos encontrados en \src\test\resources\

Link de heroku con resultados de las pruebas:
https://limitless-badlands-56248.herokuapp.com/
