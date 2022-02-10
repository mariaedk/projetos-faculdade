import java.util.Scanner;

public class Uni4Exe01 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        // Input
        System.out.print("Please inform how many hours you have worked in a month: ");
        double workedHours = reader.nextDouble();
        System.out.println();

        System.out.print("Please inform how much, in $, is the value of a worked hour: ");
        double hourValue = reader.nextDouble();
        System.out.println();

        double salary = workedHours * hourValue;
        
        // Process

        if (workedHours > 160){
            // More than 160 hours is overtime. 
            double overtime = workedHours - 160;
            double overtimeValue = hourValue * 0.5;
            salary = (overtimeValue * overtime) + salary; 
        }
        System.out.print("Your salary this month is $" + salary + ".");

        reader.close();
    }
}
