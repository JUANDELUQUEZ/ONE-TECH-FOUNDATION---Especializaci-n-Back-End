package calc;

//nimport models.Pelicula;
import models.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotalMinutos;

    // Metodo getter para obtener el tiempo total en minutos
    public int getTiempoTotalMinutos() {
        return tiempoTotalMinutos;
    }

    // Metodo para agregar tiempo a la calculadora
    public void incluye(Titulo titulo) {
    this.tiempoTotalMinutos += titulo.getDuracion();
}
}
