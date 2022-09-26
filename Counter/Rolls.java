public class Rolls {
    
    public static void main(String[] args) {

        final int numSides = 6;
        final int numRolls = 1000000;

        Counter[] rolls = new Counter[numSides];
        for (int i = 0; i < numSides; i++) {
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
