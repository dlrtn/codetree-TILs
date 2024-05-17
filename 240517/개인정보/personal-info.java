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

        ArrayList<Human> humans = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            double c = Double.parseDouble(st.nextToken());

            humans.add(new Human(name, b, c));
        }

        humans.sort(Comparator.comparing(o -> o.name));

        System.out.println("name");
        for (Human h : humans) {
            h.print();
        }
        System.out.println();

        humans.sort(Comparator.comparingInt(o -> -o.height));

        System.out.println("height");
        for (Human h : humans) {
            h.print();
        }

    }

    public static class Human {

        private String name;
        private int height;
        private double weight;

        public Human(String name, int height, double weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }

        public void print() {
            System.out.println(name + " " + height + " " + weight);
        }
    }
}