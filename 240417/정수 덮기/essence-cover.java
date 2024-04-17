import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr = Arrays.stream(arr).sorted().toArray();

        for (int i = 0; i < n; i++) {
            q.add(arr[i]);
            q.add(arr[i] + 1);
        }

        int count = 0;
        int start = q.poll();
        int now = 0;
        while (!q.isEmpty()) {
            while (!q.isEmpty() && now < start + l) {
                now = q.poll();
            }
            count++;
            start = now;
        }

        System.out.println(count);
    }
}