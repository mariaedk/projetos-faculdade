import java.util.Scanner;

public class Uni5Exe13 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.print("how many times did you repleshiment? ");
        int timesReplenishment = reader.nextInt();
        double mileageStopBy = 0, totalMileage = 0, totalFuel = 0, odometer = 0, fuelValue = 0, actualOdometer = 0;

        for (int counter = 1; counter <= timesReplenishment; counter++){
            System.out.print("Actual odometer: ");
            odometer = reader.nextDouble();
            System.out.print("How many liters: ");
            fuelValue = reader.nextDouble();

            actualOdometer = odometer - actualOdometer;
            totalFuel = totalFuel + fuelValue;
            totalMileage = odometer + totalMileage;

            mileageStopBy = actualOdometer / fuelValue;
            System.out.println("Mileage by: " +mileageStopBy);
        }
        System.out.println("Average: " + totalMileage/totalFuel);
        reader.close();
    }
}
