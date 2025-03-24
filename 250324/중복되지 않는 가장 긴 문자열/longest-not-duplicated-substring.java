import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        int j = 0;

        int answer = Integer.MIN_VALUE;

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }

            answer = Math.max(answer, set.size());

            set.remove(s.charAt(i));
        }

        System.out.println(answer);
    }
}
