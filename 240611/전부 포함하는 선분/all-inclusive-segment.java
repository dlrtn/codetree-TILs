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

        lines.sort((a, b) -> {
            if (a.startX == b.startX) {
                return a.endX - b.endX;
            }
            return a.startX - b.startX;
        });

        if (n > 2) {
            if (Math.abs(lines.get(0).endX - lines.get(1).startX) < Math.abs(lines.get(n - 1).endX - lines.get(
                    n - 2).startX)) {
                // 뒤에 선분을 제외하는 경우,
                System.out.println(Math.abs(lines.get(0).startX - lines.get(n - 2).endX));
            } else {
                System.out.println(Math.abs(lines.get(1).startX - lines.get(n - 1).endX));
            }
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