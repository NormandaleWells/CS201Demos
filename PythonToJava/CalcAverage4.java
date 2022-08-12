public class CalcAverage4 {

    public static void main(String[] args) {

        double[] values = { 2.7, 8.2, 4.1, 12.4, 6.2, 3.1, 9.4 };

        double sum = 0.0;
        for (int i = 0; i < values.length; i++)
            sum += values[i];
        double average = sum / values.length;

        // NOTE: We can control the formatting in various ways.  "%3d"
        // indicates that the corresponding integer should be printed
        // with a field width of 3, and "%.2f" indicates that the
        // corresponding double should be printed with 2 digits to the
        // right of the decimal point.
        System.out.printf("Number of values: %03d\n", values.length);
        System.out.printf("Average value: %8.2f", average);
    }
}
