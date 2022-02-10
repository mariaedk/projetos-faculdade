import java.util.Scanner;

public class Uni4Exe24 {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        System.out.print("Type the first number: ");
        int number1 = reader.nextInt();

        System.out.print("Type the second number: ");
        int number2 = reader.nextInt();

        System.out.print("Type the third number: ");
        int number3 = reader.nextInt();

        System.out.print(
                "- Options: 1) write the 3 values in ascending order;   2) write the 3 values in descending order;   3) write the 3 values in a way which the greatest number is in the middle; ");
        int numberChosen = reader.nextInt();

        switch (numberChosen) {
            case 1:
                if (number1 <= number2 && number1 <= number3){
                    if (number1 <= number2){
                        System.out.print(number1 + " " + number2 + " " + number3);
                    } else {
                        System.out.print(number1 + " " + number3 + " " + number2);
                    }
                } else if (number2 <= number1 && number2 <= number3){
                    if (number1 <= number3){
                        System.out.print(number2 + " " + number1 + " " + number3);
                    } else {
                        System.out.print(number2 + " " + number3 + " " + number1);
                    }
                } else if (number3 <= number1 && number3 <= number2){
                    if (number1 <= number2){
                        System.out.print(number3 + " " + number1 + " " + number2);
                    } else {
                        System.out.print(number3 + " " + number2 + " " + number1);
                    }
                } break;
            case 2:
                if (number1 >= number2 && number1 >= number3){
                    if (number1 >= number2){
                        System.out.print(number1 + " " + number2 + " " + number3);
                    } else {
                        System.out.print(number1 + " " + number3 + " " + number2);
                    }
                } else if (number2 >= number1 && number2 >= number3){
                    if (number1 >= number3){
                        System.out.print(number2 + " " + number1 + " " + number3);
                    } else {
                        System.out.print(number2 + " " + number3 + " " + number1);
                    }
                } else if (number3 >= number1 && number3 >= number2){
                    if (number1 >= number2){
                        System.out.print(number3 + " " + number1 + " " + number2);
                    } else {
                        System.out.print(number3 + " " + number2 + " " + number1);
                    }
                } break;

            case 3:
            if (number1 >= number2 && number1 >= number3){
                if (number1 <= number2){
                    System.out.print(number2 + " " + number1 + " " + number3);
                } else {
                    System.out.print(number3 + " " + number1 + " " + number2);
                }
            } else if (number2 >= number1 && number2 >= number3){
                if (number1 <= number3){
                    System.out.print(number1 + " " + number2 + " " + number3);
                } else {
                    System.out.print(number3 + " " + number2 + " " + number1);
                }
            } else if (number3 >= number1 && number3 >= number2){
                if (number1 <= number2){
                    System.out.print(number1 + " " + number3 + " " + number2);
                } else {
                    System.out.print(number2 + " " + number3 + " " + number1);
                }
            }
            reader.close();
        }
    }
}