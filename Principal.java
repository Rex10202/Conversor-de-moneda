import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner opcion = new Scanner(System.in)) {
            ConsultarTasa consultarTasa = new ConsultarTasa();
            GeneradorDeArchivo generadorDeArchivo = new GeneradorDeArchivo();

            // Obtener todas las divisas disponibles
            Map<String, String> divisas = consultarTasa.obtenerDivisasDisponibles();
            System.out.println("Lista de divisas disponibles:");
            divisas.forEach((codigo, nombre) -> System.out.println(codigo + " - " + nombre));

            while (true) {
                System.out.print("\nSeleccione la moneda base: ");
                String monedaBase = opcion.next().toUpperCase();

                System.out.print("Seleccione la moneda destino: ");
                String monedaDestino = opcion.next().toUpperCase();

                if (!divisas.containsKey(monedaBase) || !divisas.containsKey(monedaDestino)) {
                    System.out.println("Divisas inválidas. Intente nuevamente.");
                    continue;
                }

                // Realizar la consulta de la tasa
                try {
                    double tasaCambio = consultarTasa.buscarTasa(monedaBase, monedaDestino);
                    System.out.printf("Tasa de cambio: 1 %s = %.4f %s%n", monedaBase, tasaCambio, monedaDestino);

                    // Pedir cantidad y calcular conversión
                    System.out.print("Ingrese la cantidad a convertir: ");
                    double cantidad = opcion.nextDouble();
                    double montoConvertido = cantidad * tasaCambio;
                    System.out.printf("Monto convertido: %.2f %s%n", montoConvertido, monedaDestino);

                    // Guardar resultado en archivo JSON
                    Tasa tasa = new Tasa(monedaBase, monedaDestino, cantidad, montoConvertido, tasaCambio);
                    generadorDeArchivo.guardarJson(tasa);
                    System.out.println("Conversión guardada en archivo JSON.");
                } catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }

                System.out.print("\n¿Desea realizar otra conversión? (s/n): ");
                String continuar = opcion.next().toLowerCase();
                if (!continuar.equals("s")) {
                    System.out.println("¡Hasta luego!");
                    break;
                }
            }
        }
    }
}
