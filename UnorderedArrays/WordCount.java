import java.util.Scanner;

public class WordCount {
    
    public static void main(String[] args) {

        final int maxWords = 10;

        String[] words = new String[maxWords];
        int[] counts = new int[maxWords];
        int numWords = 0;

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String word = sc.next();
            if (!StringIntMap.contains(words, counts, numWords, word)) {
                numWords = StringIntMap.put(words, counts, numWords, word, 1);
            } else {
                int curCount = StringIntMap.get(words, counts, numWords, word);
                numWords = StringIntMap.put(words, counts, numWords, word, curCount+1);
            }
        }

        sc.close();

        int idx = IntArrayUtils.maxElement(counts, 0, numWords);
        int maxCount = counts[idx];
        int numMaxCountWords = IntArrayUtils.count(counts, 0, numWords, maxCount);
        System.out.printf("The maximum count for any word is %d.\n", maxCount);
        System.out.printf("There are %d words that appear %d times.\n",
                numMaxCountWords, maxCount);
        System.out.printf("\"%s\" is one such word.\n", words[idx]);
    }
}
