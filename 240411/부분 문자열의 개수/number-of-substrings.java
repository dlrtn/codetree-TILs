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
        String copy = st.nextToken();

        System.out.println(kmp(str, copy));
    }

    public static int kmp(String str, String copy) {
        int[] pi = getPi(copy);
        int j = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != copy.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == copy.charAt(j)) {
                if (j == copy.length() - 1) {
                    count++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return count;
    }

    public static int[] getPi(String str) {
        int[] pi = new int[str.length()];
        int j = 0;
        for (int i = 1; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}