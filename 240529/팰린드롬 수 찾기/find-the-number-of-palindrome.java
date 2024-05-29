import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i = x; i <= y; i++) {
            if (isPalindrome(i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        String[] arr = str.split("");
        String[] reverseArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reverseArr[i] = arr[arr.length - 1 - i];
        }

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(reverseArr[i])) {
                return false;
            }
        }
        return true;
    }
}