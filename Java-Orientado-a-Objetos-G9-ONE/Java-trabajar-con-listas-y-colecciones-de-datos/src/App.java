// Importamos nuestros modelos y las listas

import models.*; 
import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
        Pelicula peliculaUno = new Pelicula();
        peliculaUno.setNombre("Avatar");
        Pelicula peliculaDos = new Pelicula();
        peliculaDos.setNombre("Avatar 2");

        ArrayList<Pelicula> lista = new ArrayList<>(); // Aplicando Genericidad
        lista.add(peliculaUno);
        lista.add(peliculaDos);

        System.out.println(lista); // Ahora gracias al toString() verás el nombre
    }
}
