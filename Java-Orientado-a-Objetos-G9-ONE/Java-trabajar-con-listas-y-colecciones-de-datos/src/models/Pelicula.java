package models;

public class Pelicula extends Titulo {
    // 🧹 Eliminamos el atributo 'nombre' y sus getters/setters porque ya los hereda de Titulo.
    

    // Constructor parametrizado que llama al constructor de la clase padre (Titulo)
    public Pelicula(String nombre, int fechaDeLanzamiento) {
      super(nombre, fechaDeLanzamiento); // 👈 Obligatorio en la línea 1
    }


    @Override
    public String toString() {
        // Usamos getNombre() que viene automáticamente de la clase padre
        return "Película: " + this.getNombre() + " se lanzó en " + this.getFechaDeLanzamiento() + " y dura " + this.getDuracionEnMinutos() + " minutos.";
    }
}