public class GenericSet {
    // Add an integer to the set.  If this element already exists
    // in the set, ignore this call.  Since this may or may not
    // change the number of elements in the set, this function returns
    // the (potentially incremented) size of the set.  Therefore,
    // this should always be called like this:
    //
    //      numElements = add(set, numElements, value);
    //
    public static <T> int add(T[] set, int n, T value) {
        if (!contains(set, n, value)) {
            set[n++] = value;
        }
        return n;
    }

    // Check to see if a given integer is in the set.
    public static <T> boolean contains(T[] set, int n, T value) {
        int idx = ArrayUtils.find(set, 0, n, value);
        return idx != -1;
    }

    // Count the number of set elements in the range `[lo,hi)`.  Note
    // that this is a half-open range, so `hi` is not part of the range.
    public static <T extends Comparable<T>> int countRange(T[] set, int n,
            T lo, T hi) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (set[i].compareTo(lo) >= 0 && set[i].compareTo(hi) < 0)
                count++;
        }
        return count;
    }
}
