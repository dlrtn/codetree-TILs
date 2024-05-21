import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();

        String[] arr = n.split("");

        int startX = 0;
        int startY = 0;
        int direction = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("L")) {
                direction += 3;
            } else if (arr[i].equals("R")) {
                direction += 1;
            } else if (arr[i].equals("F")) {
                startX += dx[direction];
                startY += dy[direction];
            }
            direction %= 4;
        }

        System.out.println(startX + " " + startY);

    }

}