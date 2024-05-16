import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String s2 = st.nextToken();

        if (Arrays.stream(s1.split("")).sorted().toArray().equals(Arrays.stream(s2.split("")).sorted().toArray())) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
            }
    }

}