import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivo {

    public void leerRondas() throws FileNotFoundException {
        try {
            Main.input = new Scanner(Main.file);
            Main.rondas = Main.input.nextInt();

            verificarRondas(Main.input);
        } catch (Exception e) {
            System.out.println("No se pudo leer el numero de rondas ");
        }
    }

    public static  void verificarRondas(Scanner input) {
        if (Main.rondas <= 10000) {
            // lee linea por linea
            try {
                for (int i = 0; i < Main.rondas; i++) {
                    Main.puntosJugador1 += input.nextInt();
                    Main.puntosJugador2 += input.nextInt();

                    Integer ventaja = Math.abs(Main.puntosJugador1 - Main.puntosJugador2);

                    // ventaja actual por la ventaja Maxima
                    if (ventaja > Main.ventajaMax) {
                        Main.ventajaMax = ventaja;
                        Main.ganador = Main.puntosJugador1 > Main.puntosJugador2 ? 1 : 2;
                    }
                }

                Guardar guardar = new Guardar();
                guardar.opcGuardarArchivo();
            } catch(Exception ex){
                System.out.println("El archivo contiene letras");
            }

        } else {
            System.out.println("Las rondas superan las esperadas");
        }
    }
}
