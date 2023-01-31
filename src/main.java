import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class main {
    static File file;
    static Scanner scanner = new Scanner(System.in);
    static Integer ventajaMax = 0;
    static Integer ganador = 1;


    public static void main(String[] args) {
        try {
            abrirArchivo();

            // Crea un objeto Scanner para leer el archivo
            Scanner input = new Scanner(file);

            // Lee la cantidad de rondas
            Integer rondas = input.nextInt();

            Integer puntosJugador1 = 0;
            Integer puntosJugador2 = 0;
            ventajaMax = 0;
            ganador = 1;

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

                opcGuardarArchivo();
            }
            else {
                System.out.println("Las rondas superan las esperadas");
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo");
        }
    }

    private static void opcGuardarArchivo() {
        System.out.println("\nYa se genero la respuesta\n1- Guardar archivo por default\n2- Modificar ruta y nombre\nQue decea: ");
        Integer opcGuardar = scanner.nextInt();

        if(opcGuardar == 1) { // por defecto
            try {
                crearArchivo("respuesta.txt");
            } catch (Exception e) {
                System.out.println("Error al crear el archivo");
            }
        }
        else if(opcGuardar == 2) { // eligir ruta y nombre
            try {
                scanner.nextLine(); // limpiar bufer

                System.out.println("Ingrese la ruta: ");
                String ruta = scanner.nextLine();

                System.out.println("Ingrese el nombre: ");
                String nombre = scanner.nextLine();

                file = new File (ruta,nombre);

                // A partir del objeto File creamos el fichero físicamente
                if (file.createNewFile()) crearArchivo(String.valueOf(file));
                else System.out.println("No ha podido ser creado el fichero");

            } catch (Exception e) {
                System.out.println("Error al crear el archivo");
            }
        }
    }

    public static void crearArchivo(String name) {
        // ruta del archivo a guardar
        Path path = Paths.get(name);
        String text = ganador + " " + ventajaMax;

        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

            System.out.println("Se creo el archivo");

        } catch (Exception e) {
            System.out.println("No se pudo  guardar el archivo");
        }
    }

    private static void abrirArchivo() {
        // trae el archivo
        System.out.println("Digite la ruta del archivo a abrir: ");
        String nombre = scanner.nextLine();

        file = new File(nombre);
    }
}