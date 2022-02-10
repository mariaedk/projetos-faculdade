public class Uni5Exe02 {
    public static void main(String[] args) throws Exception {
        int sumEven = 0;
        int sumOdd = 0;
        for (int counter = 1; counter <= 100; counter ++){
            if ((counter % 2) == 0){
                sumEven += counter;
            } else { 
                sumOdd += counter;
            }
        }
        System.out.println(sumOdd);
        System.out.print(sumEven);
    }
}
