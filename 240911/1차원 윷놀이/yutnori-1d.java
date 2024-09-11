import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static int maxNumber = Integer.MIN_VALUE;

    public static int[] distances;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        distances = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(k, n, 0, m);

        System.out.println(maxNumber);
    }

    public static void backtracking(int k, int n, int depth, int m) {
        if (depth == n) {
            int[] arr = new int[k];

            for (int i = 0; i < n; i++) {
                arr[arrayList.get(i) - 1] += distances[i];
            }

            int count = 0;
            for (int i = 0; i < k; i++) {
                if (arr[i] >= m - 1) {
                    count++;
                }
            }

            maxNumber = Math.max(count, maxNumber);

            return;
        }

        for (int i = 1; i <= k; i++) {
            arrayList.add(i);
            backtracking(k, n, depth + 1, m);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}