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

        System.out.println(s1);
        s1 = Arrays.stream(s1.split("")).sorted().collect( StringBuilder::new, StringBuilder::append, StringBuilder::append       ).toString();
        s2 = Arrays.stream(s2.split("")).sorted().collect( StringBuilder::new, StringBuilder::append, StringBuilder::append       ).toString();

        System.out.println(s1);


        if (s1.equals(s2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}