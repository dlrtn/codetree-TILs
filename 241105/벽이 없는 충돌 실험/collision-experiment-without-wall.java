import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class Main {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int n;
    private static int answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        answer = -1;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            LinkedList<Ball> balls = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                String direction = st.nextToken();

                balls.add(new Ball(x, y, direction, j + 1, weight));
            }

            answer = -1;
            int time = 0;
            while (true) {
                if (balls.isEmpty()) {
                    break;
                }
                time += 1;

                balls.forEach(Ball::move);

                HashMap<Point, Integer> map = new HashMap<>();
                balls.forEach((Ball ball) -> {
                    for (int i1 = 0; i1 < balls.size(); i1++) {
                        Ball ball1 = balls.get(i1);
                        if (ball.position.x == ball1.position.x && ball.position.y == ball1.position.y) {
                            map.put(ball.position, map.getOrDefault(ball.position, 0) + 1);
                        }
                    }
                });

                for (Entry<Point, Integer> entry : map.entrySet()) {
                    Point key = entry.getKey();
                    Integer value = entry.getValue();
                    if (value > 1) {
                        LinkedList<Ball> temp = new LinkedList<>();
                        balls.forEach((ball) -> {
                            if (ball.position.x == key.x && ball.position.y == key.y) {
                                temp.add(ball);
                            }
                        });

                        temp.sort((o1, o2) -> {
                            if (o1.weight == o2.weight) {
                                return o1.number - o2.number;
                            }
                            return o1.weight - o2.weight;
                        });

                        for (int i1 = 0; i1 < value - 1; i1++) {
                            Ball ball = temp.get(0);

                            balls.remove(ball);
                        }

                        answer = time;
                    }
                }

                LinkedList<Ball> temp = new LinkedList<>();
                balls.forEach((Ball ball) -> {
                    if (ball.position.x < -1000 || ball.position.x > 1000 || ball.position.y < -1000 || ball.position.y > 1000) {
                        temp.add(ball);
                    }
                });

                temp.forEach(balls::remove);
            }

            System.out.println(answer);
        }

    }

    enum Direction {
        U(0),
        R(1),
        D(2),
        L(3);

        private final int value;

        Direction(int value) {
            this.value = value;
        }
    }

    public static class Ball {
        Point position;
        Direction direction;
        int number;
        int weight;

        public Ball(int x, int y, String direction, int number, int weight) {
            this.position = new Point(x, y);
            this.direction = Direction.valueOf(direction);
            this.number = number;
            this.weight = weight;
        }

        public void move() {
            position.x += dx[direction.value] * 0.5;
            position.y += dy[direction.value] * 0.5;
        }
    }

    public static class Point {
        double x;
        double y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return (int) (x * 31 + y);
        }

        @Override
        public boolean equals(Object obj) {
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }
    }
}