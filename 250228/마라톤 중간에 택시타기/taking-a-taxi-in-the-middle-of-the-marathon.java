import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(x, y);
        }

        int[] lDist = new int[n];
        int[] rDist = new int[n];

        for (int i = 1; i < n; i++) {
            lDist[i] = lDist[i - 1] + Math.abs(arr[i].x - arr[i - 1].x) + Math.abs(arr[i].y - arr[i - 1].y);
        }

        for (int i = n - 2; i >= 0; i--) {
            rDist[i] = rDist[i + 1] + Math.abs(arr[i].x - arr[i + 1].x) + Math.abs(arr[i].y - arr[i + 1].y);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            int sum = lDist[i - 1] + rDist[i + 1] + Math.abs(arr[i - 1].x - arr[i + 1].x) + Math.abs(arr[i - 1].y - arr[i + 1].y);

            min = Math.min(min, sum);
        }

        System.out.println(min);

    }

    public static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
