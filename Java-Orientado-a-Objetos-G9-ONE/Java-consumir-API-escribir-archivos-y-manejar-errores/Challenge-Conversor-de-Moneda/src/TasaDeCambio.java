import com.google.gson.annotations.SerializedName;

/**
 * Record que mapea la respuesta JSON de la API Exchange Rate
 * Un Record es una clase inmutable ideal para transferencia de datos (DTO)
 * 
 * Estructura JSON esperada:
 * {
 *   "result": "success",
 *   "base_code": "USD",
 *   "target_code": "MXN",
 *   "conversion_rate": 17.05
 * }
 */
public record TasaDeCambio(
        @SerializedName("base_code")
        String baseCode,
        
        @SerializedName("target_code")
        String targetCode,
        
        @SerializedName("conversion_rate")
        double conversionRate
) {}
