/* 
Quick-Practice 

- Vamos a crear un arbol de decisiones para determinar si una pelicula es popular, contemporanépa o retro
- Con las condiciones sigueinte: 
  - Si la pelicula fue lanzada despues del 2022 o en el 2022 es popular
  - Si la pelicula fue lanzada antes del 2022 pero fue lanzada despues o en el 2010 es contemporanéa. 
  - De lo contrario es retro
*/

public class Decisiones {
  public static void main(String[] args) {
    int fechaDeLanzamiento = 2001;
    String tipoDePelicula;
    if (fechaDeLanzamiento >= 2022) {
      tipoDePelicula = "Popular";
    } else if (fechaDeLanzamiento >= 2010) {
      tipoDePelicula = "Contemporánea";
    } else {
      tipoDePelicula = "Retro";
    }
    System.out.println("La película es " + tipoDePelicula);
  }
}
