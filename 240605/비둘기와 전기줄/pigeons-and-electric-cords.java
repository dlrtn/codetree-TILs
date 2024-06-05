import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int count = 0;

        Map<Integer, Pigeon> pigeonMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());

            if (pigeonMap.containsKey(index)) {
                Pigeon pigeon = pigeonMap.get(index);
                if (pigeon.location != location) {
                    count++;
                }
                pigeon.location = location;
            } else {
                pigeonMap.put(index, new Pigeon(location));
            }
        }

        System.out.println(count);
    }

    public static class Pigeon {
        public int location;

        public Pigeon(int location) {
            this.location = location;
        }
    }
}