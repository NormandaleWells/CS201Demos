import java.io.FileNotFoundException;
import java.util.HashMap;

public class ThreeSumSuper {

	public static int count(int[] a) {

		HashMap<Integer,Integer> st = new HashMap<>();
//		RedBlackBST<Integer,Integer> st = new RedBlackBST<>();

		int N = a.length;
		for (int i = 0; i < N; i++)
			st.put(a[i], i);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int ai = a[i];
			for (int j = i + 1; j < N; j++) {
				Integer idx = st.get(-(ai+a[j]));
				if ((idx != null) && (idx > j))
					cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		int[] a = InputUtils.readIntFile(args[0]);

		Timer timer = new Timer();
		int c = count(a);
		double time = timer.elapsed();

		System.out.println(c);
		System.out.println("elapsed time " + time);
	}
}
