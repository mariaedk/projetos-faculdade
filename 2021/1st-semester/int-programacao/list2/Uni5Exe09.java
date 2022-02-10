import java.util.Scanner;

public class Uni5Exe09 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Number of students: ");
        int n = reader.nextInt();
        int olderStudents = 0;
        String name;
        int age;

        for (int counter = 1; counter <= n; counter++){
            System.out.print(" --- Name: ");
            name = reader.next();
            System.out.print(" --- Age: ");
            age = reader.nextInt();
            System.out.println("-------------------------");

            if (age == 18){
                System.out.println("Students who are 18 y.o:" + name);
            }
            if (age >= 20){
                olderStudents++;
            }
        }
        
        System.out.println(olderStudents + " students are 20 years old or older.");
        System.out.println("-------------------------");
        reader.close();
    }
}
