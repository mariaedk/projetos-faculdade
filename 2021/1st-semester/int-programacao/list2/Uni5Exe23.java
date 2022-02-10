
import java.util.Scanner;

public class Uni5Exe23 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        char data = 's';
        System.out.print("Name: ");
        String name = reader.next();
        int products = 0, qtySold = 0;
        double productPrice = 0, totalSold = 0, sallary = 0;

        while (data == 's'){
            System.out.print("How many types of products have been sold? ");
            products = reader.nextInt();
            for (int counter = 0; counter < products; counter++){
                System.out.print("Type the product's price: ");
                productPrice = reader.nextDouble();
                System.out.print("Quantity of the same product sold: ");
                qtySold = reader.nextInt();
                totalSold = totalSold + (productPrice * qtySold);
            }
            sallary = totalSold * 0.3;
            System.out.println("Name: " + name);
            System.out.println("Total sold: " + totalSold);
            System.out.println(name + "'s sallary is: $" + sallary);
            System.out.print("Deseja digitar os dados de mais um vendedor? s (SIM) / n (NÃO) " );
            data = reader.next().charAt(0);
            if (data == 'n'){
                break;
            }
            System.out.print("Name: ");
            name = reader.next();
        }
        reader.close();
    }
}
