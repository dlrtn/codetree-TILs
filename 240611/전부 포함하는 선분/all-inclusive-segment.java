import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            lines.add(new Line(startX, endX));
        }



        if (n > 2) {
            int minDistance = Integer.MAX_VALUE;

            lines.sort((a, b) -> {
                if (a.startX == b.startX) {
                    return a.endX - b.endX;
                }
                return a.startX - b.startX;
            });
            int minX1 = Integer.MAX_VALUE;
            int maxX1 = 0;
            for (int i = 1; i < n; i++) {
                minX1 = Math.min(minX1, lines.get(i).startX);
                maxX1 = Math.max(maxX1, lines.get(i).endX);
            }
            minDistance = Math.min(minDistance, Math.abs(maxX1 - minX1));

            lines.sort((a, b) -> {
                if (a.endX == b.endX) {
                    return a.startX - b.startX;
                }
                return a.endX - b.endX;
            });
            int minX2 = Integer.MAX_VALUE;
            int maxX2 = 0;
            for (int i = 0; i < n - 1; i++) {
                minX2 = Math.min(minX2, lines.get(i).startX);
                maxX2 = Math.max(maxX2, lines.get(i).endX);

            }
            minDistance = Math.min(minDistance, Math.abs(maxX2 - minX2));

            System.out.println(Math.abs(minDistance));
        } else {
            System.out.println(Math.abs(lines.get(0).startX - lines.get(1).endX));
        }
    }

    public static class Line {

        int startX;
        int endX;

        public void print() {
            System.out.println(startX + " " + endX);
        }

        public Line(int startX, int endX) {
            this.startX = startX;
            this.endX = endX;
        }
    }
}