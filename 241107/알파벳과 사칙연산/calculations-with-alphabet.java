import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Character, Integer> alphabet = new HashMap<>();
    static int max = Integer.MIN_VALUE;
    static LinkedList<Integer> numbers = new LinkedList<>();
    static String expression;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        expression = st.nextToken();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= 'a' && expression.charAt(i) <= 'z') {
                alphabet.put(expression.charAt(i), 0);
            }
        }

        backtracking(0, alphabet.size());

        System.out.println(max);
    }

    public static void backtracking(int depth, int n) {
        if (depth == n) {
            int result = calculate();
            max = Math.max(result, max);

            return;
        }

        for (int i = 1; i <= 4; i++) {
            numbers.add(i);
            backtracking(depth + 1, n);
            numbers.pollLast();
        }
    }

    public static int calculate() {
        for (int i = 0; i < alphabet.size(); i++) {
            alphabet.put(alphabet.keySet().toArray(new Character[0])[i], numbers.get(i));
        }

        int initNum = alphabet.get(Character.valueOf(expression.charAt(0)));

        for (int i = 1; i < expression.length(); i += 2) {
            switch (expression.charAt(i)) {
                case '+':
                    initNum += alphabet.get(expression.charAt(i + 1));
                    break;
                case '-':
                    initNum -= alphabet.get(expression.charAt(i + 1));
                    break;
                case '*':
                    initNum *= alphabet.get(expression.charAt(i + 1));
                    break;
                case '/':
                    initNum /= alphabet.get(expression.charAt(i + 1));
                    break;
            }
        }

        return initNum;
    }
}