import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<Programmer> programmers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            programmers.add(new Programmer(startTime, endTime));
        }

        int maxTime = 0;

        for (int i = 0; i < n; i++) {
            int[] visited = new int[1001];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                for (int k = programmers.get(j).startTime; k < programmers.get(j).endTime; k++) {
                    visited[k] = 1;
                }
            }

            maxTime = (int) Math.max(maxTime, Arrays.stream(visited).filter(v -> v == 1).count());

        }

        System.out.println(maxTime);
    }

    public static class Programmer {

        private int startTime;
        private int endTime;

        public Programmer(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}