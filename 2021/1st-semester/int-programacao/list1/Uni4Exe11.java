import java.util.Scanner;

public class Uni4Exe11 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        // Inputs
        System.out.print("-> Please inform the year of birth of the first child: ");
        int year1 = reader.nextInt();
        System.out.println();

        System.out.print("-> Please inform the year of birth of the second child: ");
        int year2 = reader.nextInt();
        System.out.println();

        System.out.print("-> Please inform the year of birth of the third child: ");
        int year3 = reader.nextInt();
        System.out.println();

        // Process
        if (year1 == year2 && year2 == year3 && year3 == year1){
            System.out.print("Triplets");
        } else {
            if ((year1 == year2) || (year1 == year3) ||  (year3 == year2)){
                System.out.print("Twins.");
            } else {
            if (year1 != year2 && year2 != year3 && year3 != year1){
            System.out.print("Siblings.");
            }
        }
    }
        reader.close();
    }
}
