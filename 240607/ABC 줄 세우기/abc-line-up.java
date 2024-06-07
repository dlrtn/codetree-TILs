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
        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 'A' + i) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(count - 1);
    }
}