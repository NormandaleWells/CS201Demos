
// This programm will uncover the defect in ArrayUtils.find();
// sort of.  It only fails for numbers greater than 127.  (The
// exact cut-off value may depend on the Java implementation.)

import java.util.Scanner;

public class IsASmallPrime {

    public static void main(String[] args) {

        Integer[] smallPrimes = { 
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
            43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
            101, 103, 107, 109, 113, 127, 131, 137, 139, 149,
            151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
            199, 211, 223, 227, 229, 233, 239, 241, 251, 257,
            263, 269, 271, 277, 281, 283, 293
        };

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            Integer i = sc.nextInt();
            if (ArrayUtils.find(smallPrimes, i) == -1)
                System.out.printf("%d is not a prime\n", i);
            else
                System.out.printf("%d is a prime\n", i);
        }
        sc.close();
    }
}
