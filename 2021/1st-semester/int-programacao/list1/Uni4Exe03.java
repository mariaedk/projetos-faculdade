import java.util.Scanner;

public class Uni4Exe03 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        // Input
        System.out.print("Type a number: ");
        int number1 = reader.nextInt();
        System.out.println();

        System.out.print("Type another number: ");
        int number2 = reader.nextInt();
        System.out.println();

        // Process
        if (number1 > number2){
            System.out.print(number1 + " is greater than " + number2);
        }
        else{
            System.out.print(number2 + " is greater than " + number1);
        }

        reader.close();
    }
}
