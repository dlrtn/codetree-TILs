import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String T = st.nextToken();

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
        }

        Arrays.sort(words);

        int count = 0;

        for (int i = 0; i < n; i++) {
            int tempCount = 0;
            if (T.length() > words[i].length()) {
                continue;
            }
            for (int j = 0; j < T.length(); j++) {
                if (T.charAt(j) == words[i].charAt(j)) {
                    tempCount++;
                }
            }
            if (tempCount == T.length()) {
                count++;
            }

            if (count == k) {
                System.out.println(words[i]);
                break;
            }
        }
    }

}