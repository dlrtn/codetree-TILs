import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static final String[] direction = {"R", "D", "L", "U"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x - 1][y - 1] = 1;
        }

        Snake snake = new Snake();
        int time = 0;

        try {
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String direction = st.nextToken();
                int length = Integer.parseInt(st.nextToken());


                for (int j = 0; j < length; j++) {
                    int directionIndex = Direction.valueOf(direction).getValue();

                    // 격자를 벗어나는 경우 종료 : head가 격자를 벗어나는 경우 종료
                    if (snake.head.x + dx[directionIndex] < 0 || snake.head.x + dx[directionIndex] >= n
                            || snake.head.y + dy[directionIndex] < 0 || snake.head.y + dy[directionIndex] >= n) {
                        throw new Exception();
                    }
                    // 몸이 꼬이는 경우 종료 : head가 tail 중 하나를 만나는 경우 종료
                    for (int l = 0; l < snake.tails.size() - 1; l++) {

                        if (snake.head.x + dx[directionIndex] == snake.tails.get(l).x
                                && snake.head.y + dy[directionIndex] == snake.tails.get(l).y) {
                            throw new Exception();
                        }
                    }
                    // move 한다.
                    snake.move(direction);

                    if (graph[snake.head.x][snake.head.y] == 1) {
                        snake.eat(direction);
                        graph[snake.head.x][snake.head.y] = 0;
                    }

                    time++;
                }
            }
        } catch (Exception e) {
            time++;
        }

        System.out.println(time);
    }

    private enum Direction {
        D(1), R(0), U(3), L(2);

        private final int value;

        Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    static class Snake {
        Point head;
        List<Point> tails;

        public Snake() {
            this.head = new Point(0, 0);
            this.tails = new ArrayList<>();
        }

        public void move(String direction) {
            // 이동 방향으로 머리, 꼬리들의 좌표를 이동시킨다.
            int directionIndex = Direction.valueOf(direction).getValue();


            for (int i = tails.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    tails.get(i).x = head.x;
                    tails.get(i).y = head.y;
                } else {
                    tails.get(i).x = tails.get(i - 1).x;
                    tails.get(i).y = tails.get(i - 1).y;
                }
            }

            head.x += dx[directionIndex];
            head.y += dy[directionIndex];
        }

        public void eat(String direction) {
            int directionIndex = (Direction.valueOf(direction).getValue() + 2) % 4;

            Point tail = new Point(head.x + dx[directionIndex], head.y + dy[directionIndex]);

            tails.add(tail);
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}