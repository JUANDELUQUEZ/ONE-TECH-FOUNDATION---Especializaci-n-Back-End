/* Se nos proporciona un fragmento de código donde tenemos que editar ciertas lineas para optimizar el flujo de la evalucion de las peliculas, el termino utilizado es "Hardcoding", el numero total de las evaluacines esta fijo, en caso haya mas de las definidas toca cambiar el loop por eso. 

- Vamos a crear una variable donde guardemos la cantidad total de notas que vamos a evaluar, le vamos a preguntar al usuario cuantas notas va a evaluar, y luego vamos a usar esa variable para definir el numero de iteraciones del bucle.

*/

import java.util.Scanner;

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
}
