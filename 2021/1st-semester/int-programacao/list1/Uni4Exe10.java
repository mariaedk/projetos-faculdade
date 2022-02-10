import java.util.Scanner;

public class Uni4Exe10 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        // Inputs
        System.out.print("- Idade de Marquinhos: ");
        int marquinhos = reader.nextInt();
        System.out.println();

        System.out.print("- Idade de Zezinho: ");
        int zezinho = reader.nextInt();
        System.out.println();

        System.out.print("- Idade de Luluzinha: ");
        int luluzinha = reader.nextInt();
        System.out.println();

        // Process
        if ((luluzinha < zezinho) && (luluzinha < marquinhos)){
            System.out.print("* Luluzinha é a caçula.");
        }
        if ((zezinho < luluzinha) && (zezinho < marquinhos)){
            System.out.print("* Zezinho é o caçula.");
        }
        if ((marquinhos < luluzinha) && (marquinhos < zezinho)){
            System.out.print("* Marquinhos é o caçula.");
        }
        reader.close();
    }
}
