import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] between = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            between[i] = Integer.parseInt(st.nextToken());
        }

        int[] places = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            places[i] = Integer.parseInt(st.nextToken());
        }

        int[] cumulativeSum = new int[n - 1];
        cumulativeSum[0] = between[0];
        for (int i = 1; i < n - 1; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + between[i];
        }

        int i = 0;
        int sum = 0;
        int now = places[0];
        int nowCumulativeSum = 0;
        while (i < cumulativeSum.length) {
            if (places[i] <= places[i + 1]) {
                i++;
            } else {
                sum += (cumulativeSum[i] - nowCumulativeSum) * now;
                nowCumulativeSum += cumulativeSum[i];
                i++;
                now = places[i];
            }
        }

        if (places[n - 1] > nowCumulativeSum) {
            sum += (cumulativeSum[n - 2] - nowCumulativeSum) * now;
        }

        System.out.println(sum);
    }
}
