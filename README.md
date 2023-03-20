# JugadorGanador
Existe un juego en el que hay dos jugadores y varias rondas en los que cada jugador obtiene una puntuación.  

Para poder utilizar la entrada por defecto el archivo txt debe de llamarse ´file.txt´. Pedes ejecutar el programa desde consola.

## Funcionalidad
Estos son códigos de Java que parecen formar parte de un programa que lee un archivo de texto con información sobre un juego de dos jugadores y determina quién ganó el juego y con qué ventaja. Los códigos contienen definiciones de variables estáticas, funciones para leer y verificar la información del archivo, y funciones para escribir los resultados en otro archivo. El programa parece estar diseñado para ser invocado desde la línea de comandos, donde el primer argumento es el nombre del archivo de entrada y el segundo argumento es el nombre del archivo de salida. Si no se proporcionan argumentos, el programa pedirá al usuario que proporcione el nombre del archivo de entrada.

La función "leerArchivo" es la principal, que llama a la función "leerRondas" para leer la cantidad de rondas del juego del archivo y luego llama a la función "verificarRondas" para procesar la información de las rondas y determinar quién ganó el juego y con qué ventaja. Si la verificación es exitosa, llama a la función "opcGuardarArchivo" de "OpcionesGuardado" para guardar los resultados en un archivo de salida. Si no se proporcionan los argumentos correctos o el archivo de entrada no se puede encontrar, se emite un mensaje de error correspondiente.

## Requisitos:
* Para poder utilizar este programa, es necesario que su sistema operativo tenga instalado Java 11 o una versión más reciente. Si no cuenta con Java, puede descargar e instalar la versión correspondiente, por ejemplo desde la página de: https://adoptium.net/temurin/releases/.
