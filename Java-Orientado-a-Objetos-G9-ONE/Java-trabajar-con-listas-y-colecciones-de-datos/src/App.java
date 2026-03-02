import models.*; 
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Pelicula peliculaUno = new Pelicula("Avatar 3",  2025);
        peliculaUno.setFechaDeLanzamiento(2009);
        peliculaUno.setDuracionEnMinutos(162);

        Serie miSerie = new Serie();
        miSerie.setNombre("Breaking Bad");
        miSerie.setTemporadas(5);
        
        // ⚠️ Aquí está el punto clave
        ArrayList<Titulo> lista = new ArrayList<>(); 
        // Prueba del .isEmpty() antes de agregar elementos
        System.out.println("¿La lista está vacía? " + lista.isEmpty()); // Debería imprimir 'true' porque aún no hemos agregado nada
        lista.add(peliculaUno);
        lista.add(miSerie); 
        // Prueba del .isEmpty() después de agregar elementos
        System.out.println("¿La lista está vacía? " + lista.isEmpty()); // Debería imprimir 'false' porque ahora hemos agregado elementos
        System.out.println(lista); 
    }
}