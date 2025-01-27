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

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int minDistance = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);

            Integer lower = set.lower(num);
            Integer higher = set.higher(num);

            if (lower != null) {
                minDistance = Math.min(minDistance, num - lower);
            }

            if (higher != null) {
                minDistance = Math.min(minDistance, higher - num);
            }

            System.out.println(minDistance);
        }

    }
}
