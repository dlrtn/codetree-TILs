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

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            while (j < n && !map.containsKey(arr[j])) {
                map.put(arr[j], j);
                j++;
            }

            ans = Math.max(ans, j - i);

            map.remove(arr[i]);
        }

        System.out.println(ans);




    }
}
