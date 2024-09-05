import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static int n, m, k;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            while (boomCheck()) {
                boom();
                gravity();
            }
            rotate();
            gravity();
        }
        while (boomCheck()) {
            boom();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void boom() {
        for (int i = 0; i < n; i++) {
            int nowNumber = 0;
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (nowNumber != map[j][i]) {
                    if (nowNumber != 0 && count >= m) {
                        for (int l = j + count; l > j; l--) {
                            map[l][i] = 0;
                        }
                    }
                    nowNumber = map[j][i];
                    count = 1;
                } else {
                    count++;
                }
            }
            if (nowNumber != 0 && count >= m) {
                for (int l = count - 1; l >= 0; l--) {
                    map[l][i] = 0;
                }
            }
        }
    }

    private static boolean boomCheck() {
        for (int i = 0; i < n; i++) {
            int nowNumber = 0;
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (nowNumber != map[j][i]) {
                    if (nowNumber != 0 && count >= m) {
                        return true;
                    }
                    nowNumber = map[j][i];
                    count = 1;
                } else {
                    count++;
                }
            }
            if (nowNumber != 0 && count >= m) {
                return true;
            }
        }
        return false;
    }

    private static void gravity() {
        // 중력 작용
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = n - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    queue.add(map[j][i]);
                }
            }

            while (queue.size() != n) {
                queue.add(0);
            }

            for (int j = n - 1; j >= 0; j--) {
                temp[j][i] = queue.poll();
            }
        }

        map = temp;
    }

    private static void rotate() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                temp[i][j] = map[n - j - 1][i];
            }
        }

        map = temp;
    }
}