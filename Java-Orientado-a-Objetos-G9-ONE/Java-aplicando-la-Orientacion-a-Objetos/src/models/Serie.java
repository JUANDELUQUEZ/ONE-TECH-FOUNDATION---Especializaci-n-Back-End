package models;
/*
 * La clase Serie modela una serie de televisión con algunos atributos
 * básicos y métodos para manejar calificaciones.
 *
 * Atributos:
 *   - nombreSerie (String): título de la serie.
 *   - numeroTemporada (int): número de la temporada actual o registrada.
 *   - numeroEpisodio (int): número del episodio actual o registrado.
 *   - fechaEstreno (int): año de estreno de la serie.
 *   - sumaDeLasCalificaciones (double): acumulador interno para sumar
 *     todas las calificaciones recibidas.
 *   - totalDeCalificaciones (int): contador de cuántas calificaciones se han
 *     registrado.
 *
 * Esta clase no define un constructor explícito, por lo que se utiliza el
 * constructor por defecto proporcionado por Java. Los atributos son públicos
 * en este ejemplo para simplificar el acceso desde la clase principal.
 */


public class Serie extends Titulo  {
    // Datos privados para acceder por medio de métodos públicos desde otras clases

    private int numeroTemporada;
    private int numeroEpisodio;
    private int minutosPorEpisodio;


    // Creamos un constructor para inicializar los atributos de la serie
    public Serie(String nombre, int numeroTemporada, int numeroEpisodio, int fechaEstreno, int minutosPorEpisodio) {
      if (nombre != null && !nombre.isEmpty() && numeroTemporada > 0 && numeroEpisodio > 0 && fechaEstreno > 0 && minutosPorEpisodio > 0) {
        
        this.setNombre(nombre); // Usamos el setter heredado de Titulo para asignar el nombre
        this.numeroTemporada = numeroTemporada;
        this.numeroEpisodio = numeroEpisodio;
        this.minutosPorEpisodio = minutosPorEpisodio;
        this.setFechaEstreno(fechaEstreno);
      } else {
        throw new IllegalArgumentException("Todos los parámetros deben ser válidos y no nulos.");
      }
    }

    // Metodo para calcular cuanto dura la serie dependiendo de la duracion de cada episodio por minuto. 

    @Override
    public int getDuracion() {
      return minutosPorEpisodio * numeroEpisodio * numeroTemporada;
    }


    /**
     * Imprime en consola una "ficha" con la información básica de la serie.
    */

    public void muestraFicha() {
      // 1. Primero le decimos al padre que imprima el Nombre y la Fecha:
      super.muestraFicha(); 

      // 2. Después, imprimimos los datos que son exclusivos de esta clase (Serie):
      System.out.println("Número de temporada: " + numeroTemporada);
      
      // (Aquí iría la línea para el número de episodio)
      System.out.println("Número de episodio: " + numeroEpisodio);

      // Muestra de la duración de la serie, 
      // que es un dato exclusivo de esta 
      // clase, por lo que no es necesario 
      // definirlo en el padre Titulo.
      System.out.println("Duración total de la serie: " + this.getDuracion() + " minutos");

  }
    
    /* 
    *
    *
    * *
    * *
    * *
    * *
    * *
    * *
    * 
    *  */
}