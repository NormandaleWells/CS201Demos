
// Program to generate files containing arrays of integers.
//
// Usage:
//      GenerateIntArray N lo hi [-nocount] [-columns <int>]
//
//          N           - number of integers to generate
//          lo          - low end of range
//          hi          - high end of range
//          -nocount    - don't include count as first item
//          -columns    - number of columns of output
//
// There is no intelligence to the command line parsing; the
// options must be specified in the order shown.
//
// The output is written to standard output.

public class GenerateIntArray {

    public static void generateInts(int numInts, int lo, int hi, int numColumns) {
        for (int i = 0; i < numInts; i++) {
            int r = RandomUtils.uniform(lo, hi);
            System.out.print(r);
            if ((i+1) % numColumns == 0) {
                System.out.println();
            } else {
                System.out.print(' ');
            }
        }
    }

    public static void generateIntsNoDups(int numInts, int lo, int hi, int numColumns) {
        int range = hi - lo;
        Integer[] all = new Integer[range];
        for (int i = 0; i < range; i++) {
            all[i] = lo + i;
        }
        RandomUtils.shuffle(all);
        for (int i = 0; i < numInts; i++) {
            System.out.print(all[i]);
            if ((i+1) % numColumns == 0) {
                System.out.println();
            } else {
                System.out.print(' ');
            }
        }
    }
    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("usage: GenerateIntArray N lo hi [-nodup] [-nocount] [-columns <int>]");
            System.out.println("    Arguments (if present) must be specified in the order shown");
            System.exit(0);
        }

        int numInts = Integer.parseInt(args[0]);
        int lo = Integer.parseInt(args[1]);
        int hi = Integer.parseInt(args[2]);
        int nextArg = 3;
        boolean noCount = false;
        boolean noDup = false;
        int numColumns = 1;

        if ((args.length > nextArg) && args[nextArg].equals("-nodup")) {
            noDup = true;
            nextArg++;
        }

        if ((args.length > nextArg) && args[nextArg].equals("-nocount")) {
            noCount = true;
            nextArg++;
        }

        if ((args.length > nextArg) && args[nextArg].equals("-columns")) {
            numColumns = Integer.parseInt(args[nextArg+1]);
            nextArg += 2;
        }

        if (!noCount) {
            System.out.println(numInts);
        }

        if (noDup)
            generateIntsNoDups(numInts, lo, hi, numColumns);
        else
            generateInts(numInts, lo, hi, numColumns);
    }
}
