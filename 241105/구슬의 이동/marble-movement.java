import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int n;

    enum Direction {
        R(0),
        D(1),
        L(2),
        U(3);

        private final int value;

        Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<LinkedList<LinkedList<Ball>>> map = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            LinkedList<LinkedList<Ball>> temp = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                LinkedList<Ball> temp2 = new LinkedList<>();
                temp.add(temp2);
            }
            map.add(temp);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String direction = st.nextToken();
            int velocity = Integer.parseInt(st.nextToken());

            Ball ball = new Ball(x, y, direction, i, velocity);

            map.get(x).get(y).add(ball);
        }

        for (int i = 0; i < t; i++) {
            // 구슬 움직이기
            LinkedList<LinkedList<LinkedList<Ball>>> newMap = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                LinkedList<LinkedList<Ball>> temp = new LinkedList<>();
                for (int i1 = 0; i1 < n; i1++) {
                    LinkedList<Ball> temp2 = new LinkedList<>();
                    temp.add(temp2);
                }
                newMap.add(temp);
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (map.get(j).get(l).size() == 0) {
                        continue;
                    }

                    for (int m1 = 0; m1 < map.get(j).get(l).size(); m1++) {
                        Ball ball = map.get(j).get(l).get(m1);
                        ball.move();
                        newMap.get(ball.position.x).get(ball.position.y).add(ball);
                    }
                }
            }

            // 충돌 처리
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (newMap.get(j).get(l).size() > k) {
                        newMap.get(j).get(l).sort((o1, o2) -> {
                            if (o1.velocity == o2.velocity) {
                                return o1.number - o2.number;
                            }
                            return o1.velocity - o2.velocity;
                        });

                        for (int m1 = 0; m1 < newMap.get(j).get(l).size() - k; m1++) {
                            newMap.get(j).get(l).pop();
                        }
                    }
                }
            }

            map = newMap;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += map.get(i).get(j).size();
            }
        }

        System.out.println(count);
    }

    public static class Ball {
        Point position;
        String direction;
        int number;
        int velocity;

        // 바뀌어야 하는 것 : x, y, direction
        public void move() {
            for (int i = 0; i < velocity; i++) {
                Point nextPosition = getNextPosition();

                if (nextPosition.x < 0 || nextPosition.x >= n || nextPosition.y < 0 || nextPosition.y >= n) {
                    changeDirection();
                }

                position.x += dx[Direction.valueOf(direction).getValue()];
                position.y += dy[Direction.valueOf(direction).getValue()];
            }
        }

        private void changeDirection() {
            if (direction.equals("R")) {
                direction = "L";
            } else if (direction.equals("D")) {
                direction = "U";
            } else if (direction.equals("L")) {
                direction = "R";
            } else {
                direction = "D";
            }
        }

        private Point getNextPosition() {
            int nextX = position.x + dx[Direction.valueOf(direction).getValue()];
            int nextY = position.y + dy[Direction.valueOf(direction).getValue()];

            return new Point(nextX, nextY);
        }

        public Ball(int x, int y, String direction, int number, int velocity) {
            this.position = new Point(x, y);
            this.direction = direction;
            this.number = number;
            this.velocity = velocity;
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}