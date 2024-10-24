import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner opcion = new Scanner(System.in)) {
            ConsultarTasa consultarTasa = new ConsultarTasa();
            GeneradorDeArchivo generadorDeArchivo = new GeneradorDeArchivo();

            while (true) {
                System.out.println("""
                        **************************
                        Selecciona una opción dentro del menú:
                        1 - USD a ARS
                        2 - USD a BRL
                        3 - USD a COP
                        4 - BRL a USD
                        5 - ARS a USD
                        6 - COP a USD
                        7 - Salir
                        **************************
                        """);

                int categoria = opcion.nextInt();

                if (categoria == 7) {
                    System.out.println("¡Hasta luego!");
                    break;
                }

                // Definir monedas según la opción elegida
                String monedaBase = switch (categoria) {
                    case 1, 2, 3 -> "USD";
                    case 4 -> "BRL";
                    case 5 -> "ARS";
                    case 6 -> "COP";
                    default -> throw new IllegalArgumentException("Opción no válida.");
                };

                String monedaDestino = switch (categoria) {
                    case 1 -> "ARS";
                    case 2 -> "BRL";
                    case 3 -> "COP";
                    case 4 -> "USD";
                    case 5 -> "USD";
                    case 6 -> "USD";
                    default -> throw new IllegalArgumentException("Opción no válida.");
                };

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
            }
        }
    }
}
