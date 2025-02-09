import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            set.add(Integer.parseInt(st.nextToken()));
        }

        int answer = -1;
        int minDiff = Integer.MAX_VALUE;

        for (Integer num: set) {
            if (set.ceiling(num + m) != null) {
                int higher = set.ceiling(num + m);
                if (higher - num < minDiff) {
                    answer = higher - num;
                    minDiff = higher - num;
                }
            }
        }

        System.out.println(answer);

    }
}
