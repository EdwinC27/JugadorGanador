import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            AbrirArchivo abrirArchivo = new AbrirArchivo();
            abrirArchivo.leerArchivo(args);

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        }
    }
}