package com.aluracursos.screenmatch;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.service.ConsumoApi;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}
// sobrescribimos el método run para ejecutar código al iniciar la aplicación
@Override
    public void run(String... args) throws Exception {
        // 1. Creamos la instancia del servicio usando 'var'
        var consumoApi = new ConsumoApi(); 
        System.out.println("\n");
        
        // 2. Definimos la URL (usa tu propia API Key de OMDB)
        var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=series&apikey=aaa426c3");
        
        System.out.println("\n");
        // 3. Convertimos el JSON a un objeto y lo mostramos
        var conversor = new ConvierteDatos();
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);
        
        System.out.println("\n");
        // 4. Imprimimos el resultado crudo que viene de internet
        System.out.println(json); 
    }
}