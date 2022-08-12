public class CalcAverage3 {

    public static void main(String[] args) {

        double[] values = { 2.7, 8.2, 4.1, 12.4, 6.2, 3.1, 9.4 };

        double sum = 0.0;
        for (int i = 0; i < values.length; i++)
            sum += values[i];
        double average = sum / values.length;

        // NOTE: We can use the printf() function to write formatted
        // output.  %d formats an integer, and %f formats a double.
        // By default, %f prints 6 digits.
        System.out.printf("Number of values: %d\n", values.length);
        System.out.printf("Average value: %f", average);
    }
}
