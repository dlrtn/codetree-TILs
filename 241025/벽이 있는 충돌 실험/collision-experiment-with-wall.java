import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

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

            for (int f = 0; f < n * 2 + 2; f++) {
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
                                    temp[j][k] = -1;
                                } else {
                                    temp[j][k] = direction;
                                }

                                continue;
                            }

                            if (temp[x][y] != -1) {
                                temp[x][y] = -1;
                            } else {
                                temp[x][y] = direction;
                            }
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
}