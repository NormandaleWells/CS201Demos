
// CountFlipos - sample client for the Counter class.

// Model 1000000 coin flips, tracking how many times
// heads or tails comes up.

public class CountFlips {
    
    public static void main(String[] args) {

        // Create the Counter objects to count the
        // number of heads and tails.  The 'new'
        // keyword will allocate the memory for
        // the object, and call the constructor.
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        // The 'final' keyword indicates that the
        // given variable is a constant.  This often
        // allows Java to create more efficient
        // code, and makes the code easier to read.
        // It also makes it easier to change the number
        // of flips, since this is defined in exactly
        // one place.
        final int numFlips = 1000000;

        // Flip a coin numFlips times.
        for (int i = 0; i < numFlips; i++) {

            // RandomUtils.bernoulli() generates a
            // random number in the range [0.0,1.0),
            // and compares it to the argument.  It
            // returns true if the generated number
            // is less than the argument, and false
            // otherwise.
            if (RandomUtils.bernoulli(0.5))
                heads.increment();
            else
                tails.increment();
        }

        // Write out the results.  To print an object,
        // println() will use toString() to convert it
        // to a String.  Since toString() is defined
        // in the Object class, and ALL classes inherit
        // from Object, toString() is guaranteed to be
        // available for every object.
        System.out.println(heads);
        System.out.println(tails);

        if (heads.equals(tails))
            System.out.println("The counts were equal!");
    }
}
