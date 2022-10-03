public class BinarySearch {

	// Don't allow an object of this type to be created.
	private BinarySearch() {
	}

	// All methods here have a precondition that no array passed
	// in as an argument many be null, and for all methods that
	// work with a [lo,hi) range, the lo and hi parameters must
	// be within range.

	// checkArgument() is used to check that an array argument
	// is non-null
	private static <T> boolean checkArguments(T[] a, boolean canBeEmpty) {
		assert a != null;
		assert canBeEmpty || a.length != 0;
		return true;
	}

	// checkArgument() is used to check that an array argument
	// is non-null and that the hi and lo arguments are
	// within range.  If canBeEmpty is false, it also checks
	// that the given range is not empty.
	private static <T> boolean checkArguments(T[] a, int lo, int hi, boolean canBeEmpty) {
		assert a != null;
		assert !canBeEmpty || hi - lo > 0;
		assert lo >= 0 && lo <= a.length;
		assert hi >= 0 && hi <= a.length;
		return true;
	}

	// exists()
    public static <T extends Comparable<T>>
	boolean exists(T[] a, int lo, int hi, T value) {
        int curLo = lo;
        int curHi = hi;

        while (curLo < curHi) {
            int mid = curLo + (curHi - curLo) / 2;
            if (a[mid].compareTo(value) == 0)
                return true;
            else if (a[mid].compareTo(value) < 0)
                curLo = mid + 1;
            else /* a[mid] > value */
                curHi = mid;
        }

        return false;
    }

    public static <T extends Comparable<T>> boolean exists(T[] a, T value) {
        return exists(a, 0, a.length, value);
    }

	// lowerBound() returns the index of the first element
	// of a[lo,hi) that is greater than or equal to 'value'.
	public static <T extends Comparable<T>>
	int lowerBound(T[] a, int lo, int hi, T value) {
		checkArguments(a, lo, hi, false);
		while (lo < hi) {
			// In all invariants, lo' and hi' are the original values
			// of lo and hi.
			// for all j in [lo',lo) a[mid] < value
			// for all j in [hi,hi') a[mid] >= value
			int mid = lo + (hi - lo) / 2;
			if (a[mid].compareTo(value) < 0)
				lo = mid + 1;
			else
				hi = mid;
		}
		// for all j in [lo',hi) a[mid] < value
		// for all j in [hi,hi') a[mid] >= value
		return hi;
	}

	// lowerBound() returns the index of the first element of
	// array 'a' that is greater than or equal to 'value'.
	public static <T extends Comparable<T>> int lowerBound(T[] a, T value) {
		checkArguments(a, false);
		return lowerBound(a, 0, a.length, value);
	}

	// upperBound() returns the index of the first element
	// of a[lo,hi) that is strictly greater than 'value'.
	public static <T extends Comparable<T>>
	int upperBound(T[] a, int lo, int hi, T value) {
		checkArguments(a, lo, hi, false);
		while (lo < hi) {
			// In all invariants, lo' and hi' are the original values
			// of lo and hi.
			// for all j in [lo',lo) a[mid] <= value
			// for all j in [hi,hi') a[mid] > value
			int mid = lo + (hi - lo) / 2;
			if (a[mid].compareTo(value) <= 0)
				lo = mid + 1;
			else
				hi = mid;
		}
		// for all j in [lo',hi) a[mid] <= value
		// for all j in [hi,hi') a[mid] > value
		return hi;
	}

	// upperBound() returns the index of the first element
	// of array 'a' that is strictly greater than 'value'.
	public static <T extends Comparable<T>> int upperBound(T[] a, T value) {
		checkArguments(a, false);
		return upperBound(a, 0, a.length, value);
	}
	
	public static void main(String[] args) {
		
		int i = 0;
		assert i++ == 0;
		if (i != 1) {
			System.out.println("This needs to be run with -ea.\n");
			return;
		}

		Integer[] a2 = { 2, 3, 3, 5, 7, 7, 7, 11 };
		
		// TODO: write a real JUnit test suite for these
		assert exists(a2, 2);
		assert exists(a2, 11);
		assert exists(a2, 7);
		assert !exists(a2, 1);
		assert !exists(a2, 12);
		assert !exists(a2, 6);
		assert lowerBound(a2, 7) == 4;
		assert upperBound(a2, 7) == 7;
		assert lowerBound(a2, 1) == 0;
		assert upperBound(a2, 1) == 0;
		assert lowerBound(a2, 12) == a2.length;
		assert upperBound(a2, 12) == a2.length;
	}
}
