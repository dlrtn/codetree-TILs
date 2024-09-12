import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        backtracking(m, n, 0);
    }

    public static void backtracking(int m, int n, int depth) {
        if (depth == m) {
            arrayList.forEach((item) -> {
                System.out.print(item + " ");
            });
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (arrayList.isEmpty() || arrayList.get(arrayList.size() - 1) < i) {
                arrayList.add(i);
                backtracking(m, n, depth + 1);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }
}