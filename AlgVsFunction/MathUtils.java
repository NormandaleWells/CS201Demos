import java.util.Scanner;

public class MathUtils {

    // This appears to be a perfectly good implementation
    // of this algorithm:
    //
    //      average(a : Z, b : Z) -> Z
    //          return (a + b) / 2
    //
    // (We're assuming reasonable integer round-off.)
    //
    // But try it with 1400000000 and 1600000000

    public static int average(int a, int b) {
        return (a + b) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("First  number: ");
        int a = sc.nextInt();
        System.out.print("Second number: ");
        int b = sc.nextInt();
        
        int result = average(a, b);
        
        System.out.printf("average(%d,%d) -> %d\n", a, b, result);
    }
}
