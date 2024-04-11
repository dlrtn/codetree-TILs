import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String b = st.nextToken();

        for (int i = 0; i < a.length(); i++) {
            if (a.equals(b)) {
                System.out.println(i);
                return;
            } else {
                b = b.substring(1) + b.charAt(0);
            }
            
        }
        System.out.println(-1);



    }
}