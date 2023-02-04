import java.io.*;

public class AbrirArchivo {
    public void leerArchivo(String[] args) throws FileNotFoundException {
        if (args.length == 2) { // mando a llamar por consola del SO
            try (BufferedReader reader = new BufferedReader(new FileReader(Atributos.inputFileName))) {
                Atributos.inputFileName = args[0];
                Atributos.outputFileName = args[1];

                Atributos.file = new File(Atributos.inputFileName);

                if (Atributos.file.exists()) {
                    // se creo
                    LeerArchivo leerArchivo = new LeerArchivo();
                    leerArchivo.leerRondas(args);
                } else {
                    System.out.println("Archivo no encontrado");
                }
            } catch (IOException e) {
                System.out.println("Error leyendo archivo");
            }
        } else if (args.length == 0) {
            String nombre = "file.txt";

            System.out.println("1- Abrir otro archivo\nOtro numero para leer el archivo predeterminado\nQue decea: ");
            int res = Atributos.scanner.nextInt();

            if (res == 2) {
                Atributos.scanner.nextLine(); // limpiar bufer
                System.out.println("Digite la ruta del archivo a abrir: ");
                nombre = Atributos.scanner.nextLine();
            }

            Atributos.file = new File(nombre);

            if (Atributos.file.exists()) {
                // se creo
                LeerArchivo leerArchivo = new LeerArchivo();
                leerArchivo.leerRondas(args);
            } else {
                System.out.println("Archivo no encontrado");
            }
        }
        else {
            System.out.println("El numero de parametros no coincide");
        }
    }
}
