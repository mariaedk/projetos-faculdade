import java.util.Scanner;

public class Uni5Exe12 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("----- FLOYD'S TRIANGLE -----");
        System.out.print("Please inform how many lines you want to be shown: ");
        int userLines = reader.nextInt();
        int number = 0;
        for (int lines = 1; lines <= userLines; lines++){
            for (int counter = 1; counter <= lines; counter++){
                number = number + 1;
                System.out.print(number+" ");
                }
                System.out.println();
            }
        reader.close();
    }   
}
