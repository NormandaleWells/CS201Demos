
// Timer class
//
// Modeled after Sedgewick and Wayne's Stopwatch class,
// but developed independently.

public class Timer {

	private long start;

	public Timer() {
		start = System.currentTimeMillis();
	}

	public double elapsed() {
		long curTime = System.currentTimeMillis();
		return (curTime - start) / 1000.0;
	}

	public static void main(String[] args) throws InterruptedException {

		Timer t = new Timer();
		while (t.elapsed() < 1.0)
			Thread.sleep(100);
		Thread.sleep(1000);
		assert((int)t.elapsed() == 2);
	}
}
