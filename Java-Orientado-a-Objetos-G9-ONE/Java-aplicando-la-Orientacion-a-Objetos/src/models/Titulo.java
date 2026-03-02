package models;

public class Titulo {
    private String nombre;
    private int fechaEstreno; // Nota: en tu código de arriba pusiste String, pero antes era int. ¡Usa el que prefieras, pero mantén consistencia!
    private double sumaDeLasCalificaciones;
    private int totalDeCalificaciones;
    private int duracionMinutos; // Atributo especifico para manejar la duracion de los titulos, para peliculas y para la inversion de tiempo en las series.


        /**
     * Registra una calificación sumándola al total y 
     * aumentando el contador.
     *
     
        * @param calificacion valor numérico (ej. de 0.0 a 5.0) 
        aportado por un
     *                      espectador.
     */

    
    public void calificacion(double calificacion) {
      sumaDeLasCalificaciones += calificacion;
      totalDeCalificaciones++;
    }

        public int getTotalDeCalificaciones() {
      return totalDeCalificaciones;
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

    // Getters y setters para los atributos privados
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaEstreno(int fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaEstreno() {
        return fechaEstreno;
    }

    public void setDuracion(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public int getDuracion() {
        return duracionMinutos;
    }

    // Uso del metodo de muestrFicha tecnica en la clase Serie, por lo que no es necesario definirlo aquí para futuros modelos. 

        public void muestraFicha() {
      System.out.println("Nombre del titulo: " + this.getNombre());
      System.out.println("Fecha de estreno: " + this.getFechaEstreno());
    }
}
