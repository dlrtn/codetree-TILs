import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[100000001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a] += 1;
            arr[b] -= 1;
        }

        int answer = 0;
        int now = 0;
        for (int i = 0; i < 100000001; i++) {
            now += arr[i];

            if (arr[i] == - 1 && now == 0) {
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}
