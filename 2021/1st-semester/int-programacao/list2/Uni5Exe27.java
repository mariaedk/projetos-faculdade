import java.util.Scanner;

public class Uni5Exe27 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Day in april: ");
        int dayApril = reader.nextInt();
        double higherProduction = 0, totalDay = 0;
        int higherDay = 0, productedMorning = 0, productedAfternoon = 0, option = 0;

        if (dayApril > 30 || dayApril < 1){
            while (dayApril > 30 || dayApril < 1){
                System.out.println("Invalid day.");
                System.out.print("Day in april: ");
                dayApril = reader.nextInt();
            }
        }
        while (dayApril <= 30 && dayApril >=1){
            System.out.print("At morning: ");
            productedMorning = reader.nextInt();
            System.out.print("At afternoon: ");
            productedAfternoon = reader.nextInt();

            if (dayApril >= 1 && dayApril <= 15){
                if (productedMorning + productedAfternoon > 100 && (productedAfternoon > 30 && productedMorning > 30)){
                    totalDay = 0.80 * (productedAfternoon + productedMorning);
                } else {
                    totalDay = (productedAfternoon + productedMorning) * 0.50;
                }
            } else if (dayApril >= 16 && dayApril <= 30){
                totalDay = (productedMorning * 0.4) + (productedAfternoon * 0.3);
            }

            if (totalDay > higherProduction){
                higherProduction = totalDay;
                higherDay = dayApril;
            }
            System.out.println("Total Sallary: $" + totalDay);

            if (productedMorning > productedAfternoon){
                System.out.println("The employee produced more at the morning:" + productedMorning);
            } else {
                System.out.println("The employee produced more at the afternoon:  " + productedAfternoon);
            }

            System.out.print("New employee? 1(yes) 2(no): ");
            option = reader.nextInt();

            switch (option){
                case 1 :System.out.print("Dia abril:"); 
                        dayApril = reader.nextInt();
                        while (dayApril > 30 && dayApril < 1){
                            System.out.println("Invalid day.");
                            System.out.print("Day in april: ");
                            dayApril = reader.nextInt(); }
                        break;
                case 2 : dayApril = 0; break;
            }
        }
        System.out.println("Higher production day: " + higherDay);
        reader.close();
    }
}
