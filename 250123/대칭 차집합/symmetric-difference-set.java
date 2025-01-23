import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.valueOf(Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set2.add(Integer.valueOf(Integer.parseInt(st.nextToken())));
        }

        int sum = set.size() + set2.size();

        HashSet<Integer> intersection = new HashSet<>(set);
        intersection.retainAll(set2);

        System.out.println(sum - intersection.size() * 2);
    }
}
