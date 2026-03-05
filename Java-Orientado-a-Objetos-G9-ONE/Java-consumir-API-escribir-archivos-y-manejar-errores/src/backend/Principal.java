package backend;
// Entrada del usuario para un consumo de API mas interactivo, ademas de pruebas de las clases creadas en el proyecto
import java.util.Scanner; 
import calc.CalculadoraDeTiempo;
import calc.FiltroRecomendacion;
import models.Episodio;
import models.Pelicula;
import models.Serie;

// Curso de consumo de API en Java para adquirir informacion de los titulos 
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest; 
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Principal {                    
    public static void main(String[] args) throws Exception {
        // Prueba de consumo de API con entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de una película para buscar en IMDB: ");
        String busqueda = scanner.nextLine();
        
        // Método para sanitizar el input del usuario aplicando URL Encoding
        String busquedaCodificada = sanitizarInput(busqueda);
        
        String direccionUrl = "https://www.omdbapi.com/?t=" + busquedaCodificada + "&apikey=aaa426c3";
        
        // Validación: Intentar crear URI sin encoding para demostrar el error potencial
        try {
            String urlSinEncoding = "https://www.omdbapi.com/?t=" + busqueda + "&apikey=aaa426c3";
            URI uriSinEncoding = URI.create(urlSinEncoding);
            System.out.println("URI sin encoding creada exitosamente (no esperado): " + uriSinEncoding);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear URI sin encoding: " + e.getMessage());
            System.out.println("Esto demuestra por qué es necesario el encoding.");
        }
        
        // Implementacion de la prueba de la conexion de la API de IMDB
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(direccionUrl))
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(180);
        System.out.println("Duración de la película: " + miPelicula.getDuracionEnMinutos());

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(8);
        miPelicula.evalua(5);
        miPelicula.evalua(10);
        System.out.println("Total de evaluaciones: " + miPelicula.getTotalDeEvaluaciones());
        System.out.println(miPelicula.calculaMediaEvaluaciones());

        Serie lost = new Serie("Lost", 2000);
        lost.muestraFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duracion de la série: " + lost.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.setDuracionEnMinutos(200);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluido(miPelicula);
        calculadora.incluido(otraPelicula);
        calculadora.incluido(lost);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtro = new FiltroRecomendacion();
        filtro.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizaciones(300);
        filtro.filtra(episodio);

        var peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeBruno);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);

        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());
        System.out.println(listaDePeliculas.toString());
        System.out.println("toString de la pelicula: " + listaDePeliculas.get(0).toString());

        scanner.close(); // Cerrar el scanner para liberar recursos
    }
    
    // Método para sanitizar el input del usuario aplicando URL Encoding con StandardCharsets.UTF_8
    public static String sanitizarInput(String input) {
        return URLEncoder.encode(input, StandardCharsets.UTF_8);
    }
}