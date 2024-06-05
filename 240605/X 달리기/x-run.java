import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());

        List<Distance> distances = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            // 소요 시간 2n - 1
            // i 제곱 값이 해당 거리

            distances.add(new Distance(i * i, 2 * i - 1));
        }

        int count = 0;
        int maximumSpeed = 0;

        for (int i = 100; i > 0; i--) {
            if (x >= distances.get(i - 1).distance) {
                x -= distances.get(i - 1).distance;
                count += distances.get(i - 1).time;
                maximumSpeed = i;
                break;
            }
        }

        for (int i = maximumSpeed; i > 0; i--) {
            count += x / i;
            x %= i;
        }
        System.out.println(count);
    }

    static class Distance {

        int distance;
        int time;

        public Distance(int distance, int time) {
            this.distance = distance;
            this.time = time;
        }
    }
}