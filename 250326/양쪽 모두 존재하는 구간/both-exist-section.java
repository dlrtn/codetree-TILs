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
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        Map<Integer, Integer> originalMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            originalMap.put(arr[i], originalMap.getOrDefault(arr[i], 0) + 1);
        }

        for (Integer key : originalMap.keySet()) {
            if (originalMap.get(key) == 1) {
                System.out.println(-1);
                return;
            }
        }

        int answer = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && originalMap.get(arr[j]) != 1) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                if (originalMap.get(arr[j]) == 1) {
                    originalMap.remove(arr[j]);
                } else {
                    originalMap.put(arr[j], originalMap.getOrDefault(arr[j], 0) - 1);
                }
                j++;
            }

            if (originalMap.size() == map.size() && map.size() == m) {
                answer = Math.min(answer, j - i);
            }

            if (map.get(arr[i]) == 1) {
                map.remove(arr[i]);
            } else {
                map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
            }
            originalMap.put(arr[i], originalMap.getOrDefault(arr[i], 0) + 1);
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
