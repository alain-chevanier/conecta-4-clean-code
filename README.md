# Código Limpio

## Objetivo

El objetivo de este ejercicio es practicar y evaluar la escritura de código limpio
de acuerdo a los puntos visto durante la sesión.

## Desarrollo
En esta práctica trabajarás con una base de código construida con Java 11 y Maven Wrapper,
también proveemos pruebas unitarias escritas con la biblioteca **Junit 5.7.2** que te
darán retrospectiva inmediatamente sobre el funcionamiento de tu implementación.

Para ejecutar las pruebas necesitas ejecutar el siguiente comando:

```
$ ./mvnw test
```

Para ejecutar las pruebas contenidas en una única clase de pruebas, utiliza
un comando como el siguiente:

```
$ ./mvnw -Dtest=MyClassTest test
```

En el código que recibirás la clase **App** tiene un método __main__ que puedes ejecutar
como cualquier programa escrito en __Java__. Para eso primero tienes que empaquetar
la aplicación y finalmente ejecutar el jar generado. Utiliza un comando como el que
sigue:

```
$ ./mvnw package
... o saltando las pruebas unitarias
$ ./mvnw package -DskipTests
...
...
$ ./mvnw exec:java 
```

## Configuración de los git hooks para formatear el código

Antes de empezar a realizar commits que contenga tu solución
tienes que configurar un módulo de git que te ayudará a
formatear tu código.

```
./mvnw git-code-format:install-hooks
```

## Forma de trabajo

Recomendamos ampliamente utilizar el editor [IntelliJ](https://www.jetbrains.com/help/idea/installation-guide.html)
para realizar el desarrollo de la práctica.
También agrega el plugin de IntelliJ [SonarLint](https://www.sonarsource.com/products/sonarlint/features/jetbrains/).

## Entrega

Deja todo el código con tu solución en la rama __main__, pues por omisión es esta
rama la que compara __Github Classroom__ contra la versión inicial del código mediante
el __Pull Request__ llamado __Feedback__, el cual nosotros vamos a revisar
para evaluar tu entrega.

Para verificar que tu código cumple con la especificación,
en tu __Pull Request__ debes de pasar las dos validaciones que
hace __Github Actions__ sobre el código, una de ellas verifica
que pasas las pruebas automatizadas, y la otra que hayas formateado
tu código con el plugin de maven.

Además, no olvides enviar el enlace hacia el __Pull Request__ que contiene tu
solución por medio del formulario.


## Actividades

### Problema "Conecta 4"

### Descripción
En el juego de Conecta 4 se utiliza un tablero de `6 x 7` en el que dos jugadores toman turnos para 
tirar fichas circulares de un color diferente dentro de este, para ello deben de elegir una columna que aún
no esté llena y en ella dejan caer una ficha correspondiente a su color. Gana el primer jugador que logra 
posicionar 4 fichas consecutivas del mismo color en forma horizontal, vertical o diagonal.

![Connect 4](assets/animacion-conecta-4.gif "Conecta 4 de dos jugadores en un tablero de 6x7")

### Requerimientos
Para esta práctica vamos a trabajar con una versión muy simple, pero genérica de este juego, 
en donde el tamaño del tablero, el número de los jugadores y el número de fichas consecutivas
para ganar son parametrizables. No tendremos una interfaz gráfica, pero en su lugar vamos a 
crear una serie de pruebas automatizadas que verificarán que tu implementación es correcta.

Funcionalidades a implementar:
* Representar el tablero
* Imprimir en la consola el estado del tablero
* Hacer una jugada
* Comprobar si un jugador ha ganado.
* Ejemplo
  ```
  Tablero de 3 x 4.
  - - - -
  - A - -
  A B B A
  ```