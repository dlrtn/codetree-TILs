import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] Ta = new int[n];
        int[] Tb = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            Ta[i] = Integer.parseInt(st.nextToken());
            Tb[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i <= 1000; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (Ta[j] > i) {
                    temp += c;
                } else if (Ta[j] <= i && i <= Tb[j]) {
                    temp += g;
                } else {
                    temp += h;
                }
            }

            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}