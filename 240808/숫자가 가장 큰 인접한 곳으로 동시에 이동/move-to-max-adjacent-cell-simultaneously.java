import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        LinkedList<Ball> balls = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            balls.add(new Ball(r, c));
        }

        for (int i = 0; i < t; i++) {
            // 구슬 이동
            balls.forEach(ball -> ball.move(map));

            // 구슬 별 좌표 카운트
            int[][] nextBallPositionCount = new int[n][n];
            balls.forEach((ball) -> {
                nextBallPositionCount[ball.r][ball.c]++;
            });

            // 2개 이상인 경우, 볼 삭제 대상에 추가
            LinkedList<Ball> delete = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (nextBallPositionCount[j][k] >= 2) {
                        delete.add(new Ball(j, k));
                    }
                }
            }

            // 삭제 대상 인덱스 확인
            LinkedList<Integer> deleteIndex = new LinkedList<>();
            for (int j = 0; j < delete.size(); j++) {
                Ball ball = delete.get(j);
                for (int k = 0; k < balls.size(); k++) {
                    Ball ball1 = balls.get(k);
                    if (ball.r == ball1.r && ball.c == ball1.c) {
                        deleteIndex.add(k);
                    }
                }
            }

            // 삭제 대상 삭제
            for (int j = deleteIndex.size() - 1; j >= 0; j--) {
                balls.remove((int) deleteIndex.get(j));
            }
        }

        System.out.println(balls.size());
    }

    public static class Ball {

        int r;
        int c;

        int[] dr = {0, -1, 1, 0, 0};
        int[] dc = {0, 0, 0, -1, 1};

        public Ball(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public void move(int[][] map) {
            int maximumSize = map.length;
            int maxNum = Integer.MIN_VALUE;
            int nextDirection = 0;

            for (int i = 1; i < 5; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];
                if (nextR < 0 || nextR >= maximumSize || nextC < 0 || nextC >= maximumSize) {
                    continue;
                }

                int nextNumber = map[nextR][nextC];
                if (map[r][c] < nextNumber && maxNum < nextNumber) {
                    maxNum = nextNumber;
                    nextDirection = i;
                }
            }

            r += dr[nextDirection];
            c += dc[nextDirection];
        }
    }
}