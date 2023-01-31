import java.io.File;

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

            System.out.println(rondas);

        } catch (Exception e) {
            System.out.println("Error al abrir el archivo");
        }
    }
}