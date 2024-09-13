import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static boolean[] visited;

    public static int[][] arr;

    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(n, 0);

        System.out.println(max);
    }

    public static void backtracking(int n, int depth) {
        if (depth == n) {
            int sum = arrayList.stream().mapToInt(Integer::intValue).sum();

            max = Math.max(max, sum);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            arrayList.add(arr[depth][i]);

            backtracking(n, depth + 1);

            arrayList.remove(arrayList.size() - 1);
            visited[i] = false;
        }
    }
}