import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] fires = new int[n];
        TreeSet<Integer> fireStations = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fires[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            fireStations.add(Integer.parseInt(st.nextToken()));
        }

        int maxDistance = 0;
        for (int i = 0; i < n; i++) {

            if (fireStations.floor(fires[i]) == null) {
                maxDistance = Math.max(maxDistance, Math.abs(fireStations.ceiling(fires[i]) - fires[i]));
            } else if (fireStations.ceiling(fires[i]) == null) {
                maxDistance = Math.max(maxDistance, Math.abs(fireStations.floor(fires[i]) - fires[i]));
            } else {
                maxDistance = Math.max(maxDistance, Math.min(Math.abs(fireStations.floor(fires[i]) - fires[i]), Math.abs(fireStations.ceiling(fires[i]) - fires[i])));
            }
        }

        System.out.println(maxDistance);
    }
}
