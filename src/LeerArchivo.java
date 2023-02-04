import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivo {
    public void leerRondas(String[] args) throws FileNotFoundException {
        try {
            Atributos.input = new Scanner(Atributos.file);
            Atributos.rondas = Atributos.input.nextInt();

            Condiciones condiciones = new Condiciones();
            condiciones.verificarRondas(Atributos.input, args);
        } catch (Exception e) {
            System.out.println("No se pudo leer el numero de rondas ");
        }
    }
}
