import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] numbers = new boolean[n];
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());

            int broken = Integer.parseInt(st.nextToken());

            numbers[broken - 1] = true;
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                if (numbers[i]) {
                    count++;
                }
            } else {
                if (numbers[i]) {
                    count++;
                }

                if (numbers[i - k]) {
                    count--;
                }
                
                min = Math.min(min, count);
            }            
        }

        System.out.println(min);
    }
}