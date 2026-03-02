package models;

public class Titulo {
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;

    // Constructor vacío
    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    // Getters y Setters base
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getFechaDeLanzamiento() { return fechaDeLanzamiento; }
    public void setFechaDeLanzamiento(int fechaDeLanzamiento) { this.fechaDeLanzamiento = fechaDeLanzamiento; }

    public int getDuracionEnMinutos() { return duracionEnMinutos; }
    public void setDuracionEnMinutos(int duracionEnMinutos) { this.duracionEnMinutos = duracionEnMinutos; }

    @Override 
    public String toString() {
        return "Título: " + nombre + ", Lanzamiento: " + fechaDeLanzamiento + ", Duración: " + duracionEnMinutos + " minutos";
    }
}