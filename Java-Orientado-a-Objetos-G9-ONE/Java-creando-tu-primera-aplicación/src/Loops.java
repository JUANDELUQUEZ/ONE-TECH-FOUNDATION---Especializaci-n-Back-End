/* Se nos proporciona un fragmento de código donde tenemos que editar ciertas lineas para optimizar el flujo de la evalucion de las peliculas, el termino utilizado es "Hardcoding", el numero total de las evaluacines esta fijo, en caso haya mas de las definidas toca cambiar el loop por eso. 

- Vamos a crear una variable donde guardemos la cantidad total de notas que vamos a evaluar, le vamos a preguntar al usuario cuantas notas va a evaluar, y luego vamos a usar esa variable para definir el numero de iteraciones del bucle.

*/

/* import java.util.Scanner;

public class Loops {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    double sumaNotas = 0;
    System.out.println("¿Cuantas notas vas a evaluar?");
    int totalNotas = teclado.nextInt(); // Variable para el total de notas

    // El bucle se repite totalNotas veces
    for (int i = 0; i < totalNotas; i++) {
        System.out.println("Ingresa la nota " + (i + 1) + ":");
        sumaNotas += teclado.nextDouble(); // Acumulador optimizado
    }
    System.out.println("Promedio final: " + (sumaNotas / totalNotas)); // Cálculo del promedio
  }
} */

  /* 
  *
  *
  *
  *
  *
  *
  *
  */

    /* Manejo del segundo tipo de Loops (While)

  ---Quick-Practice: Java Peliculas Sistema de Streaming ---

  El escenario planteado es el siguiente:

 

  - Estamos creando un sistema que cuente cuantas horas de película tenemos, el valor centinela sera el 0, si el usuario ingresa 0, el programa se detiene y muestra el total de horas acumuladas.

 

  - Vamos a crear una variable que lea la duración de la película

  - Luego tenemos las condiconales que se vana a cumplir que son las siguientes:

      - Tenemos que validar que la duracion de la pelicula no sea la centinela.

      - Tenemos que sumar la duracion de la pelicula en una variable acumuladora.

      - Tenemos que incrementar la variable de la cantidad de película.

 

  */

  import java.util.Scanner;

  public class Loops {

    public static void main(String[] args) {
      try (Scanner teclado = new Scanner(System.in)) {
        double totalHoras = 0;
        double duracionPelicula = -1;
        int cantidadPeliculas = 0;
        
        while (duracionPelicula != 0) {
          System.out.println("Ingresa la duración de tu película en horas (0 finaliza el programa): ");
          duracionPelicula = teclado.nextDouble();
          if (duracionPelicula != 0) {
            totalHoras += duracionPelicula;
            cantidadPeliculas++;
          }
        }
        System.out.println("Total de horas de " + cantidadPeliculas + " películas: " + totalHoras);
      }
    }
  }
