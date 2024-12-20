import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] n = st.nextToken().split("");

        boolean isTwo = false;
        for (int i = 1; i < n.length; i++) {
            if (!n[i].equals(n[i - 1])) {
                isTwo = true;
            }
        }
        if (isTwo) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}