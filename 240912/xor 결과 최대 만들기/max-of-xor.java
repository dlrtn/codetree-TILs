import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static int[] arr;

    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(m, n, 0, 0);

        System.out.println(answer);
    }

    public static void backtracking(int m, int n, int depth, int start) {
        if (depth == m) {
            int num = 0;
            for (int i = 0; i < m; i++) {
                num ^= arrayList.get(i);
            }

            answer = Math.max(answer, num);
            return;
        }

        for (int i = start; i < n; i++) {
            arrayList.add(arr[i]);
            backtracking(m, n, depth + 1, i);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}