import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] r = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            if (map.containsKey(numbers[i])) {
                r[i] = map.get(numbers[i]) - i;
                map.put(numbers[i], i);
            } else {
                r[i] = -1;
                map.put(numbers[i], i);
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if (r[i] >= k) {
                max = Math.max(max, numbers[i]);
            }
        }

        System.out.println(max);
    }
}
