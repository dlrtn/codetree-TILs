import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 'a' && str.charAt(i) <= 'z') {
                System.out.print((char) (str.charAt(i) - 32));
            } else {
                System.out.print((char) (str.charAt(i) + 32));
            }
        }
    }
}