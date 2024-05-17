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

            humans.add(new Human(a, b, c));
        }

        humans.sort((o1, o2) -> {
            if (o1.height != o2.height) {
                return o1.height - o2.height;
            }
            return 0;
        });

        for (Human h : humans) {
            System.out.println(h.name + " " + h.height + " " + h.weight);
        }
    }

    public static class Human {

        private String name;
        private int height;
        private int weight;

        public Human(String name, int height, int weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }
}