import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Clase de servicio encargada de consultar tasas de cambio en la API Exchange Rate
 * Implementa la capa de servicio para obtener conversiones de monedas
 */
public class ConsultaMoneda {
    
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6";
    private final String apiKey;
    private final HttpClient httpClient;
    private final Gson gson;

    /**
     * Constructor de ConsultaMoneda
     * Intenta obtener la API_KEY de la variable de entorno "EXCHANGE_RATE_API_KEY"
     * Si no existe, lanza una excepción
     */
    public ConsultaMoneda() {
        this(obtenerApiKeyDelEntorno());
    }

    /**
     * Constructor que recibe la API_KEY como parámetro
     * @param apiKey Clave de acceso para la API Exchange Rate
     * @throws IllegalArgumentException si la API_KEY está vacía o es nula
     */
    public ConsultaMoneda(String apiKey) {
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("La API_KEY no puede estar vacía o nula");
        }
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    /**
     * Busca la tasa de cambio entre dos monedas
     * @param monedaBase Código ISO de la moneda base (ej: USD)
     * @param monedaObjetivo Código ISO de la moneda objetivo (ej: MXN)
     * @return Objeto TasaDeCambio con la información de conversión
     * @throws IllegalArgumentException si las monedas están vacías
     * @throws IOException si hay error en la conexión
     * @throws InterruptedException si la solicitud es interrumpida
     * @throws JsonSyntaxException si la respuesta JSON es inválida
     * @throws RuntimeException si la API retorna un error
     */
    public TasaDeCambio buscarTasa(String monedaBase, String monedaObjetivo) 
            throws IOException, InterruptedException {
        
        // Validación de parámetros
        if (monedaBase == null || monedaBase.trim().isEmpty()) {
            throw new IllegalArgumentException("La moneda base no puede estar vacía");
        }
        if (monedaObjetivo == null || monedaObjetivo.trim().isEmpty()) {
            throw new IllegalArgumentException("La moneda objetivo no puede estar vacía");
        }

        // Construir la URL
        String url = String.format("%s/%s/pair/%s/%s", 
            BASE_URL, 
            apiKey, 
            monedaBase.toUpperCase().trim(), 
            monedaObjetivo.toUpperCase().trim());

        try {
            // Crear la solicitud HTTP GET
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Accept", "application/json")
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = httpClient.send(request, 
                    HttpResponse.BodyHandlers.ofString());

            // Validar código de estado HTTP
            if (response.statusCode() != 200) {
                throw new RuntimeException(
                    String.format("Error en la API: HTTP %d - %s", 
                        response.statusCode(), 
                        response.body())
                );
            }

            // 1. Obtienes el String crudo de tu respuesta HTTP
            String jsonCrudo = response.body();

            // 2. Usas JsonParser para convertir el String en un elemento que Gson entienda
            JsonElement elemento = JsonParser.parseString(jsonCrudo);

            // 3. Lo conviertes en un JsonObject para poder buscar por las "llaves"
            JsonObject objetoJson = elemento.getAsJsonObject();

            // 4. Extraes el valor exacto que necesitas (la tasa de conversión)
            double tasaDeConversion = objetoJson.get("conversion_rate").getAsDouble();

            // Imprimes para verificar que funcionó
            System.out.println("La tasa de conversión es: " + tasaDeConversion);

            // Crear el objeto TasaDeCambio con los valores extraídos
            String baseCode = objetoJson.get("base_code").getAsString();
            String targetCode = objetoJson.get("target_code").getAsString();

            TasaDeCambio tasaDeCambio = new TasaDeCambio(baseCode, targetCode, tasaDeConversion);

            return tasaDeCambio;

        } catch (JsonSyntaxException e) {
            throw new RuntimeException(
                "Error al procesar la respuesta JSON de la API: " + e.getMessage(), 
                e
            );
        } catch (IllegalStateException e) {
            throw new RuntimeException(
                "Error al acceder a las propiedades del JSON: " + e.getMessage(), 
                e
            );
        } catch (IOException e) {
            throw new IOException(
                "Error de conexión con la API Exchange Rate: " + e.getMessage(), 
                e
            );
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedException(
                "La solicitud HTTP fue interrumpida: " + e.getMessage()
            );
        }
    }

    /**
     * Obtiene la API_KEY del entorno o retorna la de prueba como fallback
     * @return La API_KEY desde la variable de entorno EXCHANGE_RATE_API_KEY
     * @throws RuntimeException si la variable de entorno no está configurada
     */
    private static String obtenerApiKeyDelEntorno() {
        String apiKey = System.getenv("EXCHANGE_RATE_API_KEY");
        
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new RuntimeException(
                "Variable de entorno 'EXCHANGE_RATE_API_KEY' no configurada. " +
                "Por favor configura tu API_KEY como variable de entorno."
            );
        }
        
        return apiKey;
    }
}
