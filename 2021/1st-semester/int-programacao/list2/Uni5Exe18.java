import java.util.Scanner;

public class Uni5Exe18 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int channelNumber = 0, numberPeople = 0, numberPeopleC4 = 0, numberPeopleC5 = 0, numberPeopleC9 = 0, numberPeopleC12 = 0, numberTotal = 0;  
        System.out.println("-------------------------------CALCULATOR---------------------------------");
        System.out.print("Channel number: ");
        channelNumber = reader.nextInt();
        System.out.print("Number of people watching the currently channel: ");
        numberPeople = reader.nextInt();

        while (channelNumber != 0){
            
            if (channelNumber == 4) {
                numberPeopleC4 = numberPeopleC4 + numberPeople;
            } else if (channelNumber == 5) {
                numberPeopleC5 = numberPeopleC5 + numberPeople;
            } else if (channelNumber == 9) {
                numberPeopleC9 = numberPeopleC9 + numberPeople;
            } else if (channelNumber == 12) {
                numberPeopleC12 = numberPeopleC12 + numberPeople;
            } 
            numberTotal = numberPeople + numberTotal;

            System.out.println("-------------------------------------------------------------------");
            System.out.print("Channel number: ");
            channelNumber = reader.nextInt();
            if (channelNumber == 0){
                break;
            }
            System.out.print("Number of people watching the currently channel: ");
            numberPeople = reader.nextInt();
        }

        System.out.println("-------------------------------------------------------------------");
        System.out.println("Channel 4 percentage: " + (numberPeopleC4 * 100) / numberTotal + "%");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Channel 5 percentage: " + (numberPeopleC5 * 100) / numberTotal + "%");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Channel 9 percentage: " + (numberPeopleC9 * 100) / numberTotal + "%");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Channel 12 percentage: " + (numberPeopleC12 * 100) / numberTotal + "%");
        System.out.println("-------------------------------------------------------------------");
        reader.close();
    }
}

