package com.aluracursos.screenmatch.service;
// Importamos librerias que nos permiten hacer peticiones HTTP y manejar JSON

import java.net.http.*; // Para hacer peticiones HTTP
import java.io.IOException; // Para manejar excepciones de IO
import java.net.URI; // Para manejar URIs
import java.net.http.HttpClient; // Para crear un cliente HTTP
import java.net.http.HttpRequest; // Para crear solicitudes HTTP
import java.net.http.HttpResponse; // Para manejar respuestas HTTP

// Clase para consumir una API externa
public class ConsumoApi {
    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}
