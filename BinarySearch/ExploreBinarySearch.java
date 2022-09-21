
// This program takes an integer n, and displays the number of compares
// that binary search does to find the element at each index of an array
// of size n.
//
//  java ExploreBinarySearch <int>

public class ExploreBinarySearch {

    static int numChecks;

    // This is a plain ol' binary search implementation; it returns an index
    // idx such that a[idx] = value, or -1 if no element has the given value.
    // If there are multiple elements with the value being searched, the
    // actual index returned is effectively randomly chosen among the possible
    // indices where that value may be found.
    static public int binarySearch(int[] a, int value) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            // Invariant: if the element is in the array, it
            // is in the range [lo,hi).
            numChecks += 1;
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < value) {
                lo = mid + 1;
            } else if (a[mid] > value) {
                hi = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // Return the index of the first element greater than
    // or equal to the given value.
    public static int lowerBound(int[] a, int value) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            // Invariant:
            //      a[0,lo) < value
            //      a[hi,n) >= value]
            numChecks += 1;
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < value)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    // Return the index of the first element strictly greater
    // than the given value.
    public static int upperBound(int[] a, int value) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            // Invariant:
            //      a[0,lo) <= value
            //      a[hi,n) > value]
            numChecks += 1;
            int mid = lo + (hi - lo) / 2;
            if (a[mid] <= value)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void showResults(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        int total = 0;
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("%3d", counts[i]);
            total += counts[i];
        }
        System.out.println();

        System.out.printf("Average number of checks: %6.2f\n", (double)total / counts.length);
    }

    public static void testBinarySearch(int[] a) {
        System.out.println("Testing binarySearch()");
        int[] counts = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            numChecks = 0;
            int idx = binarySearch(a, i);
            if (idx != i)
                throw new RuntimeException("binarySearch failed!");
            counts[i] = numChecks;
        }
        showResults(counts);
    }

    public static void testLowerBound(int[] a) {
        System.out.println("Testing lowerBound()");
        int[] counts = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            numChecks = 0;
            int idx = lowerBound(a, i);
            if (idx != i)
                throw new RuntimeException("lowerBound failed!");
            counts[i] = numChecks;
        }
        showResults(counts);
    }

    public static void testUpperBound(int[] a) {
        System.out.println("Testing upperBound()");
        int[] counts = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            numChecks = 0;
            int idx = upperBound(a, i);
            if (idx != i+1)
                throw new RuntimeException("upperBound failed!");
            counts[i] = numChecks;
        }
        showResults(counts);
    }

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: java ExploreBinarySearch <int>");
            System.exit(0);
        }

        int n = Integer.parseInt(args[0]);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

        testBinarySearch(a);
        System.out.println();
        testLowerBound(a);
        System.out.println();
        testUpperBound(a);
    }
}
