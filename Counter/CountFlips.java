public class CountFlips {
    
    public static void main(String[] args) {

        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        final int numFlips = 100000;

        for (int i = 0; i < numFlips; i++) {
            if (RandomUtils.bernoulli(0.5))
                heads.increment();
            else
                tails.increment();
        }

        System.out.println(heads);
        System.out.println(tails);
    }
}
