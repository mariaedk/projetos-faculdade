import java.util.Scanner;

public class Uni4Exe05 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        // Input
        System.out.print("Is the color blue? Type true or false. ");
        boolean color = reader.nextBoolean();
        System.out.println();

        // Process
        if (color == true){
            System.out.print("Yes.");
        }
        else{
            System.out.print("No.");
        }
        reader.close();
    }
}
