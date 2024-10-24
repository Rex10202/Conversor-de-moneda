import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarTasa {
    private static final String API_KEY = "93956abac44b4074055f4409"; // Reemplaza con tu clave si cambia.

    public double buscarTasa(String base, String destino) {
        try {
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + base);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");
            return rates.get(destino).getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener la tasa de cambio.");
        }
    }
}
