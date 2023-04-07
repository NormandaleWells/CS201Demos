import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CheckDuplicates {

    // Read the set contents from the given file.  The file should
    // have a count of the number of integers in the set, followed
    // by the integers themselves.
    private static IntSet createSet(String filename, boolean ordered) {

        System.out.printf("Reading set from %s\n", filename);

        IntSet set = null;

        try (FileInputStream setFile = new FileInputStream(filename)) {

            Scanner sc = new Scanner(setFile);

            int numToRead = sc.nextInt();

            // numToRead is an upper bound for the number of elements we
            // may have in the set, so we'll use that to initialize the
            // array containing the set.
            if (ordered)
                set = new OrderedIntSet(numToRead);
            else
                set = new UnorderedIntSet(numToRead);
    
            System.out.printf("Using %s\n", set.getClass().getName());

            // In order to make the timings more meaningful, we'll read
            // all the data into an array first, then create the set.
            int[] elements = new int[numToRead];
            for (int i = 0; i < numToRead; i++) {
                elements[i] = sc.nextInt();
            }
            sc.close();

            // Add the elements to the set.  Note that we're only timing
            // this part of the process.
            Timer timer = new Timer();
            for (int element : elements) {
                set.add(element);
            }
            double elapsed = timer.elapsed();
    
            System.out.printf("There were %d duplicate items.\n",
                    numToRead - set.size());
            System.out.printf("Elapsed time: %8.3f seconds.\n", elapsed);

        } catch (FileNotFoundException ex) {

            throw new RuntimeException(String.format("Could not find %s!", filename));

        } catch (IOException ex) {

            throw new RuntimeException(String.format("IO Exception: %s", ex.getMessage()));
        }

        return set;
    }

    // check - check to see if the integers in the given file are in the set.
    // The file should have a count of the number of integers in the set, followed
    // by the integers themselves.
    private static void check(IntSet set, String filename) {
        System.out.printf("Reading integers from %s\n", filename);

        try (FileInputStream setFile = new FileInputStream(filename)) {

            Scanner sc = new Scanner(setFile);

            int numToRead = sc.nextInt();

            // In order to make the timings more meaningful, we'll read
            // all the data into an array first, then create the set.
            int[] elements = new int[numToRead];
            for (int i = 0; i < numToRead; i++) {
                elements[i] = sc.nextInt();
            }
            sc.close();

            // Check to see if the elements are in the set, and keep
            // track of the number that are.
            Timer timer = new Timer();
            int count = 0;
            for (int element : elements) {
                if (set.contains(element))
                    count++;
            }
            double elapsed = timer.elapsed();
    
            System.out.printf("%d of %d integers were in the set\n", count, numToRead);
            System.out.printf("Elapsed time: %8.3f seconds.\n", elapsed);

        } catch (FileNotFoundException ex) {

            throw new RuntimeException(String.format("Could not find %s!", filename));

        } catch (IOException ex) {

            throw new RuntimeException(String.format("IO Exception: %s", ex.getMessage()));
        }
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("usage: java CheckDuplicates <set> \"ordered\"|\"unordered\" [<check>]");
            System.out.println("    <set> is a file containing the set elements");
            System.out.println("    \"ordered\"|\"unordered\" specifies the type of set to create");
            System.out.println("    <check> is a file containing the numbers to check");
            System.exit(0);
        }

        boolean ordered = true;
        if (args.length >= 2)
            ordered = args[1].equals("ordered");

        IntSet set = createSet(args[0], ordered);

        if (args.length > 2) {
            check(set, args[2]);
        }
    }
}
