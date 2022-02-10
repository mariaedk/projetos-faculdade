import java.util.Scanner;

public class Uni4Exe25 {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("          *-*-*-*-*-*-*-*-* BASIC CALCULATOR *-*-*-*-*-*-*-*-*");

        System.out.print(" - Inform number 1: ");
        double number1 = reader.nextDouble();
        System.out.print(" - Inform number 2: ");
        double number2 = reader.nextDouble();

        System.out.print(" - Type 1 for the SUM of two numbers;");
        System.out.println();
        System.out.print(" - Type 2 for the DIFFERENCE between two numbers;");
        System.out.println();
        System.out.print(" - Type 3 for the PRODUCT between two numbers;");
        System.out.println();
        System.out.print(" - Type 4 for the DIVISION between two numbers;");
        System.out.println();
        int choice = reader.nextInt();

        switch(choice){

            case 1: 
            double sum = number1 + number2;
            System.out.print("The SUM between number 1 and number 2 is: " + sum);
            break;

            case 2:
            double difference = number1 - number2;
            System.out.print("The DIFFERENCE between number 1 and number 2 is: " + difference);
            break;

            case 3: 
            double product = number1 * number2;
            System.out.print("The PRODUCT between number 1 and number 2 is: " + product);
            break;

            case 4:
            if ( number2 > 0 || number2 < 0 ){
                double division = number1 / number2;
                System.out.print("The DIVISION between number 1 and number 2 is: " + division);
            } else if ( number2 == 0 ){
                System.out.print("Number 2 is 0. Cannot perform the division.");
            }
            break;

            default: System.out.print("Invalid option. Please try again.");
        }
        reader.close();
    }
}
