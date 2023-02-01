import java.io.File;
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
    static Integer rondas=0;
    static Integer puntosJugador1 = 0;
    static Integer puntosJugador2 = 0;


    public static void main(String[] args) {
        try {
            // abrir el archivo
            abrirArchivo();

            // Crea un objeto Scanner para leer el archivo
            Scanner input = new Scanner(file);

            // Lee la cantidad de rondas
            rondas = input.nextInt();

            // verificar las rondas
            verificarRondas(input);

        } catch (Exception e) {
            System.out.println("Error al abrir el archivo");
        }
    }

    private static  void verificarRondas(Scanner input) {
        if (rondas <= 10000) {
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
        } else {
            System.out.println("Las rondas superan las esperadas");
        }
    }

    private static void opcGuardarArchivo() {
        System.out.println("\nYa se genero la respuesta\n1- Guardar archivo por default\n2- Modificar ruta y nombre\nQue decea: ");
        Integer opcGuardar = scanner.nextInt();

        try {
            if(opcGuardar == 1) { // por defecto
                crearArchivo("respuesta.txt");
            }
            else if(opcGuardar == 2) { // eligir ruta y nombre
                scanner.nextLine(); // limpiar bufer

                System.out.println("Ingrese la ruta: ");
                String ruta = scanner.nextLine();

                System.out.println("Ingrese el nombre: ");
                String nombre = scanner.nextLine();

                // verificar si termina con .txt
                int len = nombre.length();
                String lastFour = nombre.substring(len-4, len);

                if(!lastFour.equals(".txt")) nombre += ".txt";

                // enviar los datos para crear el archivo
                file = new File (ruta,nombre);

                // A partir del objeto File creamos el fichero físicamente
                if (file.createNewFile()) crearArchivo(String.valueOf(file));
                else System.out.println("No ha podido ser creado el fichero");
            }
        } catch (Exception e) {
            System.out.println("Error al crear el archivo");
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
        String nombre = "file.txt";

        System.out.println("1- Leer el archivo predeterminado\n2- Abrir otro archivo\nQue decea: ");
        int res = scanner.nextInt();

        if(res == 2) {
            scanner.nextLine(); // limpiar bufer
            System.out.println("Digite la ruta del archivo a abrir: ");
            nombre = scanner.nextLine();
        }

        file = new File(nombre);
    }
}