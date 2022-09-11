
// This program will uncover the defect in ArrayUtils.find(), since Java
// string pooling does not apply to Strings read via a Scanner object.

import java.util.Scanner;

public class IsAWeasley {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] weasleys = { "Bill", "Charlie", "Percy", "Fred", "George", "Ron", "Ginny" };

        while (sc.hasNext()) {
            String name = sc.next();
            if (ArrayUtils.find(weasleys, name) == -1)
                System.out.printf("%s is not a Weasley\n", name);
            else
                System.out.printf("%s is a Weasley\n", name);
        }
 
        sc.close();
    }
}
