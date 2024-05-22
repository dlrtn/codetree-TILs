import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();

        int count = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '(') {
                for (int j = i + 1; j < n.length(); j++) {
                    if (n.charAt(j) == ')') {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

}