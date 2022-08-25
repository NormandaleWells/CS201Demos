import java.util.Arrays;
import java.util.Scanner;

public class SortInput {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Enter item %d: ", i+1);
            int number = sc.nextInt();
            numbers[i] = number;
        }
        sc.close();

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
