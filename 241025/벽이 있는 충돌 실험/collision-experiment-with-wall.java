import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    map[j][k] = -1;
                }
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                String d = st.nextToken();

                map[x - 1][y - 1] = Direction.valueOf(d).getValue();
            }

            for (int f = 0; f < n * 2; f++) {
                int[][] temp = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        temp[j][k] = -1;
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (map[j][k] != -1) {
                            int direction = map[j][k];

                            int x = j + dx[direction];
                            int y = k + dy[direction];

                            if (x < 0 || x >= n || y < 0 || y >= n) {
                                direction = (direction + 2) % 4;

                                if (temp[j][k] != -1) {
                                    temp[j][k] = -2;
                                } else {
                                    temp[j][k] = direction;
                                }
                            } else {
                                if (temp[x][y] != -1) {
                                    temp[x][y] = -2;
                                } else {
                                    temp[x][y] = direction;
                                }
                            }
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (temp[j][k] == -2) {
                            temp[j][k] = -1;
                        }
                    }
                }

                map = temp;
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] != -1) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private enum Direction {
        R(0), D(1), L(2), U(3);

        private final int value;

        Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}