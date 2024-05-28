import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<Line> programmers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            programmers.add(new Line(startTime, endTime));
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean isCross = false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (programmers.get(i).startX > programmers.get(j).startX
                        && programmers.get(i).endX < programmers.get(j).endX) {
                    isCross = true;
                }

                if (programmers.get(i).startX < programmers.get(j).startX
                        && programmers.get(i).endX > programmers.get(j).endX) {
                    isCross = true;
                }
            }

            if (!isCross) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static class Line {

        private int startX;
        private int endX;

        public Line(int startX, int endX) {
            this.startX = startX;
            this.endX = endX;
        }
    }
}