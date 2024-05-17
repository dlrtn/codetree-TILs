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
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            humans.add(new Human(i + 1, b, c));
        }

        humans.sort((o1, o2) -> {
            if (o1.height != o2.height) {
                return o2.height - o1.height;
            } else if (o1.weight != o2.weight) {
                return o2.weight - o1.weight;
            } else {
                return o1.index - o2.index;
            }
        });

        for (Human h : humans) {
            h.print();
        }

    }

    public static class Human {

        private int index;
        private int height;
        private int weight;

        public Human(int index, int height, int weight) {
            this.index = index;
            this.height = height;
            this.weight = weight;
        }

        public void print() {
            System.out.println(height + " " + weight + " " + index);
        }
    }
}