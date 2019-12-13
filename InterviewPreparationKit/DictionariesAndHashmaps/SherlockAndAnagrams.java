import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndAnagrams {

    static String chars(String s, int start, int end) {
        char[] chars = s.substring(start, end).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String str) {
        System.out.println(str);
        int n = str.length();
        int result = 0;

        for (int r = 1; r < n; r++) {
            for (int s = 0; s <= n - r; s++) {

                String substr = chars(str, s, s + r);
                for (int i = s + 1; i + r <= n; i++) {
                    String pair = chars(str, i, i + r);
                    if (substr.equals(pair)) {
                        // System.out.printf("%s [%d,%d] [%d,%d]\n", substr, s, s+r, i, i+r);
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // sherlockAndAnagrams("ifailuhkqq");
        // sherlockAndAnagrams("kkkk");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
