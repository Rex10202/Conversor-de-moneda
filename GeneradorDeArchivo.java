import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    private static final String NOMBRE_ARCHIVO = "conversion_result.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * @param tasa La tasa de conversión que se desea guardar.
     * @throws IOException Si ocurre un error de escritura.
     */
    public void guardarJson(Tasa tasa) throws IOException {
        JsonArray arrayActual = leerArrayJson();

        // Convertir la nueva tasa a formato JSON y agregarla al array
        JsonElement nuevaTasa = gson.toJsonTree(tasa);
        arrayActual.add(nuevaTasa);

        // Guardar el array completo de nuevo en el archivo
        try (FileWriter escritor = new FileWriter(NOMBRE_ARCHIVO)) {
            gson.toJson(arrayActual, escritor);
        }
    }

    /**
     * @return Un JsonArray con los datos guardados o un array vacío si no hay
     *         contenido.
     */
    private JsonArray leerArrayJson() {
        try (FileReader lector = new FileReader(NOMBRE_ARCHIVO)) {
            return JsonParser.parseReader(lector).getAsJsonArray();
        } catch (Exception e) {
            return new JsonArray();
        }
    }
}
