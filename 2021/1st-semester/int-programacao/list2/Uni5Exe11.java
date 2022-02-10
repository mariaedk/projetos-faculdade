import java.util.Scanner;
import java.lang.Math;

public class Uni5Exe11 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Time when machine has been started: ");
        int time = reader.nextInt();
        System.out.println("Processing...");
        System.out.println("--------------------------------------------------------");

        for (int counter = 1; counter <= 16; counter++){ 
            int hour = counter;       
            double cookies = Math.pow(3, (hour-1));
            int finalTime = hour + time;
            System.out.println("Time: "+finalTime);
            System.out.println("Cookies: "+cookies);
            System.out.println("--------------------------------------------------------");
        }
        reader.close();
    }
}