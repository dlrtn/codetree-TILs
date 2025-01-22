import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            Integer count = Integer.parseInt(st.nextToken());

            switch (word) {
                case "add":
                    set.add(count);
                    break;
                case "remove":
                    set.remove(count);
                    break;
                case "find":
                    System.out.println(set.contains(count) ? "true" : "false");
                    break;
            }
        }
    }
}
