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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);

            int minDistance = Integer.MAX_VALUE;
            for (int s : set) {
                if (set.higher(s) != null) {
                    minDistance = Math.min(minDistance, set.higher(s) - s);
                }
            }
            System.out.println(minDistance);
        }

    }
}
