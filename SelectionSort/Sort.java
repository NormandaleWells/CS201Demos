public class Sort {

    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            // Loop invariants (len is a.length):
            // a[0,i) is sorted (a[i-1] >= a[i-2] >= ... >= a[0])
            // i == 0 or a[i-1] <= a[i,len)
            int idx = ArrayUtils.minElement(a, i, a.length);
            // a[idx] >= a[i-1]
            // a[idx] <= a[i,idx) and a[idx] <= a[idx+1,len)
            ArrayUtils.swap(a, i, idx);
            // a[i] >= a[i-1] ( >= a[i-2] >= ... >= a[0])
            //      i.e. a[0,i] is sorted (closed range!)
            // a[i] <= a[i+1,len)
        }
        // We dropped out of the loop when i == len, so
        // a[0,len) is sorted
    }

    public static <T> void showArray(T[] a) {
        System.out.printf("[ %s", a[0]);
        for (int i = 1; i < a.length; i++)
            System.out.printf(", %s", a[i]);
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        Integer[] a = { 27, 82, 41, 124, 62, 31, 94, 47, 142, 71, 214 };
        selectionSort(a);
        showArray(a);
    }
}
