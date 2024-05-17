import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        ArrayList<Point> points = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());

            points.add(new Point(number, i + 1));
        }

        points.sort(Comparator.comparingInt(o -> o.number));

        for (int i = 0; i < n; i++) {
            points.get(i).lastIndex = i + 1;
        }

        points.sort(Comparator.comparingInt(o -> o.firstIndex));

        for (int i = 0; i < n; i++) {
            System.out.print(points.get(i).lastIndex + " ");
        }


    }

    public static class Point {

        private int firstIndex;
        private int lastIndex;
        private int number;

        public Point(int number, int firstIndex) {
            this.number = number;
            this.firstIndex = firstIndex;
        }
    }
}