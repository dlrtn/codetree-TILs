import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        TreeSet<Problem> problems = new TreeSet<>(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                if (o1.l == o2.l) {
                    return o2.p - o1.p;
                }
                return o1.l - o2.l;
            }
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            problems.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String instruction = st.nextToken();

            int p;
            int l;

            switch (instruction) {
                case "ad":
                    p = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());

                    problems.add(new Problem(p, l));
                    break;
                case "sv":
                    p = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());

                    problems.remove(new Problem(p, l));
                    break;
                case "rc":
                    int x = Integer.parseInt(st.nextToken());

                    if (x == -1) {
                        Problem problem = problems.pollFirst();
                        System.out.println(problem.p);
                    } else {
                        Problem problem = problems.pollLast();
                        System.out.println(problem.p);
                    }
                    break;
            }

        }



    }

    public static class Problem {
        int p;
        int l;

        public Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }
}
