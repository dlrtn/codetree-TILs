import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static final String[] directions = {"R", "D", "L", "U"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) // i == 0일 때의 direction은 D로 고정
                    max = Math.max(max, insert(map, i, j, directions[1]));
                if (i == n - 1)  // i == n - 1일 때의 direction은 U
                    max = Math.max(max, insert(map, i, j, directions[3]));
                if (j == 0) // j == 0일 때의 direction은 R
                    max = Math.max(max, insert(map, i, j, directions[0]));
                if (j == n - 1)  // j == n - 1일 때의 direction은 L
                    max = Math.max(max, insert(map, i, j, directions[2]));
            }
        }

        System.out.println(max);
    }

    private static int insert(int[][] map, int x, int y, String direction) {
        int num = 1;

        int nowX = x;
        int nowY = y;

        int n = map.length;

        while (true) {
            if (nowY >= n || nowX >= n || nowX < 0 || nowY < 0) {
                break;
            }

            // map[nowX][nowY]의 값(0, 1, 2)에 따라 처리가 달라진다.

            // 1, 2인 경우 방향 전환시켜준다.
            if (map[nowX][nowY] == State.BACKSLASH.value) { // \인 경우, R -> D, D -> R, L -> U, U -> L
                if (direction.equals(directions[0])) {
                    direction = directions[3];
                } else if (direction.equals(directions[1])) {
                    direction = directions[2];
                } else if (direction.equals(directions[2])) {
                    direction = directions[1];
                } else if (direction.equals(directions[3])) {
                    direction = directions[0];
                }
            } else if (map[nowX][nowY] == State.SLASH.value) { // /인 경우, R -> U, D -> L, L -> D, U -> R
                if (direction.equals(directions[0])) {
                    direction = directions[1];
                } else if (direction.equals(directions[1])) {
                    direction = directions[0];
                } else if (direction.equals(directions[2])) {
                    direction = directions[3];
                } else if (direction.equals(directions[3])) {
                    direction = directions[2];
                }
            }

            // 이동시킨다.
            int directionIndex = Direciton.valueOf(direction).value;
            nowX += dx[directionIndex];
            nowY += dy[directionIndex];

            num++;
        }

        return num;
    }

    private enum State {
        EMPTY(0), BACKSLASH(1), SLASH(2);

        private final int value;

        State(int value) {
            this.value = value;
        }
    }

    private enum Direciton {
        R(0), D(1), L(2), U(3);

        private final int value;

        Direciton(int value) {
            this.value = value;
        }
    }
}