import java.util.Scanner;

public class AverageInt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num_to_read = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < num_to_read; i++) {
            int num = sc.nextInt();
            sum += num;
        }

        sc.close();

        System.out.println(sum / num_to_read);
    }
    
}
