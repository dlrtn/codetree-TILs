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
        String str1 = st.nextToken();

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();

        for (int k = 0; k < str.length(); k++) {
            if (Character.isDigit(Character.valueOf(str.charAt(k)))) {
                sb.append(str.charAt(k));
            }
        }
        for (int k = 0; k < str1.length(); k++) {
            if (Character.isDigit(Character.valueOf(str1.charAt(k)))) {
                sb1.append(str1.charAt(k));
            }
        }

        int a = Integer.parseInt(sb.toString());
        int b = Integer.parseInt(sb1.toString());
        System.out.println(a + b);
    }
}