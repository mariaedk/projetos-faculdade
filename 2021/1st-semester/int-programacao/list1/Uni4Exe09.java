import java.util.Scanner;

public class Uni4Exe09 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        // Inputs
        System.out.print("Type an integer and the greater number: ");
        int number1 = reader.nextInt();
        System.out.println();

        System.out.print("Type an integer aswell: ");
        int number2 = reader.nextInt();
        System.out.println();

        // Process
        if (number1 % number2 == 0 || number2 % number1 == 0){
            System.out.print(number1 + " is multiple of " + number2 + ".");
        }else{
            System.out.print(number1 + " is not a multiple of " + number2 + ".");
        }
        reader.close();
    }
}
