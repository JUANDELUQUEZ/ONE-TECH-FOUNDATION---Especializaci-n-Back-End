/*
* Clase principal del programa. Contiene el método main donde se crea un
* objeto de tipo Serie, se inicializan sus atributos y se invocan sus
* métodos para mostrar información y calcular calificaciones.
*/

import models.Serie;
import calc.CalculadoraDeTiempo;
import models.Pelicula;
import calc.FiltroRecomendacion;
import models.Episodio;



public class App {
  public static void main(String[] args) throws Exception {
    // Creamos una instancia de la clase Serie
    Serie miSerie = new Serie("Stranger Things", 4, 9, 2022, 24);
    
    // 1. Instanciamos nuestra herramienta (la calculadora)
    CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
    
    FiltroRecomendacion filtro = new FiltroRecomendacion();

    // 1. Creamos un episodio
    Episodio episodio = new Episodio();
      
      
      
      /* // Asignamos valores a los atributos públicos del objeto
      /* // Asignamos valores a los atributos públicos del objeto
      miSerie.nombreSerie = "Stranger Things";   // título de la serie
      miSerie.numeroTemporada = 4;               // temporada actual
      miSerie.numeroEpisodio = 9;                // episodio actual
      miSerie.fechaEstreno = 2022;               // año de estreno */
      
      // Mostrar la ficha complet5a de la serie en la consola
      miSerie.muestraFicha();
      
      System.out.println("\n"); // separador de líneas
      
      // Registramos varias calificaciones de usuarios
      miSerie.calificacion(4.5);
      miSerie.calificacion(3.5);
      miSerie.calificacion(5.0);
      
      // Podemos obtener el promedio llamando al método correspondiente
      // aunque aquí también lo imprimiremos de forma explícita
      System.out.println(miSerie.getTotalDeCalificaciones()); // número de califs registradas
      
      System.out.println("\n");
      System.out.println("El promedio de calificaciones es: " + miSerie.promedioCalificaciones());
      
      
      System.out.println("\n"); // separador de líneas

      
      /* 
      *
      *
      * *
      * 
      * 
      * 
      * 
      * 
      *  */
     
     /* Inicializamos un nuevo modelo llamado Pelicula, y llamamos a los metodos de Titulo para poder manipular 
     las calificaciones de esta pelicula. */
     
     // Creamos una instancia de la clase Pelicula
     Pelicula miPelicula = new Pelicula("Inception", 2010, 148);
     miPelicula.muestraFicha();
     
     // Registramos varias calificaciones de usuarios
     miPelicula.calificacion(4.5);
     miPelicula.calificacion(0.5);
     miPelicula.calificacion(5.0);
     
     // Podemos obtener el promedio llamando al método correspondiente
     // aunque aquí también lo imprimiremos de forma explícita
     System.out.println(miPelicula.getTotalDeCalificaciones()); // número de califs registradas
     
     System.out.println("\n");
     System.out.println("El promedio de calificaciones es: " + miPelicula.promedioCalificaciones());

     System.out.println( "\n"); // separador de líneas
     // 2. Usamos la calculadora para "incluir" nuestros títulos
     calculadora.incluye(miPelicula); // ¡Acepta la película gracias al polimorfismo!
     calculadora.incluye(miSerie);    // ¡Acepta la serie gracias al polimorfismo!
   
     // 3. Imprimimos el resultado final llamando al "getter" de la calculadora
     System.out.println("Tiempo total necesario para el maratón: " + calculadora.getTiempoTotalMinutos() + " minutos");

     // 4. Probamos el filtro de recomendación con ambos modelos
      System.out.println("\nRecomendación para la película:");
      filtro.filtra(miPelicula);

      System.out.println("\nRecomendación para la serie:");

      episodio.setNumero(1);
      episodio.setNombre("El club del Fuego Infernal");
      episodio.setSerie(miSerie); // Lo vinculamos a tu serie Stranger Things
      episodio.setTotalVisualizaciones(300); // Le ponemos muchas vistas para que sea popular

      // 2. Pasamos el EPISODIO al filtro (¡El IDE lo aceptará felizmente!)
      filtro.filtra(episodio); 


    }
    
    
  }