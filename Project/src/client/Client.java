package client;

import facade.Facade;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Facade facade = Facade.getInstance();
        String filePath = "test.txt";

        System.out.println("=== MENÚ ===");
        System.out.println("1. Escribir archivo (cifrado Base64)");
        System.out.println("2. Leer archivo (descifrado Base64)");
        System.out.print("Elige una opción (1 o 2): ");
        String opcion = scanner.nextLine();

        try {
            switch (opcion) {
                case "1":
                    System.out.print("Introduce el texto a escribir: ");
                    String contenido = scanner.nextLine();
                    facade.writeEncrypted(filePath, contenido);
                    System.out.println("Archivo escrito y cifrado correctamente.");
                    break;
                case "2":
                    String leido = facade.readDecrypted(filePath);
                    System.out.println("Contenido descifrado del archivo:");
                    System.out.println(leido);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
