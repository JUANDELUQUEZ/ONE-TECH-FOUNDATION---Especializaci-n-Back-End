package models;

public class Titulo implements Comparable<Titulo> {
	private String nombre;
	private int fechaDeLanzamiento;
	private int duracionEnMinutos;
	// Añade estos atributos debajo de los que ya tienes
	private double sumaDeLasEvaluaciones;
	private int totalDeLasEvaluaciones;

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

			// Añade estos métodos para guardar las calificaciones
	public void evalua(double nota) {
			this.sumaDeLasEvaluaciones += nota;
			this.totalDeLasEvaluaciones++;
	}

	public double calculaMedia() {
			return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
	}

	@Override 
	public int compareTo(Titulo otroTitulo) {
		return otroTitulo.getNombre().compareTo(this.getNombre()); 
	}
}