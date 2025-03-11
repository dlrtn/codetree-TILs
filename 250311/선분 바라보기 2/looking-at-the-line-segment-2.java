import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Pair> pair = new ArrayList<>();

        boolean[] checked = new boolean[n];
        int controalTower = -1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            pair.add(new Pair(x1, y, 1, i));
            pair.add(new Pair(x2, y, -1, i));
        }
        Collections.sort(pair);

        TreeMap<Integer, Integer> tMap = new TreeMap<>();

        int minIdx = 0;
        for (int i = 0; i < n * 2; i++) {
            int xDot = pair.get(i).a;
            int yDot = pair.get(i).b;
            int loc = pair.get(i).y;
            int idx = pair.get(i).idx;

            if (loc == 1) {
                if (tMap.size() == 0) {
                    checked[idx] = true;
                } else if (tMap.firstKey() > yDot) {
                    checked[idx] = true;
                }

                tMap.put(yDot, idx);

            } else {
                tMap.remove(yDot);

                if (tMap.size() != 0) {
                    if (!checked[tMap.get(tMap.firstKey())]) {
                        checked[tMap.get(tMap.firstKey())] = true;
                    }
                } else {
                    if (!checked[idx]) {
                        checked[idx] = true;
                    }
                }


            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (checked[i]) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static class Pair implements Comparable<Pair> {
        int a;
        int b;
        int y;
        int idx;

        Pair(int a, int b, int y, int idx) {
            this.a = a;
            this.b = b;
            this.y = y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p) {
            return this.a - p.a;
        }
    }
}
