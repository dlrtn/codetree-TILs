import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        backtracking(n, 0);
    }

    public static void backtracking(int n, int depth) {
        if (depth == n) {
            for (Integer item : arrayList) {
                System.out.print(item + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            arrayList.add(i);

            backtracking(n, depth + 1);

            arrayList.remove(arrayList.size() - 1);
            visited[i] = false;
        }
    }
}