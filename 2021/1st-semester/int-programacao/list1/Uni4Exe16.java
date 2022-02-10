import java.util.Scanner;

public class Uni4Exe16 {
    public static void main(String[] args) throws Exception {
        // Scanner to get user inputs
        Scanner reader = new Scanner(System.in);

        // Inputs
        System.out.print("Age of the first man: ");
        int manAge1 = reader.nextInt();
        
        System.out.print("Age of the second man: ");
        int manAge2 = reader.nextInt();

        System.out.print("Age of the first woman: ");
        int womanAge1 = reader.nextInt();

        System.out.print("Age of the second woman: ");
        int womanAge2 = reader.nextInt();

        int add = 0;
        int multiply = 0;

        // Process

        // Addition

        // If woman 2 is the youngest:
        if ((manAge1 > manAge2) && (womanAge1 > womanAge2)){
            add = manAge1 + womanAge2;
        } else if ((manAge2 > manAge1) && (womanAge1 > womanAge2)){
            add = manAge2 + womanAge2;

        // If woman 1 is the youngest:
        } else if ((manAge1 > manAge2) && (womanAge2 > womanAge1)){
            add = manAge1 + womanAge1;
        } else if ((manAge2 > manAge1) && (womanAge2 > womanAge1)){
            add = manAge2 + womanAge1;
        }
        System.out.print("Older man + younger woman = " + add);
        System.out.println();

        // Multiplication

        // If man 2 is the youngest:
        if ((manAge1 > manAge2) && (womanAge1 > womanAge2)){
            multiply = manAge2 * womanAge1;
        } else if ((manAge1 > manAge2) && (womanAge2 > womanAge1)){
            multiply = manAge2 * womanAge2;

        // If man 1 is the youngest:
        } else if ((manAge2 > manAge1) && (womanAge1 > womanAge2)){
            multiply = manAge1 * womanAge1;
        } else if ((manAge2 > manAge1) && (womanAge2 > womanAge1)){
            multiply = manAge1 * womanAge2;
        }
        System.out.print("Younger man * older woman = " + multiply);

        reader.close();
    }
}
