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
        String[] set = new String[maxElements];
        int numElements = 0;

        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equals("add")) {
                String n = sc.next();
                numElements = GenericSet.add(set, numElements, n);
                System.out.printf("Added %s, new size is %d\n", n, numElements);
            } else if (command.equals("contains")) {
                String n = sc.next();
                boolean b = GenericSet.contains(set, numElements, n);
                System.out.printf("%s is%s in the set\n", n, b ? "" : " not");
            } else if (command.equals("count")) {
                String lo = sc.next();
                String hi = sc.next();
                int c = GenericSet.countRange(set, numElements, lo, hi);
                System.out.printf("There are %d elements in the set between %s and %s\n", c, lo, hi);
            }
        }

        sc.close();
    }
}
