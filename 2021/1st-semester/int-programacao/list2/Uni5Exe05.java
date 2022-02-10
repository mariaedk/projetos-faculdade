import java.util.Scanner;

public class Uni5Exe05 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int number1 = 8;
        int number2 = 10;
        
        System.out.print("Number greater than 2: ");
        double n = reader.nextDouble();

        if (n > 2){
            System.out.print(number1 + " " + number2 + " ");
            for (int counter = 1; counter < (n/2); counter++){
                number2 = number1 + number2;
                number1 = number1 * 2;
                System.out.print(number1 + " " + number2 + " ");
            }
        }
        reader.close();
    }
}
