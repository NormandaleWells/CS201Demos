public class ArrayUtils {

    public static <T extends Comparable<T>> int minElement(T[] a, int lo, int hi) {
        int minIdx = lo;
        for (int i = lo+1; i < hi; i++)
            if (a[i].compareTo(a[minIdx]) < 0)
                minIdx = i;
        return  minIdx;
    }

    public static <T> void swap(T[] a, int idx1, int idx2) {
        T t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
}
