import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int direction = 0;

    static int x;
    static int y;
    static int n;
    static int movingDistance = 0;

    static String[][] arr;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] wallDx = {0, 1, 0, -1};
    static int[] wallDy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken()) - 1;
        x = Integer.parseInt(st.nextToken()) - 1;

        arr = new String[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String string = st.nextToken();
            for (int j = 0; j < n; j++) {
                arr[i][j] = string.split("")[j];
            }
        }

        while (!isExit() && wallExists() && movingDistance < 10000) {
            if (movable()) {
                move();

                if (!isExit() && !wallExists()) {
                    turnClockwise();
                    move();
                } else if (isExit()) {
                    break;
                }
            } else {
                turnCounterClockwise();
            }
        }

        if (isExit()) {
            System.out.println(movingDistance);
        } else {
            System.out.println(-1);
        }

    }

    public static void turnCounterClockwise() {
        direction += 1;
        direction %= 4;
    }

    public static void turnClockwise() {
        direction -= 1;
        if (direction < 0) {
            direction = 3;
        }
    }

    public static boolean wallExists() {
        return arr[y + wallDy[direction]][x + wallDx[direction]].equals("#");
    }

    public static boolean movable() {
        return y + dy[direction] < 0 || y + dy[direction] >= arr.length || x + dx[direction] < 0
                || x + dx[direction] >= arr.length || arr[y + dy[direction]][x
                + dx[direction]].equals(".");
    }

    public static boolean isExit() {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    public static void move() {
        x += dx[direction];
        y += dy[direction];

        movingDistance++;
    }
}