import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        int[][] map = new int[n][n];

        Dice dice = new Dice();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            String direction = st.nextToken();
            map[r][c] = dice.getDown();

            switch (direction) {
                case "L":
                    if (c + dc[0] >= 0) {
                        dice.rollLeft();
                        c += dc[0];
                    }
                    break;
                case "R":
                    if (c + dc[1] < n) {
                        dice.rollRight();
                        c += dc[1];
                    }
                    break;
                case "U":
                    if (r + dr[2] >= 0) {
                        dice.rollUp();
                        r += dr[2];
                    }
                    break;
                case "D":
                    if (r + dr[3] < n) {
                        dice.rollDown();
                        r += dr[3];
                    }
                    break;
                default:
                    break;
            }
            map[r][c] = dice.getDown();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    public static class Dice {

        private int up = 1;
        private int front = 2;
        private int right = 3;
        private int left = 4;
        private int back = 5;
        private int down = 6;

        public void rollLeft() {
            int temp = left;
            left = up;
            up = right;
            right = down;
            down = temp;
        }

        public void rollRight() {
            int temp = right;
            right = up;
            up = left;
            left = down;
            down = temp;
        }

        public void rollUp() {
            int temp = up;
            up = front;
            front = down;
            down = back;
            back = temp;
        }

        public void rollDown() {
            int temp = down;
            down = front;
            front = up;
            up = back;
            back = temp;
        }

        public int getDown() {
            return down;
        }

    }
}