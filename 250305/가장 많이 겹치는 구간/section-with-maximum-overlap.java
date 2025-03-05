import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[200001];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start]++;
            arr[end]--;
        }

        int max = 0;
        int sum = 0;
        for (int i = 0; i < 200001; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
        }

        bw.write(max + "\n");
        bw.flush();
    }
}
