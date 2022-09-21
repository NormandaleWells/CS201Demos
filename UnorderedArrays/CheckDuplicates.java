import java.util.Scanner;

public class CheckDuplicates {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numToRead = sc.nextInt();

        // numToRead is an upper bound for the number of elements we
        // may have in the set, so we'll use that to initialize the
        // array containing the set.
        int[] set = new int[numToRead];
        int numElements = 0;

        // In order to make the timings more meaningful, we'll read
        // all the data into an array first, then create the set.
        int[] elements = new int[numToRead];
        for (int i = 0; i < numToRead; i++) {
            elements[i] = sc.nextInt();
        }

        Timer timer = new Timer();
        for (int element : elements) {
            numElements = IntSet.add(set, numElements, element);
        }
        double elapsed = timer.elapsed();

        System.out.printf("There were %d duplicate items.\n",
                numToRead - numElements);
        System.out.printf("Elapsed time: %8.3f seconds.\n", elapsed);

        sc.close();
    }
}
