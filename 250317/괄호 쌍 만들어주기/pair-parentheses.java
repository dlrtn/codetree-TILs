import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String string = st.nextToken();

        int n = string.length();
        int[] flag = new int[string.length()];

        for (int i = n - 2; i >= 0; i--) {
            if(string.charAt(i) == ')' && string.charAt(i + 1) == ')')
                flag[i] = flag[i + 1] + 1;
            else {
                flag[i] = flag[i + 1];
            }
        }

        long ans = 0;
        for(int i = 0; i < n - 2; i++) {
            if(string.charAt(i) == '(' && string.charAt(i + 1) == '(')
                ans += flag[i + 2];
        }

        System.out.println(ans);
    }
}
