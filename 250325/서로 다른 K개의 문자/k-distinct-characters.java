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

        String s = st.nextToken();
        int k = Integer.parseInt(st.nextToken());

        int j = 0;

        int answer = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && map.size() <= k) {
                if (!map.containsKey(s.charAt(j)) && map.size() == k) {
                    break;
                }

                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                } else {
                    map.put(s.charAt(j), 1);
                }
                j++;
            }

            answer = Math.max(answer, j - i);

            if (map.get(s.charAt(i)) == 1) {
                map.remove(s.charAt(i));
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            }
        }

        System.out.println(answer);
    }
}
