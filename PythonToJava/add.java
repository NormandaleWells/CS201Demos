public class Add {

    public static int add2(int a, int b) {
        return a + b;
    }
 
    public static String add2(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(add2(14, 28));
        System.out.println(add2("forty ", "two"));
    }
}
