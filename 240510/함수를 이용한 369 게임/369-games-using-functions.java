import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = a; i <= b; i++) {
            if (String.valueOf(i).contains("3") || String.valueOf(i).contains("6")
                    || String.valueOf(i).contains("9") || i % 3 == 0) {
                count++;
            }
        }
        
        System.out.println(count);
    }


}