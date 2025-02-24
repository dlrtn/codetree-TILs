import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> map = new TreeMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(st.nextToken()), i + 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>(map.keySet());
        int count = 1;
        for (Integer integer: map.keySet()) {
            map2.put(integer, count++);
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (set.first() <= start) {
                start = set.ceiling(start) != null ? map2.get(set.ceiling(start)) - 1 : n;
            } else {
                start = 0;
            }

            if (set.last() >= end) {
                end = set.floor(end) != null ? map2.get(set.floor(end)) : 0;
            } else {
                end = n;
            }

            if (end < set.first() || set.last() < start) {
                System.out.println(0);
                continue;
            }

            System.out.println(end - start);
        }

    }
}
