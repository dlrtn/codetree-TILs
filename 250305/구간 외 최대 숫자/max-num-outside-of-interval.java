import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        leftMax[0] = arr[0];
        for (int i = 1; i < N; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMax[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken()) - 1;
            int bi = Integer.parseInt(st.nextToken()) - 1;

            int maxOutside = Integer.MIN_VALUE;
            if (ai > 0) maxOutside = Math.max(maxOutside, leftMax[ai - 1]);
            if (bi < N - 1) maxOutside = Math.max(maxOutside, rightMax[bi + 1]);

            System.out.println(maxOutside);
        }
    }
}
