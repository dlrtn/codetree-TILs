import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {

    public static int count = 0;

    public static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        backtracking(n, 4, 0);

        System.out.println(count);
    }

    public static void backtracking(int n, int k, int depth) {
        if (depth == n) {
            boolean isBeautifulNumber = false;

            if (getResult() || getaVoid()) {
                isBeautifulNumber = true;
            }

            if (isBeautifulNumber) {
                count++;
            }

            return;
        }

        for (int i = 1; i <= k; i++) {
            queue.add(i);
            backtracking(n, k, depth + 1);
            queue.pollLast();
        }
    }

    private static boolean getResult() {
        int number = 0;
        int cnt = 0;
        Integer[] numbers = queue.stream().mapToInt(Integer::intValue).boxed()
                .toArray(Integer[]::new);

        for (int i = 0; i < queue.size(); i++) {
            int nowNumber = numbers[i];

            if (nowNumber != number) {
                if (cnt != number) {
                    return false;
                }
                number = nowNumber;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        if (cnt != number) {
            return false;
        }

        return true;
    }

    private static boolean getaVoid() {
        int number = 0;
        int cnt = 0;
        Integer[] numbers = queue.stream().mapToInt(Integer::intValue).boxed()
                .toArray(Integer[]::new);

        for (int i = 0; i < queue.size(); i++) {
            int nowNumber = numbers[i];

            if (nowNumber != number) {
                if (number != 0 && cnt % number != 0) {
                    return false;
                }
                number = nowNumber;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        if (number != 0 && cnt % number != 0) {
            return false;
        }

        return true;
    }
}