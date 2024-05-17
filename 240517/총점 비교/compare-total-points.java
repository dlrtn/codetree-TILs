import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Human> humans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            humans.add(new Human(a, b, c, d));
        }

        humans.sort((o1, o2) -> {
            if (o1.getScoreSum() != o2.getScoreSum()) {
                return o1.getScoreSum() - o2.getScoreSum();
            }
            return 0;
        });

        for (int i = 0; i < n; i++) {
            System.out.println(humans.get(i).name + " " + humans.get(i).korean + " " + humans.get(i).english + " " + humans.get(i).math);
        }

    }

    public static class Human {

        private String name;
        private int korean;
        private int english;
        private int math;

        public Human(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public int getScoreSum() {
            return this.korean + this.english + this.math;
        }
    }
}