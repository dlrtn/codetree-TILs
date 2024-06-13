import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        LinkedList<Character> s = new LinkedList<>();
        s.addAll(str.chars().mapToObj(e -> (char) e).collect(Collectors.toCollection(LinkedList::new)));

        ListIterator<Character> it = s.listIterator(s.size());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String instruction = st.nextToken();
            switch (instruction) {
                case "L":
                    if (it.hasPrevious()) {
                        it.previous();
                    }
                    break;
                case "R":
                    if (it.hasNext()) {
                        it.next();
                    }
                    break;
                case "D":
                    if (it.hasNext()) {
                        it.next();
                        it.remove();
                    }
                    break;
                case "P":
                    String c = st.nextToken();
                    it.add(c.charAt(0));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.size(); i++) {
            sb.append(s.get(i));
        }

        System.out.println(sb);
    }
}