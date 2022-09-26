
// Rolls - simulate rolling a die 1000000 times.

// This is a sample client for the Counter class,
// patterned after one in Sedgewick and Wayne.

// This is over-commented for pedagogical purposes.

public class Rolls {
    
    public static void main(String[] args) {

        final int numSides = 6;
        final int numRolls = 1000000;

        // Important detail: creating an array of Counter objects
        // only allocates the array itself; all the entries are
        // null.
        Counter[] rolls = new Counter[numSides];

        // To create the actual Counter objects, we need a loop
        // that creates them one at a time.
        for (int i = 0; i < numSides; i++) {
            // The Counter objects are named "1s", "2s", "3s", etc.
            // Since programmers starting counting at 0 and
            // normal people start with 1, we need to add 1 to
            // the index when creating the name.
            String sideName = String.format("%ds", i+1);
            rolls[i] = new Counter(sideName);
        }

        for (int i = 0; i < numRolls; i++) {
            int side = RandomUtils.uniform(0, numSides);
            rolls[side].increment();
        }

        for (int i = 0; i < numSides; i++) {
            System.out.println(rolls[i]);
        }
    }
}
