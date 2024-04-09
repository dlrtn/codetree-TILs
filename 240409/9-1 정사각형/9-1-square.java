import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {        
                int number = 0;
                switch ((i * n + j) % 9) {
                    case 0:
                        number = 9;
                        break;
                    case 1:
                        number = 8;
                        break;
                    case 2:
                        number = 7;
                        break;
                    case 3:
                        number = 6;
                        break;
                    case 4:
                        number = 5;
                        break;
                    case 5:
                        number = 4;
                        break;
                    case 6:
                        number = 3;
                        break;
                    case 7:
                        number = 2;
                        break;
                    case 8:
                        number = 1;
                        break;
                }
                System.out.printf("%d", number);
            }
            System.out.println();
        }
    }
}