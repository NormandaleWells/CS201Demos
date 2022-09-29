import java.util.Scanner;

// This program tests an implemention of IntSet.  The input
// starts with an integer specifying the maximum number of
// elements in the set.  After that, each line is one of
// the following:
//
//  add N       -- adds N to the set
//  contains N  -- determines if N is in the set
//  count lo hi -- counts the number of set values in the given range

public class TestIntSet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int maxElements = sc.nextInt();
        Set set = new UnorderedIntSet(maxElements);
        // Set set = new OrderedIntSet(maxElements);

        System.out.printf("Using %s\n", set.getClass().getName());

        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equals("add")) {
                int n = sc.nextInt();
                set.add(n);
                System.out.printf("Added %d, new size is %d\n", n, set.size());
            } else if (command.equals("contains")) {
                int n = sc.nextInt();
                boolean b = set.contains(n);
                System.out.printf("%d is%s in the set\n", n, b ? "" : " not");
            } else if (command.equals("count")) {
                int lo = sc.nextInt();
                int hi = sc.nextInt();
                int c = set.countRange(lo, hi);
                System.out.printf("There are %d elements in the set between %d and %d\n", c, lo, hi);
            }
        }

        sc.close();
    }
}
