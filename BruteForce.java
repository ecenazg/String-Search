import java.util.ArrayList;
import java.util.List;

public class BruteForce {

    public static void main(String args[]) {
        System.out.println("========String matcher Brute Force Approach===========");
        String text = "abcabbabbaabac";
        String pattern = "abba";
        long initialTime = System.nanoTime();
        List<Integer> matchedIndexes = bruteForceStringMatcher(text, pattern);
        long finalTime = System.nanoTime();
        for (Integer matchedIndex : matchedIndexes) {
            System.out.println("Pattern found at " + matchedIndex);
        }

        if (matchedIndexes.size() == 0)
            System.out.println("Pattern not found");

        System.out.println("Time taken for matching " + (finalTime - initialTime));
    }

    public static List<Integer> bruteForceStringMatcher(String text, String pattern) {

        char[] textArray = text.toCharArray();
        char[] patternArray = pattern.toCharArray();

        int textLength = textArray.length;
        int patternLength = patternArray.length;

        List<Integer> matchedIndexes = new ArrayList<>();

        int textIndex = 0;

        for (textIndex = 0; textIndex < textLength; textIndex++) {
            int textIndexLocal = textIndex;
            Boolean match = true;
            int matchedIndex = textIndex;
            for (int patternIndex = 0; patternIndex < patternLength; patternIndex++) {
                if (textArray[textIndexLocal] != patternArray[patternIndex]) {
                    match = false;
                    break;
                }
                textIndexLocal ++;
            }
            if (match)
                matchedIndexes.add(matchedIndex);
        }
        return matchedIndexes;
    }

    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            if (j == M)
                return i;
        }
        return N;
    }

}