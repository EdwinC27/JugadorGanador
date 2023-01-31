import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try {
            // Crea un objeto Scanner para leer el archivo
            Scanner input = new Scanner(new File("file.txt"));

            // Lee la cantidad de rondas
            Integer rondas = input.nextInt();

            Integer puntosJugador1 = 0;
            Integer puntosJugador2 = 0;
            Integer ventajaMax = 0;
            Integer ganador = 1;

            // verificar las rondas
            if(rondas <= 10000) {
                // lee linea por linea
                for (int i = 0; i < rondas; i++) {
                    puntosJugador1 += input.nextInt();
                    puntosJugador2 += input.nextInt();

                    Integer ventaja = Math.abs(puntosJugador1 - puntosJugador2);

                    // ventaja actual por la ventaja Maxima
                    if (ventaja > ventajaMax) {
                        ventajaMax = ventaja;
                        ganador = puntosJugador1 > puntosJugador2 ? 1 : 2;
                    }
                }

                respuestaGanadorArchivo(ganador, ventajaMax);
            }
            else {
                System.out.println("Las rondas superan las esperadas");
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo");
        }
    }

    public static void respuestaGanadorArchivo(Integer ganador, Integer ventajaMax) {
        // ruta del archivo a guardar
        Path path = Paths.get("respuesta.txt");
        String text = ganador + " " + ventajaMax;

        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

            System.out.println("Se creo el archivo");

        } catch (Exception e) {
            System.out.println("No se pudo  guardar el archivo");
        }
    }
}