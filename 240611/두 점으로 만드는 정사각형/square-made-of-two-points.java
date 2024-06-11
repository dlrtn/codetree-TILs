import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr1 = new int[4];
        int[] arr2 = new int[4];
        for (int i = 0; i < 4; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int minX1 = Math.min(arr1[0], arr2[0]);
        int minY1 = Math.min(arr1[1], arr2[1]);
        int maxX1 = Math.max(arr1[2], arr2[2]);
        int maxY1 = Math.max(arr1[3], arr2[3]);

        int maxSide = Math.max(maxX1 - minX1, maxY1 - minY1);

        System.out.println(maxSide * maxSide);
    }
}