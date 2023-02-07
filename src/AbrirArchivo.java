import java.io.*;

public class AbrirArchivo {
    public static void leerArchivo(String[] args) throws FileNotFoundException {
        if (args.length == 2) { // mando a llamar por consola del SO
            Atributos.inputFileName = args[0]; 

            try (BufferedReader reader = new BufferedReader(new FileReader(Atributos.inputFileName))) {
                Atributos.outputFileName = args[1];

                Atributos.file = new File(Atributos.inputFileName);

                if (Atributos.file.exists()) {
                    // se creo
                    LeerArchivo.leerRondas(args);
                } else {
                    System.out.println("Archivo no encontrado");
                }
            } catch (IOException e) {
                System.out.println("Error leyendo archivo");
            }
        } else if (args.length == 0) {
            System.out.println("1- Abrir archivo predeterminado\nOtro numero para ingresar la ruta del archivo\nQue decea: ");
            int res = Atributos.scanner.nextInt();

            if (res != 1) {
                Atributos.scanner.nextLine(); // limpiar bufer
                System.out.println("Digite la ruta del archivo a abrir: ");
                Atributos.inputFileName = Atributos.scanner.nextLine();
            }

            Atributos.file = new File(Atributos.inputFileName);

            if (Atributos.file.exists()) {
                // se creo
                LeerArchivo.leerRondas(args);
            } else {
                System.out.println("Archivo no encontrado");
            }
        }
        else {
            System.out.println("El numero de parametros no coincide");
        }
    }
}
