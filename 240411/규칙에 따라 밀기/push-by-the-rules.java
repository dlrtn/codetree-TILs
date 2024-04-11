import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            deque.add(str.charAt(i));
        }

        st = new StringTokenizer(br.readLine());
        String command = st.nextToken();

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'L') {
                deque.addLast(deque.pollFirst());
            } else {
                deque.addFirst(deque.pollLast());
            }
        }

        System.out.println(deque.toString().replaceAll("[\\[\\], ]", ""));
    }
}