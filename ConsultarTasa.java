import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConsultarTasa {
    private static final String API_KEY = "93956abac44b4074055f4409";

    /**
     * Busca la tasa de cambio entre dos divisas.
     * 
     * @param base    Divisa base.
     * @param destino Divisa destino.
     * @return Tasa de cambio.
     */
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

    /**
     * @return Un mapa con los códigos y nombres de las divisas.
     */
    public Map<String, String> obtenerDivisasDisponibles() {
        try {
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/codes");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonArray codes = json.getAsJsonArray("supported_codes");

            Map<String, String> divisas = new HashMap<>();
            for (int i = 0; i < codes.size(); i++) {
                JsonArray codePair = codes.get(i).getAsJsonArray();
                String codigo = codePair.get(0).getAsString();
                String nombre = codePair.get(1).getAsString();
                divisas.put(codigo, nombre);
            }
            return divisas;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se pudo obtener la lista de divisas.");
        }
    }
}
