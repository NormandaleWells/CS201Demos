
public final class TestUtils {

	// Don't allow an object of this type to be created.
	private TestUtils() {
	}

	public static String[] iterToArray(Iterable<String> iter, int nExpected) {

		String[] a = new String[nExpected];
		int idx = 0;
		for (String s : iter) {
			a[idx++] = s;
		}
		return a;
	}

	// Prints the given array as
	//
	//		[e1, e2, e2]
	//
	public static <T> void printArray(T[] a) {
		
		System.out.print("[");
		if (a.length != 0)
			System.out.print(a[0]);
		for (int i = 1; i < a.length; i++)
			System.out.printf(", %s", a[i].toString());
		System.out.print("]");
	}

	// Returns the number of indices for which a[i] == b[i].
	// The arrays 'a' and 'b' must be the same size.
	public static <T> int countEqual(T[] a, T[] b) {
		assert(a.length == b.length);
		int count = 0;
		for (int i = 0; i < a.length;)
			if (a[i].equals(b[i]))
				count += 1;
		return count;
	}

}
