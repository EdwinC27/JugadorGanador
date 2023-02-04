import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Guardar {
    public void crearArchivo(String name) {
        // ruta del archivo a guardar
        Path path = Paths.get(name);
        String text = Atributos.ganador + " " + Atributos.ventajaMax;

        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

            System.out.println("Se creo el archivo");
        } catch (Exception e) {
            System.out.println("No se pudo  guardar el archivo");
        }
    }
}
