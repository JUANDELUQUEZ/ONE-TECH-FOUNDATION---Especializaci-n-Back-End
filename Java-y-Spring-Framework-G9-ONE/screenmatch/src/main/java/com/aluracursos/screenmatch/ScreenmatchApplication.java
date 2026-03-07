package com.aluracursos.screenmatch;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        
        // 2. Definimos la URL (usa tu propia API Key de OMDB)
        var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=series&apikey=aaa426c3");
        
        // 3. Imprimimos el resultado que viene de internet
        System.out.println(json); 
    }
}