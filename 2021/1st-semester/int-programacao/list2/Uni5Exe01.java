import java.util.Scanner;

public class Uni5Exe01 {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        
        for (int counter = 1; counter <= 20; counter++){
            System.out.print("Type a number: ");
            int number = reader.nextInt();
            if (number % 2 == 0){
                System.out.println("Even.");
            } else if (number % 2 != 0){
                System.out.println("Odd.");
            }
        }
        reader.close();
    }
}

