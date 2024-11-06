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
        LinkedList<Line> lines = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lines.add(new Line(start, end));
        }

        lines.sort((a, b) -> {
            if (a.end == b.end) {
                return a.start - b.start;
            }
            return a.end - b.end;
        });

        int answer = 1;
        int end = lines.get(0).end;
        for (int i = 1; i < n; i++) {
            Line line = lines.get(i);
            if (line.start > end) {
                answer++;
                end = line.end;
            }
        }

        System.out.println(answer);
    }

    public static class Line {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}