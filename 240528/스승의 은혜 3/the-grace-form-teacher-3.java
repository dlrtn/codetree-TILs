import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Info[] infos = new Info[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            infos[i] = new Info(p, s);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int count = 0;

            infos[i].p /= 2;
            Info[] temps = Arrays.stream(infos).sorted(Comparator.comparingInt(o -> o.p + o.s))
                    .toArray(Info[]::new);
            for (int j = 0; j < n; j++) {

                if (temps[j].p + temps[j].s + sum <= b) {
                    sum += temps[j].p + temps[j].s;
                    count++;

                }
            }

            infos[i].p *= 2;
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    public static class Info {

        public int p;
        public int s;

        public Info(int p, int s) {
            this.p = p;
            this.s = s;
        }
    }
}