import java.util.Scanner;

public class Uni5Exe24 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Diary limit of fishing (KG): ");
        double diaryLimit = reader.nextDouble();
        diaryLimit = diaryLimit * 1000;
        double fishWeight = 0, totalWeight = 0;
        char data = 'S';

        while (data == 'S'){
            System.out.print("Weight of the fish (G): ");
            fishWeight = reader.nextDouble();
            totalWeight = totalWeight + fishWeight;

            if (totalWeight > diaryLimit){
                System.out.print("You have reached/passed the Diary Limit of fishing."); break; 
            }
            System.out.println("Total weight so far: " + totalWeight + "g.");
            System.out.print("Do you wish to inform another fish? (s) for YES (n) for NO: ");
            data = reader.next().charAt(0);
            data = Character.toUpperCase(data);
        }
        reader.close();
    }
}
