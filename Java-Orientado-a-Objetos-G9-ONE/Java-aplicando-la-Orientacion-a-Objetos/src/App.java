/*
 * Clase principal del programa. Contiene el método main donde se crea un
 * objeto de tipo Serie, se inicializan sus atributos y se invocan sus
 * métodos para mostrar información y calcular calificaciones.
 */

import models.Serie;

public class App {
    public static void main(String[] args) throws Exception {
      // Creamos una instancia de la clase Serie
      Serie miSerie = new Serie();

      // Asignamos valores a los atributos públicos del objeto
      miSerie.nombreSerie = "Stranger Things";   // título de la serie
      miSerie.numeroTemporada = 4;               // temporada actual
      miSerie.numeroEpisodio = 9;                // episodio actual
      miSerie.fechaEstreno = 2022;               // año de estreno

      // Mostrar la ficha completa de la serie en la consola
      miSerie.muestraFicha();

      System.out.println("\n"); // separador de líneas

      // Registramos varias calificaciones de usuarios
      miSerie.calificacion(4.5);
      miSerie.calificacion(3.5);
      miSerie.calificacion(5.0);

      // Podemos obtener el promedio llamando al método correspondiente
      // aunque aquí también lo imprimiremos de forma explícita
      System.out.println(miSerie.getTotalDeCalificaciones()); // número de califs registradas

      System.out.println("\n");
      System.out.println("El promedio de calificaciones es: " + miSerie.promedioCalificaciones());
    }
}
