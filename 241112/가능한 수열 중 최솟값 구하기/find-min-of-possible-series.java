import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int n;

    static LinkedList<Integer> list = new LinkedList<>();

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        backtracking(0);

        System.out.println(answer);
    }

    public static void backtracking(int depth) {
        if (depth == n) {
            Long num = 0L;

            for (int i = 0; i < n; i++) {
                num = num * 10 + list.get(i);
            }

            if (isValid()) {
                System.out.println(num);
                exit(0);
            } else {
                return;
            }
        }

        for (int i = 4; i <= 6; i++) {
            list.add(i);
            backtracking(depth + 1);
            list.removeLast();
        }
    }

    public static boolean isValid() {
        int half = n / 2;

        for (int i = 1; i <= half; i++) { // i 개의 연속한 숫자들이
            for (int j = 0; j < n - (i * 2); j++) { // 0부터 n - i까지 시작점
                int count = 0;

                for (int k = 0; k < i; k++) { // i 개의 값이 중복되는지 검사
                    if (Objects.equals(list.get(j + k), list.get(j + i + k))) {
                        count++;
                    }
                }

                if (count == i) {
                    return false;
                }
            }
        }

        return true;
    }
}
