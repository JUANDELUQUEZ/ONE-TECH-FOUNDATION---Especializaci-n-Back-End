package models;

public class Pelicula {
  private String nombre;

  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }

  // Este es el método que evita que veas números raros en la consola
  @Override
  public String toString() {
      return "Película: " + this.nombre;
  }
}
