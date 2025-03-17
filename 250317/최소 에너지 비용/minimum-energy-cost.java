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

        int i = 0;
        long sum = 0;
        int now = places[0];
        long energySum = 0;

        while (i < between.length) {
            energySum += between[i];
            if (now <= places[i + 1]) {
                i++;
            } else {
                sum += energySum * now;
                energySum = 0;

                i++;
                now = places[i];
            }
        }

        if (energySum != 0) {
            sum += energySum * now;
        }

        System.out.println(sum);
    }
}
