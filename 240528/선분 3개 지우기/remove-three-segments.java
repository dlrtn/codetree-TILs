import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lines[i] = new Line(start, end);
        }

        int answer = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] points = new int[101];
                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }

                        for (int m = lines[l].start; m <= lines[l].end; m++) {
                            points[m]++;
                        }
                    }

                    boolean isPossible = true;
                    for (int l = 0; l < 101; l++) {
                        if (points[l] > 1) {
                            isPossible = false;
                        }
                    }

                    if (isPossible) {
                        answer++;
                    }
                }


            }
        }

        System.out.println(answer);
    }

    public static class Line {

        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}