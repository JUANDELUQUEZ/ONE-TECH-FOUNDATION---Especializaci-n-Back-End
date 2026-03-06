# Conversor de Monedas - Challenge ONE Back-End

## Descripción del Proyecto

Aplicación de consola desarrollada en Java que permite realizar conversiones de divisas en tiempo real. Este proyecto consume la API REST de ExchangeRate-API para obtener las tasas de cambio actualizadas y procesa la respuesta en formato JSON para interactuar con el usuario mediante un menú cíclico.

## Características Funcionales

- Consulta de tasas de cambio directas entre múltiples divisas (USD, ARS, BOB, BRL, CLP, COP, MXN).
- Conversión matemática de montos específicos ingresados por el usuario.
- Menú interactivo continuo tolerante a fallos de escritura (prevención de caídas por validación de buffer).
- Manejo de excepciones para errores de red, interrupciones de conexión y respuestas HTTP no exitosas.

## Tecnologías y Arquitectura

- **Java 21:** Implementación de `HttpClient`, `HttpRequest` y `HttpResponse` para conexiones síncronas nativas, eliminando la necesidad de librerías HTTP externas de terceros. Modelado de datos inmutable mediante `Records`.
- **Gson (v2.10.1):** Deserialización directa del cuerpo de la respuesta JSON hacia objetos Java.
- **ExchangeRate-API:** Proveedor de datos en tiempo real (Endpoint `/pair`).

## Requisitos Previos

- Java Development Kit (JDK) 21 o superior.
- IDE (VS Code, IntelliJ, etc.) o terminal de comandos.
- Conexión a internet activa para el consumo de la API.

## Configuración y Ejecución

1. Clonar este repositorio en tu máquina local.
2. Si utilizas VS Code, asegúrate de que el archivo `gson-2.10.1.jar` ubicado en la carpeta `lib` esté referenciado en el archivo `.vscode/settings.json`.
3. (Nota de Seguridad): Para entornos de producción, se recomienda extraer la API Key de la clase `App.java` y configurarla como una variable de entorno (`EXCHANGE_RATE_API_KEY`).
4. Compilar y ejecutar la clase principal `App.java`.

## Autor

- Juan Deluquez
- ONE | TECH FOUNDATION - Especialización Back-End
