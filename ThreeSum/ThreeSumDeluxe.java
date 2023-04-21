
import java.util.Arrays;

public class ThreeSumDeluxe {

	public static int lowerBound(int[] a, int lo, int hi, int key) {
		while (lo < hi) {
			// invariant : for all i in [0,lo), a[i] < key
			// invariant : for all i in [hi,l), a[i] >= key
			int mid = lo + (hi - lo) / 2;
			if (a[mid] < key)
				lo = mid + 1;
			else
				hi = mid;
		}
		// invariant : lo == hi
		// postcondition : for all i in [0,k) a[i] < key
		// postcondition : for all i in [k,l) a[i] >= key
		return lo;
	}

	public static int upperBound(int[] a, int lo, int hi, int key) {
		while (lo < hi) {
			// invariant : for all i in [0,lo), a[i] <= key
			// invariant : for all i in [hi,l), a[i] > key
			int mid = lo + (hi - lo) / 2;
			if (a[mid] <= key)
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}

	public static int count(int[] a) {
		int N = a.length;
		Arrays.sort(a);
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			// int ai = a[i];
			for (int j = i + 1; j < N; j++) {
				int key = -(a[i] + a[j]);
				int lb = lowerBound(a, j + 1, N, key);
				int ub = upperBound(a, j + 1, N, key);
				cnt += (ub - lb);
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		int[] a = InputUtils.readIntFile(args[0]);
		Timer stopwatch = new Timer();
		int c = count(a);
		double time = stopwatch.elapsed();
		System.out.println(c);
		System.out.println("elapsed time " + time);
	}
}
