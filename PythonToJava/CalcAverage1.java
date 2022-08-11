public class CalcAverage1 {

    public static void main(String[] args) {

        double[] values = { 2.7, 8.2, 4.1, 12.4, 6.2, 3.1, 9.4 };

        double sum = 0.0;
        for (int i = 0; i < values.length; i++)
            sum += values[i];
        double average = sum / values.length;

        // NOTE: print() does not move the output the next line,
        // and is therefore useful when you want to continue with
        // more output on the same line.
        System.out.print("Number of values: ");

        // NOTE: println() moves the cursor to the start of the
        // next line.
        System.out.println(values.length);

        System.out.print("Average value: ");
        System.out.println(average);
    }
}
