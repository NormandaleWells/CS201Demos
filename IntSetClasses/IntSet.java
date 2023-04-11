public interface IntSet {

    // Add an item to the set.  If this item already
    // exists, this is effectively ignored.
    void add(int value);

    // Check to see if the Set contains the given
    // value, return 'true' if it does, and 'false'
    // otherwise.
    boolean contains(int value);

    // Return the current size of the Set (that is,
    // the number of elements).
    int size();

    // Check to see if the Set is empty.
    boolean isEmpty();
}
