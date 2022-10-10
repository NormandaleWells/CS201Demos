public interface Set<T> {
    
    // Add an item to the set.  If this item already
    // exists, this is effectively ignored.
    void add(T value);

    // Check to see if the Set contains the given
    // value, return 'true' if it does, and 'false'
    // otherwise.
    boolean contains(T value);

    // Count the number of elements whose values lie
    // in the half-open range [lo,hi).
    int countRange(T lo, T hi);

    // Return the current size of the Set (that is,
    // the number of elements).
    int size();

    // Check to see if the Set is empty.
    boolean isEmpty();
}
