import java.util.Scanner;

public class Uni5Exe20 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int time = 0;
        System.out.print("Weight: ");
        double weight = reader.nextDouble();
        double grams = weight * 1000;
        while (grams > 0.5){
            for (int timer = 1; grams > 0.5; timer++){
                if (timer % 50 == 0){
                    grams = grams / 2;
                    time = time + 50;
                }
            }
        }
        System.out.println("Initial weight: " + weight * 1000 + " in grams");
        System.out.println("Final weight: " + grams + " in grams");
        System.out.print("Time taken: " + time + " seconds.");
        reader.close();
    }
}
