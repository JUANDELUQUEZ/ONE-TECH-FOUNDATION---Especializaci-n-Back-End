package models;

public class Serie extends Titulo {
  private int temporadas;
  private int episodiosPorTemporada;
  private int minutosPorEpisodio;

  // Constructor vacío
  public Serie(String nombre, int fechaDeLanzamiento) {
      super(nombre, fechaDeLanzamiento); // Llamada al constructor de la clase padre
  }
  // Sobrescribimos el método de Titulo para el cálculo específico de una serie
  @Override
  public int getDuracionEnMinutos() {
      return temporadas * episodiosPorTemporada * minutosPorEpisodio;
  }

  // Getters y Setters específicos
  public int getTemporadas() { return temporadas; }
  public void setTemporadas(int temporadas) { this.temporadas = temporadas; }

  public int getEpisodiosPorTemporada() { return episodiosPorTemporada; }
  public void setEpisodiosPorTemporada(int episodiosPorTemporada) { this.episodiosPorTemporada = episodiosPorTemporada; }

  public int getMinutosPorEpisodio() { return minutosPorEpisodio; }
  public void setMinutosPorEpisodio(int minutosPorEpisodio) { this.minutosPorEpisodio = minutosPorEpisodio; }

  // Vamos a mostrar la información de la serie de una manera más específica
      @Override
  public String toString() {
      return "Serie: " + this.getNombre() + " y se lanzo en (" + this.getFechaDeLanzamiento() + ") con " + temporadas + " temporadas, " + episodiosPorTemporada + " episodios por temporada y " + minutosPorEpisodio + " minutos por episodio.";
  }
}
