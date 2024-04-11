import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        int count = 0;
        float average = 0;
        char cha = st.nextToken().charAt(0);
        for (int i = 0; i < n; i++) {
            if (arr[i].charAt(0) == cha) {
                count++;
                average += arr[i].length();
            }
        }

        System.out.printf("%d %.2f", count, average / count);

    }
}