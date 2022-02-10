public class Uni5Exe22 {
    public static void main(String[] args) {
        int year = 1996;
        double sallary = 3000;
        double increase = 3;
        while (year != 2021){
            
            System.out.println("Current sallary: " + sallary);
            System.out.println("Current increase: " + increase);
            System.out.println("-----------------------------------");
            year = year + 1;
            sallary = sallary * increase;
            increase = increase * 2;
            
        }
    }
}
