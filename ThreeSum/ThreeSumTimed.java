import java.util.ArrayList;

public class ThreeSumTimed {

	public static int count(ArrayList<Integer> a) {
		int N = a.size();
		int count = 0;
		for (int i = 0; i < N; i++)
		{
//			int ai = a.get(i);
			for (int j = i + 1; j < N; j++)
			{
//				int aj = a.get(j);
				for (int k = j + 1; k < N; k++)
//					if (ai + aj + a.get(k) == 0)
					if (a.get(i) + a.get(j) + a.get(k) == 0)
						count++;
			}
		}
		return count;
	}

	public static int count(int[] a) {
		int N = a.length;
		int count = 0;
		for (int i = 0; i < N; i++)
		{
//			int ai = a[i];
			for (int j = i + 1; j < N; j++)
			{
//				int aj = a[j];
				for (int k = j + 1; k < N; k++)
//					if (ai + aj + a[k] == 0)
					if (a[i] + a[j] + a[k] == 0)
						count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Usage: java ThreeSumTimes <data> [array|ArrayList|both]");
			System.exit(0);
		}

		int[] a = InputUtils.readIntFile(args[0]);
		System.out.printf("N = %d\n", a.length);

		if (args[1].equals("array") || args[1].equals("both")) {
			Timer stopwatch = new Timer();
			int c = count(a);
			double time = stopwatch.elapsed();
			System.out.println(c);
			System.out.println("array elapsed time " + time);
		}

		if (args[1].equals("ArrayList") || args[1].equals("both")) {
			ArrayList<Integer> al = new ArrayList<Integer>(a.length);
			for (int i = 0; i < a.length; i++) {
				al.add(i, a[i]);
			}
			Timer stopwatch = new Timer();
			int c = count(al);
			double time = stopwatch.elapsed();
			System.out.println(c);
			System.out.println("ArrayList elapsed time " + time);
		}
	}
}
