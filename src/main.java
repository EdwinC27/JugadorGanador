import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static File file;
    static Scanner scanner = new Scanner(System.in);
    static Scanner input;
    static Integer rondas=0;
    static Integer ventajaMax = 0;
    static Integer ganador = 1;
    static Integer puntosJugador1 = 0;
    static Integer puntosJugador2 = 0;

    public static void main(String[] args) {
        try {
            AbrirArchivo abrirArchivo = new AbrirArchivo();
            abrirArchivo.leerArchivo();

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        }
    }
}