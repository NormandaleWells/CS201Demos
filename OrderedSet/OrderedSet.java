
// OrderedSet implements the Set API using an
// ordered (i.e. sorted) array.  This is based
// off the OrderedIntSet code, with the necessary
// changes to make the class generic.

// This code still has the following issues:
//
//  (1) No error checking is performed.
//  (2) There is no way to iterate over the set elements.

public class OrderedSet<T extends Comparable<T>> implements Set<T> {

    // instance variables
    private T[] set;
    private int numElements;

    // constructor(s)

    // Creating an array of a type defined by a type parameter
    // is not as easy as
    //      set = new T[maxSize]
    // Instead, you have to (1) lie to the compiler and "cast"
    // the result of the 'new' operator to T[], but you also
    // have to use @SuppressWarnings to tell the compiler "Yes,
    // I know I'm lying to you, but trust me, I'm a professional".
    // Also, because we require the T implement the Comparable
    // interface, we cannot create an array of Object, but rather
    // Comparable, since not every object is Comparable.
    @SuppressWarnings("unchecked")
    public OrderedSet(int maxSize) {
        set = (T[])new Comparable[maxSize];
        numElements = 0;
    }

    // A private method is available to this class but is not
    // visible to any other part of the program.  In this case,
    // we're just wrapping the call to lowerBound().
    // Also, this gives us only one place to document the oddity
    // that the returned index may not be a valid index!  In
    // the case where 'value' is greater than every set element,
    // set.length will be returned, and the caller needs to
    // guard against this case.
    private int searchFor(T value) {
        return BinarySearch.lowerBound(set, 0, numElements, value);
    }

    @Override
    public void add(T value) {
        // lowerBound() returns the first index whose value is
        // greater than or equal to the given value.  Therefore,
        // lowerBound() returns an index that either (1) contains
        // the given element, or (2) indicates at what index the
        // new element would belong if inserted into the set.
        // However, we also need to guard against the possibility
        // that the given values is greater than all the set
        // elements, in which case we get back the upper index
        // of the range being searched, which is outside the
        // range!  Of course, if the new value is greater than
        // all the current elements, that end index is exactly
        // where we want to add it, but we still have to be
        // careful not to access that index.  To do this, we
        // take advantage of the short-circuit evaluation of
        // the || operator; if the left-hand side is true, the
        // right-hand side is not evaluated.
        int idx = searchFor(value);
        if (idx == numElements || !set[idx].equals(value)) {
            set[numElements++] = value;
            ArrayUtils.rotateRight(set, idx, numElements);
        }
    }

    // Check to see if a given integer is in the set.
    @Override
    public boolean contains(T value) {
        // The index returned by lowerBound may or may not contain
        // the given value!  It may not even be a value index at
        // all, if the value being searched for is larger than
        // all the current set elements.  But as with add(), we
        // can take advantage of the short-circuit evaluation used
        // by the && operator; if the left-hand side is false, it
        // does not evaluate the right-hand side.
        int idx = searchFor(value);
        return idx != numElements && set[idx].equals(value);
    }

    // Count the number of set elements in the range `[lo,hi)`.  Note
    // that this is a half-open range, so `hi` is not part of the range.
    @Override
    public int countRange(T lo, T hi) {
        // At first glance it would seem that we want to use upperBound
        // when looking for the high end of the range, but remember that
        // the range [lo,hi) is, itself, a half-open range, so we want
        // to exclude any element with that value.  Since if the 'hi'
        // value is in the set, upperBound() would return the index of
        // the next element after it, leaving the one containing 'hi'
        // with the range!
        int hiIdx = BinarySearch.lowerBound(set, 0, numElements, hi);
        int loIdx = BinarySearch.lowerBound(set, 0, numElements, lo);
        return hiIdx - loIdx;
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
