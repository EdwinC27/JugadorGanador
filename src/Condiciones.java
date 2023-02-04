import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Condiciones {
    static Integer lineCount=0; 

    public static  void verificarRondas(Scanner input, String[] args) {
        if (Atributos.rondas <= 10000 && Atributos.rondas > 0) {
            // lee linea por linea
            try {
                for (int interador = 0; interador < Atributos.rondas; interador++) {
                    Atributos.puntosJugador1 += input.nextInt();
                    Atributos.puntosJugador2 += input.nextInt();

                    Integer ventaja = Math.abs(Atributos.puntosJugador1 - Atributos.puntosJugador2);

                    // ventaja actual por la ventaja Maxima
                    if (ventaja > Atributos.ventajaMax) {
                        Atributos.ventajaMax = ventaja;
                        Atributos.ganador = Atributos.puntosJugador1 > Atributos.puntosJugador2 ? 1 : 2;
                    }
                }

                verificarRondasConIngresadas();

                if(lineCount == Atributos.rondas) {
                    OpcionesGuardado opcionesGuardado = new OpcionesGuardado();
                    OpcionesGuardado.opcGuardarArchivo(args);
                }
                else {
                    System.out.println("El numero de rondas no coincide");
                }
            } catch (java.util.InputMismatchException  ex) {
                System.out.println("El archivo contiene letras");
            } catch (Exception ex) {
                System.out.println("El numero de rondas es superado");
            }

        } else {
            System.out.println("Las rondas no son del rango esperadas");
        }
    }

    private static void verificarRondasConIngresadas() {
        try (Scanner scanner = new Scanner(new File(String.valueOf(Atributos.file)))) {
            while (scanner.hasNextLine()) {
                lineCount++;
                scanner.nextLine();
            }
            lineCount--;
        } catch (FileNotFoundException e) {
            System.out.println("Error leyendo archivo");
        }
    }
}
