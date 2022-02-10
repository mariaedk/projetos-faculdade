import java.util.Scanner;


public class Uni4Exe07 {
    public static void main(String[] args) throws Exception {
        // Scanner gets user input
        Scanner reader = new Scanner(System.in);

        // Input
        System.out.print("Letter's weight: ");
        double weight = reader.nextDouble();
        System.out.println();
        double price = 0.45;

        // Process
        // Tira 50 do peso para descobrir o peso extra e divide por 20
        // Multiplica por 0.45 para descobrir o preço extra e adiciona ao preço fixo de 0.45
        if (weight > 50){
            price = ((weight - 50) / 20) * 0.45 + price;
        }
        System.out.print("The stamp's price is R$" + price);
        reader.close();
    }
}
