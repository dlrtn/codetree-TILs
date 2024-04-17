import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(st.nextToken());

            q.add(m);
            q.add(m + 1);
        }

        int count = 0;
        int start = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now > start + l) {
                count++;
                start = now;
            }
        }

        System.out.println(count);

    }
}