
public class TwoSum {

	public static int count(int[] a) {
		int N = a.length;
		int count = 0;
		for (int i = 0; i < N; i++) {
//			int ai = a[i];
			for (int j = i + 1; j < N; j++)
//				if (ai + a[j] == 0)
				if (a[i] + a[j] == 0)
					count++;
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
