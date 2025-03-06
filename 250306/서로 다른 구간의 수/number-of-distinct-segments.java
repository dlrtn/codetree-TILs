import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        LinkedList<Point> points = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            points.add(new Point(a, true, i));
            points.add(new Point(b, false, i));
        }

        Collections.sort(points);

        HashSet<Integer> visited = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < n * 2; i++) {
            int x = points.get(i).x;
            int index = points.get(i).index;
            boolean isStart = points.get(i).isStart;

            if (isStart) {
                if (visited.isEmpty()) {
                    answer++;
                }

                visited.add(index);
            } else {
                visited.remove(index);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    public static class Point implements Comparable<Point> {
        int x;
        boolean isStart;
        int index;

        public Point(int x, boolean isStart, int index) {
            this.x = x;
            this.isStart = isStart;
            this.index = index;
        }

        @Override
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }
}
