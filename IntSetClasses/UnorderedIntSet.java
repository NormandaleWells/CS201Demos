
// UnorderedIntSet implements the Set API using an
// unordered (i.e. unsorted) array.  This is based
// off the older IntSet 'class' that we worked on
// previously (which was not really a class; it was
// just a bunchh of static functions), but implemented
// properly as a class.

// This code still has the following issues:
//
//  (1) It is specific to integers.
//  (2) No error checking is performed.
//  (3) There is no way to iterate over the set elements.

public class UnorderedIntSet implements IntSet {

    // instance variables

    // In the older IntSet code, these were allocated by the
    // caller and passed in as functions parameters to each
    // function (add(), contains(), and countRange()).  Now
    // these are encapsulated in the OrderedIntSet class,
    // and initialized in the constructor.
    // It is possible to initialize these here, but since
    // we don't know the size of the array we need to
    // allocate, we'll hold off until the constructor call
    // before initializing them.
    private int[] set;
    private int numElements;

    // constructors

    // We have only a single constructor for this class, which
    // takes the maximum size of the set.
    public UnorderedIntSet(int maxSize) {
        set = new int[maxSize];
        numElements = 0;
    }

    // instance methods
    // See Set.java for a high-level description of what each
    // of these methods does.

    @Override
    public void add(int value) {
        // If the set does not contain this item, just add
        // it at the end.
        if (!contains(value)) {
            set[numElements++] = value;
        }
    }

    @Override
    public boolean contains(int value) {
        // We can find() to do the heavy lifting here.
        int idx = IntArrayUtils.find(set, 0, numElements, value);
        return idx != -1;
    }

    @Override
    public int countRange(int lo, int hi) {
        // Note that 'lo' and 'hi' are values here, rather
        // than indices.  This is contrary to our usual
        // usage (in which lo and hi are array indices),
        // and therefore possibly confusing.  Sorry.
        // Note that we cannot use IntArrayUtils.count()
        // here, since that only counts occurrences of a
        // specific value, so we'll need to loop over the
        // array one by one.
        int count = 0;
        for (int i = 0; i < numElements; i++)
            if (lo <= set[i] && set[i] < hi)
                count++;
        return count;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }
}
