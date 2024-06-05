import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] b = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = a[i] - b[i];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            while (diff[i] != 0) {
                for (int j = i + 1; j < n; j++) {
                    if (diff[i] < 0 && diff[j] > 0) {
                        diff[i]++;
                        diff[j]--;
                        sum += Math.abs(i - j);
                    } else if(diff[i] > 0 && diff[j] < 0) {
                        diff[i]--;
                        diff[j]++;
                        sum += Math.abs(i - j);
                    }
                }
            }
        }

        System.out.println(sum);

    }
}