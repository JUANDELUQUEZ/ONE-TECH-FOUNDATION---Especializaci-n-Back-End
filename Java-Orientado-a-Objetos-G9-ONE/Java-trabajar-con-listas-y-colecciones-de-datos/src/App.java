import models.*; 
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {
  public static void main(String[] args) throws Exception {
    Pelicula peliculaUno = new Pelicula("Avatar 3",  2025);
    peliculaUno.setFechaDeLanzamiento(2009);
    peliculaUno.setDuracionEnMinutos(162);

    Serie miSerie = new Serie("Breaking Bad", 2008);
    miSerie.setTemporadas(5);
    
    // ⚠️ Aquí está el punto clave
    List<Titulo> lista = new ArrayList<>(); 
    // Prueba del .isEmpty() antes de agregar elementos
    System.out.println("¿La lista está vacía? " + lista.isEmpty()); // Debería imprimir 'true' porque aún no hemos agregado nada
    lista.add(peliculaUno);
    lista.add(miSerie); 
    // Prueba del .isEmpty() después de agregar elementos
    System.out.println("¿La lista está vacía? " + lista.isEmpty()); // Debería imprimir 'false' porque ahora hemos agregado elementos
    System.out.println(lista); 


        // Después de instanciar tus películas, evalúalas:
    peliculaUno.evalua(10);
    peliculaUno.evalua(8);
    peliculaUno.evalua(6);

    // Ordena la lista de títulos por nombre
    Collections.sort(lista); 
    System.out.println(lista);

    // Ahora tu bucle forEach con el instanceof funcionará perfectamente
    for (Titulo item : lista) {
        System.out.println("Título: " + item.getNombre());
        
        if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
            System.out.println(" Clasificación: " + pelicula.getClasificacion() + " estrellas");
        }
    }

    lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
    System.out.println("Lista ordenada por fecha de lanzamiento: " + lista );    
  }
}