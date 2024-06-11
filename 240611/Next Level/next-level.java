import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String code = st.nextToken();
        int time = Integer.parseInt(st.nextToken());

        System.out.println("user codetree lv 10");
        System.out.println("user " + code + " lv " + time);
    }
}