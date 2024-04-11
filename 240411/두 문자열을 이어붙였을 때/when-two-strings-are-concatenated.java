import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String bomb = st.nextToken();

        String ab = new StringBuilder(str).append(bomb).toString();
        String ba = new StringBuilder(bomb).append(str).toString();

        if (ab.equals(ba)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}