import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        boolean[] humans = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1') {
                humans[i] = true;
            }
        }

        int maxDistance = 0;
        for (int i = 0; i < humans.length; i++) {
            if (humans[i]) {
                for (int j = i + 1; j < humans.length; j++) {
                    if (humans[j]) {
                        maxDistance = Math.max(maxDistance, j - i);
                        break;
                    }
                }
            }
        }

        System.out.println(maxDistance / 2);
    }
}