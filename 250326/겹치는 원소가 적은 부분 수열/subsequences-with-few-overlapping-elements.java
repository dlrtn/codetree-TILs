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

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && (!map.containsKey(arr[j]) || map.get(arr[j]) < k)) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                j++;
            }

            answer = Math.max(answer, j - i);

            map.put(arr[i], map.get(arr[i]) - 1);
        }

        System.out.println(answer);
    }
}
