import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Yabawi[] yabawis = new Yabawi[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            yabawis[i] = new Yabawi(a, b, c);
        }

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            boolean[] yabawi = new boolean[n];
            int score = 0;

            yabawi[i] = true;
            for (int j = 0; j < n; j++) {
                boolean temp = yabawi[yabawis[j].a - 1];
                yabawi[yabawis[j].a - 1] = yabawi[yabawis[j].b - 1];
                yabawi[yabawis[j].b - 1] = temp;

                if (yabawi[yabawis[j].c - 1]) {
                    score++;
                }
            }

            answer = Math.max(answer, score);
        }

        System.out.println(answer);
    }

    public static class Yabawi {

        int a;
        int b;
        int c;

        public Yabawi(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}