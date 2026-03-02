package models;

import calc.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
    // Aquí podríamos agregar atributos específicos de una película, como duración, director, etc.
    // Por ahora, esta clase hereda todo de Titulo sin agregar nada nuevo.


    public Pelicula(String nombre, int fechaEstreno, int duracion) {
        if (nombre != null && !nombre.isEmpty() && fechaEstreno > 0 && duracion > 0) {
            // Usamos el setter heredado de Titulo para asignar el nombre y la fecha de estreno
            this.setNombre(nombre); 
            this.setFechaEstreno(fechaEstreno);
            this.setDuracion(duracion);;
      } else {
        throw new IllegalArgumentException("Todos los parámetros deben ser válidos y no nulos.");
      }
    }

        /**
        * Imprime en consola una "ficha" con la información básica de la película.
        */

    public void muestraFicha() {
        // 1. Primero le decimos al padre que imprima el Nombre y la Fecha:
        super.muestraFicha(); 
    
        // 2. Después, imprimimos los datos que son exclusivos de esta clase (Pelicula):
        System.out.println("Duración de: " + this.getDuracion() + " en  minutos");

    }
        @Override
        public int getClasificacion() {
        // Convierte el promedio (ej. 4.5) a entero eliminando decimales
        return (int) (promedioCalificaciones()); 
    }

}
