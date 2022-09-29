
// OrderedIntSet implements the Set API using an
// ordered (i.e. sorted) array.  This is based
// off the UnorderedIntSet code, with the necessary
// changes to keep the array sorted as we add
// elements to the set.

// I chose to leave out documentation that is
// redundant with UnorderedIntSet; the documentation
// here concentrates on the changes made to keep the
// array sorted.

// This code still has the following issues:
//
//  (1) It is specific to integers.
//  (2) No error checking is performed.
//  (3) There is no way to iterate over the set elements.

public class OrderedIntSet implements Set {

    // instance variables

    private int[] set;
    private int numElements;

    public OrderedIntSet(int maxSize) {
        set = new int[maxSize];
        numElements = 0;
    }

    @Override
    public void add(int value) {
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
        int idx = IntBinarySearch.lowerBound(set, 0, numElements, value);
        if (idx == numElements || set[idx] != value) {
            // To get the new element into the right place, the
            // easiest way is to add it at the end and then rotate
            // it into place.
            set[numElements++] = value;
            IntArrayUtils.rotateRight(set, idx, numElements);
        }
    }

    // Check to see if a given integer is in the set.
    @Override
    public boolean contains(int value) {
        // The index returned by lowerBound may or may not contain
        // the given value!  It may not even be a value index at
        // all, if the value being searched for is larger than
        // all the current set elements.  But as with add(), we
        // can take advantage of the short-circuit evaluation used
        // by the && operator; if the left-hand side is false, it
        // does not evaluate the right-hand side.
        int idx = IntBinarySearch.lowerBound(set, 0, numElements, value);
        return idx != numElements && set[idx] == value;
    }

    // Count the number of set elements in the range `[lo,hi)`.  Note
    // that this is a half-open range, so `hi` is not part of the range.
    @Override
    public int countRange(int lo, int hi) {
        // At first glance it would seem that we want to use upperBound
        // when looking for the high end of the range, but remember that
        // the range [lo,hi) is, itself, a half-open range, so we want
        // to exclude any element with that value.  Since if the 'hi'
        // value is in the set, upperBound() would return the index of
        // the next element after it, leaving the one containing 'hi'
        // with the range!
        int hiIdx = IntBinarySearch.lowerBound(set, 0, numElements, hi);
        int loIdx = IntBinarySearch.lowerBound(set, 0, numElements, lo);
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
