import java.util.Scanner;

public class Uni4Exe08 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);
    
        // Input
        System.out.print("Type a letter to check if it's wether a vowel or not: ");
        char letter = reader.next().charAt(0);
        letter = Character.toUpperCase(letter);
        System.out.println();

        if ((letter == 'A') || (letter == 'E') || (letter == 'I') || (letter == 'O') || (letter == 'U')){
            System.out.print("The letter typed is a vowel.");
        }else{
            System.out.print("The letter typed is not a vowel.");
        }
        reader.close();
    }
}
