package com.aluracursos.screenmatch;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}
// sobrescribimos el método run para ejecutar código al iniciar la aplicación
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo desde Spring Boot!");
	}
}