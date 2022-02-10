import java.util.Scanner;

public class Uni4Exe06 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        // Input
        System.out.print("Type M for male, F for female or I for uninformed: ");
        char letter = reader.next().charAt(0);
        letter = Character.toUpperCase(letter);

        // Process

        if (letter == 'M') {
            System.out.print("Male");
        } else {
            if (letter == 'F') {
                System.out.print("Female");
            } else {
                if (letter == 'I') {
                    System.out.print("Uninformed");
                } else {
                    System.out.print("Incorrect input. Please type either M, F or I.");
                }
            }
        }
        reader.close();
    }
}
