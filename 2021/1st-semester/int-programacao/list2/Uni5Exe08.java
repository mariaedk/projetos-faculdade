import java.util.Scanner;

public class Uni5Exe08 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        double lower = 0;
        int counterPositive = 0;
        double average = 0;
        for (int counter = 1; counter <= n; counter++){
            int number = reader.nextInt();
            if (number < 0 && number < lower){
                lower = number;
            }
            if (number > 0){
                average = average + number;
                counterPositive++;
            }
        }
        System.out.println("Average: " + average/counterPositive);
        System.out.print("Lowest negative number: "+lower);
        reader.close();
    }
}
