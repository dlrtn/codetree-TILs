import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String[] str = A.split("");
        boolean isPalindrome = true;

        for (int i = 0; i < A.length(); i++) {
            if (!str[i].equals(str[A.length() - i - 1])) {
                isPalindrome = false;
            }
        }

        if (isPalindrome) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}