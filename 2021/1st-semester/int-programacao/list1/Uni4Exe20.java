import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni4Exe20 {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        DecimalFormat df_01 = new DecimalFormat("#.0");

        System.out.print("- First test student's grade: ");
        double grade1 = reader.nextDouble();

        System.out.print("- Second test student's grade: ");
        double grade2 = reader.nextDouble();

        System.out.print("- Third test student's grade: ");
        double grade3 = reader.nextDouble();

        System.out.print("- Student's grade on exercises: ");
        double gradeExercises = reader.nextDouble();

        double average = (grade1 + (grade2 * 2.0) + (grade3 * 3.0) + gradeExercises) / 7.0;

        if ((average >= 9) || ((average >= 7.5) && (average < 9)) || ((average >= 6) && (average < 7.5))){
            if (average >= 9){
                System.out.println("Concept: A");
            } else if (((average >= 7.5) && (average < 9))){
                System.out.println("Concept: B");
            } else if (((average >= 6) && (average < 7.5))){
                System.out.println("Concept: C");
            }
            System.out.println("Average: " + df_01.format(average));
            System.out.print("The studdent is approved.");

        } else if (((average >= 4) && (average < 6)) || (average < 4)){
            if ((average >= 4) && (average < 6)){
                System.out.println("Concept: D");
            } else if ((average < 4)){
                System.out.println("Concept: E");
            }
            System.out.println("Average: " + df_01.format(average));
            System.out.print("The student is not approved.");
        }
        reader.close();
    }
}
