import java.util.Scanner;

public class Uni5Exe17 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.print("Athlete's height: ");
        double height = reader.nextDouble();
        System.out.print("Athlete's registration number: ");
        int registrationNumber = reader.nextInt();
        double tallestAthlete = height, shorterAthlete = height, averageHeight = 0;
        int athletes = 0, tallestRegistration = 0, shorterRegistration = 0;
        
        while (height != 0){
            if (height >= tallestAthlete){
                tallestAthlete = height;
                tallestRegistration = registrationNumber;
            } else if (height <= shorterAthlete){
                shorterAthlete = height;
                shorterRegistration = registrationNumber;
            }
            athletes = athletes + 1;
            averageHeight = height + averageHeight;

            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.print("Athlete's height: ");
            height = reader.nextDouble();
            if (height == 0){
                break;
            }
            System.out.print("Athlete's registration number: ");
            registrationNumber = reader.nextInt();
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Tallest athlete's height: " + tallestAthlete + " ----- Registration number: " + tallestRegistration);
        System.out.println("Shorter athlete's height: " + shorterAthlete + " ----- Registration number: " + shorterRegistration);
        System.out.print("Average height among the " + athletes + " athletes: " + averageHeight / athletes);
        System.out.println("------------------------------------------------------------------------------------------------------");
        reader.close();
    }
}
