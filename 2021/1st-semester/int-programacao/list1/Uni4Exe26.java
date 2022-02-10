import java.util.Scanner;

public class Uni4Exe26 {
    public static void main(String[] args) throws Exception {
        // Scanner for user's inputs
        Scanner reader = new Scanner(System.in);

        System.out.print("----------- GEOMETRIC CALCULATOR -----------");
        System.out.println();
        System.out.println("You have the following options: ");
        System.out.println("Press T to calculate the area of a triangle; ");
        System.out.println("Press Q to calculate the area of a square;");
        System.out.println("Press R to calculate the area of a rectangle;");
        System.out.println("Press C to calculate the area of a circle;");

        char choice = reader.next().charAt(0);
        choice = Character.toUpperCase(choice);

        // A block of code for each option that the user might choose:

        switch(choice){
            case 'T': 
            System.out.print("Base: ");
            double baseT = reader.nextDouble();
            System.out.print("Height: ");
            double heightT = reader.nextDouble();
            double triangleArea = (baseT * heightT) / 2;

            System.out.print("The area is: " + triangleArea); break;

            case 'Q':
            System.out.print("Side: ");
            double side = reader.nextDouble();
            double squareArea = side * side;

            System.out.print("The area is: " + squareArea); break;

            case 'R':
            System.out.print("Base: ");
            double baseR = reader.nextDouble();
            System.out.print("Height: ");
            double heightR = reader.nextDouble();
            double rectangleArea = baseR * heightR;

            System.out.print("The area is: " + rectangleArea); break;

            case 'C':
            System.out.print("Radius: ");
            double radius = reader.nextDouble();
            double pi = 3.1415926;
            double areaCircle = pi * (radius * radius);

            System.out.print("The area is: " + areaCircle); break;

            default: System.out.print("Invalid input.");
        }
        reader.close();
    }
}
