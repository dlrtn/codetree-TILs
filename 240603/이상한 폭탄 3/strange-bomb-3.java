import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j] && j - i <= k) {
                    if (!map.containsKey(arr[i])) {
                        map.put(arr[i], 1);
                    } else {
                        map.put(arr[i], map.get(arr[i]) + 1);
                    }
                }
            }
        }

        int answer = 0;
        for (int i : map.keySet()) {
            if (answer <= map.get(i)) {
                answer = Math.max(answer, i);
            }
        }

        System.out.println(answer);
    }
}