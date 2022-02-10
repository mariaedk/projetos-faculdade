import java.util.Scanner;

public class Uni4Exe02 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        // Input
        System.out.print("Type a number greater than 0: ");
        int number = reader.nextInt();
        System.out.println();

        // Process
        if (number % 2 == 0){
            // Possible output 1
            System.out.print("Even.");
        }
        else{
            // Possible output 2
            System.out.print("Odd.");
        }
        
        reader.close();
    }
}
