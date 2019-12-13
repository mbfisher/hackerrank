import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        List<List<Long>> candidates;
        List<List<Long>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            long root = arr.get(i);
            candidates = new ArrayList<>();

            for (int j = i + 1; j < arr.size(); j++) {
                long value = arr.get(j);

                candidates.forEach(candidate -> {
                    long current = candidate.get(1);
                    if (value / r == current) {
                        List<Long> triplet = new ArrayList<>(candidate);
                        triplet.add(value);
                        triplets.add(triplet);
                    }
                });

                if (value / r == root) {
                    List<Long> candidate = new ArrayList<>();
                    candidate.add(root);
                    candidate.add(value);
                    candidates.add(candidate);
                }
            }

            // List<Long> sig = new ArrayList<>();
            // for (int j = 0; j < arr.size(); j++) {
            // sig.set(j, j < i ? arr.get(i) : arr.get(i) / r);
            // }
        }

        return triplets.size();
    }

    public static void main(String[] args) throws IOException {
        // countTriplets(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3);
        BufferedReader bufferedReader = new BufferedReader(new
        InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new
        FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$",
        "").split(" ")).map(Long::parseLong)
        .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
