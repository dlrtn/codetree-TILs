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

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        backtracking(k, n, 0);
    }

    public static void backtracking(int k, int n, int depth) {
        if (depth == n) {
            arrayList.forEach((item) -> {
                System.out.print(item + " ");
            });
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (arrayList.size() >= 2 && arrayList.get(arrayList.size() - 1) == i && arrayList.get(arrayList.size() - 2) == i) {
                continue;
            }

            arrayList.add(i);
            backtracking(k, n, depth + 1);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}