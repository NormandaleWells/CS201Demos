public class ShowArgs
{
    public static void main(String[] args)
    {
        System.out.print("Args: ");
        for (String s : args)
            System.out.printf("'%s' ", s);
        System.out.println();
    }
}
