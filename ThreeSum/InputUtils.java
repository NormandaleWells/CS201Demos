import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class InputUtils {

	public static int[] readIntFile(String filename) {
		try {
			FileInputStream inFile = new FileInputStream(filename);
			Scanner scnr = new Scanner(inFile);
			ArrayList<Integer> al = new ArrayList<Integer>();
			while (scnr.hasNextInt()) {
				al.add(scnr.nextInt());
			}
			int[] a = new int[al.size()];
			for (int i = 0; i < al.size(); i++) {
				a[i] = al.get(i);
			}
			scnr.close();
			return a;
		}
		catch (Exception e) {
			String msg = String.format("Could not open %s : %s",
					filename, e.getMessage());
			throw new RuntimeException(msg);
		}
	}

	public static void main(String[] args) {
		int[] a = readIntFile("1Kints.nodup.txt");
		System.out.println(a.length);
	}
}
