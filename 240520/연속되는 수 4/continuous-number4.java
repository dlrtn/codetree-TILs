import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        int count = 1;
        int answer = 1;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (temp < a) {
                count++;
                answer = Math.max(answer, count);
            } else {
                answer = Math.max(answer, count);
                count = 1;
            }
            temp = a;
        }

        System.out.println(answer);
    }
}