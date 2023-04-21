
import java.util.Arrays;

public class TwoSumDeluxe {

	public static int count(int[] a) {
		int N = a.length;
        Arrays.sort(a);
		int count = 0;
		for (int i = 0; i < N; i++) {
            int k = Arrays.binarySearch(a, -a[i]);
            if (k > i) count++;
		}
		return count;
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
