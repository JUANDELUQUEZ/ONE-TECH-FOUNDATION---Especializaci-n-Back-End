/* Codigo de prueba */
// El siguiente codigo es para la separacion de los ejercicios, no es necesario para el ejercicio en si, pero es para que se pueda diferenciar cada ejercicio
/* 
*
*
*
*
*
*
*
*/

/* public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
 */
/* 
*
*
*
*
*
*
*
*/

/* 
Ejercicio de Java: Escenario

Quiero calcular el precio final de una subscripcione que cuesta  15.5 luego aplicarle un descuento del 3.0 
Para esto vamos a declarar una variable para el precio base y otra con el valor final
*/

/* public class App {
        public static void main(String[] args) {
        double precioBase = 15.5; 
        double precioFinal = precioBase - (precioBase * 0.03); // Se le aplica un descuento del 3% 
    }
}
*/

/* 
*
*
*
*
*
*
*
*/

/* Quick Practice: Java Peliculas Sistema de Streaming 
- Vamos a simular la lógica de acceso a una película en ScreemMatch

- Contexto: 
    ~ Tenemos una variable (boolean incluidoEnElPlan = true;)
    ~ Tenemos una variable (String tipoPlan = "Plus";)
    ~ Tenemos una variable (String pelicula = "Amor redentor";)
    ~ Tenemos una variable (double notaCritica = 8.5;)

Hay que mostrar en consola una variable llamada puedeVerPelicula con las sigueintes condiciones:
    - Si esta incluido en el plan y el tipo de plan tiene que ser igual a "Plus"
    - O si la nota critica es mayor a 8.0
    - En caso contrario, no puede ver la película
    */

public class App {
  public static void main(String[] args) {
    String nombre = "Jose";
    boolean incluidoEnElPlan = true;
    String tipoPlan = "Plus";
    String pelicula = "Amor rendetor";
    double notaCritica = 8.5;
    boolean puedeVerPelicula = (incluidoEnElPlan && tipoPlan.equals("Plus")) || notaCritica > 8.0;

    if (puedeVerPelicula == true) {
      System.out.println(nombre + " puede ver la película " + pelicula);
    } else {
      System.out.println(nombre + " Tienes algun problema con tu plan");
    }

    /* Seguimiento de lección, convertir datos mas grandes en pequeños.
    Contexto
    
    - A veces la empresa recibe la duracion de las peliculas en formato 2.5h pero la base de datos 
    antigua solo recibe formato int 
    
    Cambio o adaptación de la funcionalidad: 
    - Vamos a declarar una variable double duracionPpeliculasHoras = 2.5;
    - Vamos a declarar una variable int duracionPeliculaMinutos 
    - Vamos a calcular las horas de la pelicula en minutos y realizaremos el casting para guardarlo como una variable int 
    
    ------ IMPRIMIMOS EL RESULTADO*/

    double duracionPeliculaHoras = 2.5;
    int duracionPeliculaMinutos = (int) (duracionPeliculaHoras * 60);
    System.out.println("La duración de la película en minutos es de: " + duracionPeliculaMinutos + " minutos");

  }
}

/* Pasamos para el archivo de las decisiones para trabajar la logica de control con if-else   */


