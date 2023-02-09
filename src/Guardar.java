import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Guardar {
    public static void crearArchivo(String nombre) {
        // ruta del archivo a guardar
        File file = new File(nombre);
        String text = Atributos.ganador + " " + Atributos.ventajaMax;

        try {
            // Sobrescribir los datos existentes
            Files.write(file.toPath(), text.getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);

            System.out.println("Se creó el archivo");
        } catch (IOException e) {
            System.out.println("No se pudo crear el archivo: " + e.getMessage());
        }
    }
}