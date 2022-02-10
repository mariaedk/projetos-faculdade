import java.util.Scanner;

public class Uni4Exe14 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        System.out.println("Day: ");
        int day = reader.nextInt();
        System.out.println("Month: ");
        int month = reader.nextInt();
        System.out.println("Year: ");
        int year = reader.nextInt();

        // Days
        boolean thirtyOneDaysMonth = day >= 1 && day <= 31 && month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12;
        boolean thirtyDaysMonth = day >= 1 && day <= 30 && month == 4 || month == 6 || month == 9 || month == 11;

        // Months
        boolean monthOK = month >= 1 && month <= 12;

        // Leap year
        boolean leapYear = day == 29 && month == 2 && year % 4 == 0;
        boolean notLeapYear = day == 28 && month == 2 && !(year % 4 ==0);
        boolean validLeap = leapYear || notLeapYear;

        boolean validDate = (monthOK && thirtyDaysMonth) || (monthOK && thirtyOneDaysMonth) || validLeap;

        if (validDate && year > 0 && day >= 1) {
            System.out.print("Valid date.");
        } else {
            System.out.print("Invalid date.");
        }
        reader.close();
    }
}
