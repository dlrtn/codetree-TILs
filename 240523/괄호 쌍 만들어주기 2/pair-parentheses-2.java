import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String[] arr = s.split("");

        int count = 0;
        for (int i = 0; i < arr.length - 3; i++) {
            if (arr[i].equals("(") && arr[i + 1].equals("(")) {
                for (int j = i + 2; j < arr.length - 1; j++) {
                    if (arr[j].equals(")") && arr[j + 1].equals(")")) {
                        count += 1;
                    }
                }
            }
        }
        System.out.println(count);
    }

}