import java.util.Scanner;

public class Uni5Exe06 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double sum = 0;
        for (int counter = 1; counter <= 20; counter++){
            System.out.print("Your height: ");
            double height = reader.nextDouble();
            sum+=height;
        }
        System.out.print("The average of all heights informed is: "+sum/20);
        reader.close();
    }
}
