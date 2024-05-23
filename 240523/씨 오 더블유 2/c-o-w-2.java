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
        String s = st.nextToken();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (s.charAt(i) == 'C' && s.charAt(j) == 'O' && s.charAt(k) == 'W') {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

}