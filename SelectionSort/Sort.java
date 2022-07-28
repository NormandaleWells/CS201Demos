public class Sort {
    
    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            int idx = ArrayUtils.minElement(a, i, a.length);
            ArrayUtils.swap(a, i, idx);
        }
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
