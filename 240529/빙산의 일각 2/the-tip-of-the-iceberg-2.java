import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] heights = new int[n];
        int maxHeight = 0;
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            heights[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, heights[i]);
            minHeight = Math.min(minHeight, heights[i]);
        }
        int answer = 0;
        for (int i = minHeight; i <= maxHeight; i++) {
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = heights[j] - i;
            }

            answer = Math.max(answer, getIcebergCount(arr));
        }

        System.out.println(answer);
    }

    public static int getIcebergCount(int[] arr) {
        int count = 0;

        boolean isIceberg = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && !isIceberg) {
                isIceberg = true;
                count++;
            } else if (arr[i] == 0 && isIceberg) {
                isIceberg = false;
            }
        }

        return count;
    }
}