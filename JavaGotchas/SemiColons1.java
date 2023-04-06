public class SemiColons1 {

    // Run with b1 = b2 = true
    // Change b1 to false
    // Change b1 back to true, change b2 to false
    // Use shift-alt-F (Shift-Option-F on Mac)

    public static void main(String[] args) {

        boolean b1 = true;
        boolean b2 = true;

        if (b1)
            if (b2)
                System.out.println("A");
        else
            System.out.println("B");
    }
}
