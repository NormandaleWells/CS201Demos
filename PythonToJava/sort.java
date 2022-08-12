public class sort {
    
    // swap two elements of the given array
    public static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // return the index of the minimum element in the
    // [lo,hi) subrange of array a.
    public static int minElement(int[] a, int lo, int hi) {
        int minIdx = lo;
        for (int i = lo+1; i < hi; i++)
            if (a[i] < a[minIdx])
                minIdx = i;
        return minIdx;
    }

    // sort the given array using the selection sort algorithm
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int idx = minElement(a, i, a.length);
            swap(a, i, idx);
        }
    }

    // sort the given list using the insertion sort algorithm
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && a[j] < a[j-1]) {
                swap(a, j, j-1);
                j -= 1;
            }
        }
    }

    // create a copy of an array
    public static int[] copyArray(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++)
            b[i] = a[i];
        return b;
    }

    // print the contents of an array
    public static void printArray(int[] a) {
        System.out.printf("[ %d", a[0]);
        for (int i = 1; i < a.length; i++)
            System.out.printf(", %d", a[i]);
        System.out.println(" ]");
    }

    // test the selection_sort and insertion_sort functions
    public static void main(String[] args) {
        int[] a = { 27, 82, 41, 124, 62, 31, 94 };

        int[] b = copyArray(a);
        selectionSort(b);
        printArray(b);

        b = copyArray(a);
        insertionSort(b);
        printArray(b);

        // String[] weasleys = { "Bill", "Charlie", "Percy", "George", "Fred", "Ron", "Ginny" };
        // insertionSort(weasleys);
        // printArray(weasleys);
    }
}
