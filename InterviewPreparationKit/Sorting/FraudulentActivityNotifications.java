import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static int evenMedian(int[] values) {
        int a = (int) Math.floor(values.length / 2);
        int b = (int) Math.ceil(values.length / 2);
        return (values[a] + values[b]) / 2;
    }

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int notifications = 0;
        int[] previousDays = new int[d];
        float median;
        boolean isEven = d % 2 == 0;

        for (int i = d; i < expenditure.length; i++) {
            previousDays = Arrays.copyOfRange(expenditure, i-d, i);
            Arrays.sort(previousDays);

            median = isEven ? evenMedian(expenditure) : previousDays[d / 2];

            if (expenditure[i] >= 2 * median) {
                notifications++;
            }
        }

        return notifications;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
