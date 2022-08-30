
// This version of ArrayUtils.find() is flawed, but (due to string pooling)
// the test code in main() does not fail.

// See IsAWeasley and IsASmallPrime for tests that do fail.

class ArrayUtils {

    // Spot the defect!!!
    public static <T> int find(T[] a, T value) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == value)
                return i;
        return -1;
    }

    public static boolean checkEA() {

        try {
            assert false;
            return false;
        } catch (AssertionError ae) {
        }

        return true;
    }

    public static void main(String[] args) {

        if (!checkEA()) {
            System.out.println("This needs to be run with the -ea flag.");
            System.exit(1);
        }

        // This will NOT catch the defect in find()!
        String[] weasleys = { "Bill", "Charlie", "Percy", "Fred", "George", "Ron", "Ginny" };
        assert find(weasleys, "Bill") == 0;
        assert find(weasleys, "Ginny") == 6;
        assert find(weasleys, "Fred") == 3;
        assert find(weasleys, "Molly") == -1;

        System.out.println("Tests complete.");
    }
}
