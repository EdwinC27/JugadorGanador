import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Guardar {
    public void opcGuardarArchivo() {
        System.out.println("\nYa se genero la respuesta\n1- Guardar archivo por default\n2- Modificar ruta y nombre\nQue decea: ");
        Integer opcGuardar = Main.scanner.nextInt();

        try {
            // por defecto
            if (opcGuardar == 1) crearArchivo("respuesta.txt");

            // eligir ruta y nombre
            else if (opcGuardar == 2) {
                Main.scanner.nextLine(); // limpiar bufer

                System.out.println("Ingrese la ruta: ");
                String ruta = Main.scanner.nextLine();

                System.out.println("Ingrese el nombre: ");
                String nombre = Main.scanner.nextLine();

                // verificar si termina con .txt
                if (!nombre.contains(".txt")) nombre += ".txt";

                // enviar los datos para crear el archivo
                Main.file = new File(ruta, nombre);

                // A partir del objeto File creamos el fichero físicamente
                if (Main.file.createNewFile()) crearArchivo(String.valueOf(Main.file));

                else System.out.println("No ha podido ser creado el fichero");
            }
        } catch (IOException ex) {
            System.out.println("Error al crear el archivo en la ruta especificada");
        }
    }

    public void crearArchivo(String name) {
        // ruta del archivo a guardar
        Path path = Paths.get(name);
        String text = Main.ganador + " " + Main.ventajaMax;

        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

            System.out.println("Se creo el archivo");
        } catch (Exception e) {
            System.out.println("No se pudo  guardar el archivo");
        }
    }
}
