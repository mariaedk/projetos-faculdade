import java.util.Scanner;

public class Uni5Exe07 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type how many numbers: ");
        int n = reader.nextInt();
        int greater = 1;
        int lower = 1;
        for (int counter = 1; counter <= n; counter++){
            int number = reader.nextInt();
            if (number > greater){
                greater = number;
            }
            if (number < lower){
                lower = number;
            }
        }
        System.out.println("Lower: "+lower);
        System.out.println("Greater: "+greater);
        reader.close();
    }
}
