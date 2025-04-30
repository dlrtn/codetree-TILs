import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Jewel> jewels = new ArrayList<Jewel>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(weight, value));
        }

        jewels.sort((o1, o2) -> {
            if (o2.valuePerWeight < o1.valuePerWeight) {
                return -1;
            } else if (o2.valuePerWeight > o1.valuePerWeight) {
                return 1;
            } else {
                return 0;
            }
        });

        int totalWeight = 0;
        double totalValue = 0;

        int index = 0;
        while (m >= totalWeight) {
            Jewel jewel = jewels.get(index);

            if (jewel.weight + totalWeight <= m) {
                totalWeight += jewel.weight;
                totalValue += jewel.value;
                index++;
            } else {
                totalValue += (m - totalWeight) * jewel.valuePerWeight;
                totalWeight += m - totalWeight;
                break;
            }
        }

        System.out.printf("%.3f", totalValue);

    }

    public static class Jewel {
        int weight;
        int value;
        double valuePerWeight;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.valuePerWeight = (double) value / (double) weight;
        }
    }
}
