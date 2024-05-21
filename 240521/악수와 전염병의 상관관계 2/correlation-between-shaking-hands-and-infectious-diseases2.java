import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        List<Programmer> programmers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            programmers.add(new Programmer(K));
        }
        programmers.get(P - 1).isInfected = true;

        List<Info> infos = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            infos.add(new Info(t, x, y));
        }

        infos.sort((o1, o2) -> {
            if (o1.t != o2.t) {
                return o1.t - o2.t;
            }
            return 0;
        });

        for (Info info : infos) {
            if (programmers.get(info.x - 1).isInfected && !programmers.get(info.y - 1).isInfected) {
                if (programmers.get(info.x - 1).infectCount > 0) {
                    programmers.get(info.y - 1).isInfected = true;
                    programmers.get(info.x - 1).infectCount--;
                }

            } else if (!programmers.get(info.x - 1).isInfected && programmers.get(info.y - 1).isInfected) {
                if (programmers.get(info.y - 1).infectCount > 0) {
                    programmers.get(info.x - 1).isInfected = true;
                    programmers.get(info.y - 1).infectCount--;
                }
            } else if (programmers.get(info.x - 1).isInfected && programmers.get(info.y - 1).isInfected) {
                programmers.get(info.y - 1).infectCount--;
                programmers.get(info.x - 1).infectCount--;
            }
        }



        for (Programmer programmer : programmers) {
            if (programmer.isInfected) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
    }

    public static class Info {

        int t;
        int x;
        int y;

        public Info(int t, int x, int y) {
            this.t = t;
            this.x = x;
            this.y = y;
        }
    }

    public static class Programmer {
        boolean isInfected;
        int infectCount;

        public Programmer(int infectCount) {
            this.isInfected = false;
            this.infectCount = infectCount;
        }
    }

}