import java.util.Scanner;

public class Uni4Exe04 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        // Input
        System.out.print("Type a number: ");
        double number = reader.nextDouble();

        // Process
        double rest = number - Math.floor(number);

        if (rest != 0){
            System.out.print("The informed number has decimal places.");
        }
        else{
            System.out.print("The informed number doesn't have decimal places.");
        }
        
        reader.close();
    }
}
