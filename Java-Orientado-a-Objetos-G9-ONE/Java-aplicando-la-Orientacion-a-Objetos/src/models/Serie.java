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

public class Serie {
    // Datos privados para acceder por medio de métodos públicos desde otras clases
    private String nombreSerie;
    private int numeroTemporada;
    private int numeroEpisodio;
    private int fechaEstreno;

    // Creamos un constructor para inicializar los atributos de la serie
    public Serie(String nombreSerie, int numeroTemporada, int numeroEpisodio, int fechaEstreno) {
      if (nombreSerie != null && !nombreSerie.isEmpty() && numeroTemporada > 0 && numeroEpisodio > 0 && fechaEstreno > 0) {
        
        this.nombreSerie = nombreSerie;
        this.numeroTemporada = numeroTemporada;
        this.numeroEpisodio = numeroEpisodio;
        this.fechaEstreno = fechaEstreno;
      } else {
        throw new IllegalArgumentException("Todos los parámetros deben ser válidos y no nulos.");
      }
    }


    /**
     * Imprime en consola una "ficha" con la información básica de la serie.
    */
    public void muestraFicha() {
      System.out.println("Nombre de la serie: " + nombreSerie);
      System.out.println("Número de temporada: " + numeroTemporada);
      System.out.println("Número de episodio: " + numeroEpisodio);
      System.out.println("Fecha de estreno: " + fechaEstreno);
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


    // A partir de aquí: campos usados para calcular promedios
    private double sumaDeLasCalificaciones;
    private int totalDeCalificaciones;
    
    /**
     * Registra una calificación sumándola al total y aumentando el contador.
     *
     * @param calificacion valor numérico (ej. de 0.0 a 5.0) aportado por un
     *                      espectador.
     */
    public void calificacion(double calificacion) {
      sumaDeLasCalificaciones += calificacion;
      totalDeCalificaciones++;
    }

    /**
     * Calcula y devuelve el promedio de todas las calificaciones registradas.
     *
     * @return promedio como double; devuelve 0 si no hay calificaciones para
     *         evitar división por cero.
     */
    public double promedioCalificaciones() {
      if (totalDeCalificaciones == 0) {
        return 0; // Evitar división por cero
      }
      return sumaDeLasCalificaciones / totalDeCalificaciones;
    }
    /* Aquí creamos un nuevo metodo para poder obtener el total de 
    calificaciones registradas ya que la variable ahora tiene un 
    modificador de acceso privado */

    public int getTotalDeCalificaciones() {
      return totalDeCalificaciones;
    }
    
}