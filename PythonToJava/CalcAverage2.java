public class CalcAverage2 {

    public static void main(String[] args) {

        double[] values = { 2.7, 8.2, 4.1, 12.4, 6.2, 3.1, 9.4 };

        double sum = 0.0;
        for (int i = 0; i < values.length; i++)
            sum += values[i];
        double average = sum / values.length;

        // NOTE: We can use the + operator to concatenate strings.
        // Java will automatically convert a non-string (e.g.
        // an int or double) to a string before concatenating.
        System.out.println("Number of values: " + values.length);
        System.out.println("Average value: " + average);
    }
}
