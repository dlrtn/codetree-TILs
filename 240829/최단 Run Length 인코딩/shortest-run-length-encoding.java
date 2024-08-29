import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length(); i++) {
            min = Math.min(min, encodeRunLength(A).length());

            A = shift(A);
        }

        System.out.println(min);
    }

    public static String shift(String A) {
        return A.substring(A.length() - 1) + A.substring(0, A.length() - 1);
    }

    public static String encodeRunLength(String A) {
        char nowAlphabet = 0;
        StringBuffer encodeString = new StringBuffer();
        int count = 0;

        for (int i = 0; i < A.length(); i++) {
            if (nowAlphabet != 0 && nowAlphabet == A.charAt(i)) {
                count++;
            } else {
                if (i != 0) {
                    encodeString.append(nowAlphabet);
                    encodeString.append(count);
                }

                count = 1;
                nowAlphabet = A.charAt(i);
            }
        }

        if (count != 0) {
            encodeString.append(nowAlphabet);
            encodeString.append(count);
        }

        return encodeString.toString();
    }
}