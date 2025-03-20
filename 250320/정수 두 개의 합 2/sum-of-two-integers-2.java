import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Comparator.comparingInt(Integer::intValue));

        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            int sum = list.get(i);
            int j = i + 1;

            while (sum + list.get(j) <= k) {
                count++;
                j++;
            }
        }

        System.out.println(count);
    }
}
