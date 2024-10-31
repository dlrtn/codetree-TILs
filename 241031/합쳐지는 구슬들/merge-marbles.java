import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        LinkedList<LinkedList<LinkedList<Bead>>> map = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            map.add(new LinkedList<>());
            for (int j = 0; j < n; j++) {
                map.get(i).add(new LinkedList<>());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            int weight = Integer.parseInt(st.nextToken());

            Bead bead = new Bead(i + 1, x - 1, y - 1, dir, weight);

            map.get(x - 1).get(y - 1).add(bead);
        }

        // t번 움직임 수행
        for (int i = 0; i < t; i++) {
            // 볼들을 움직인다.
            LinkedList<LinkedList<LinkedList<Bead>>> movedBeads = moveBeads(map);

            map = movedBeads;
        }

        int count = 0;
        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!map.get(i).get(j).isEmpty()) {
                    if (map.get(i).get(j).size() > 1) {
                        for (Bead bead : map.get(i).get(j)) {
                            count++;
                            maxWeight = Math.max(maxWeight, bead.weight);
                        }
                    } else {
                        count++;
                        maxWeight = Math.max(maxWeight, map.get(i).get(j).get(0).weight);
                    }
                }
            }
        }

        System.out.println(count + " " + maxWeight);
    }

    private static LinkedList<LinkedList<LinkedList<Bead>>> moveBeads(LinkedList<LinkedList<LinkedList<Bead>>> map) {
        LinkedList<LinkedList<LinkedList<Bead>>> temp = new LinkedList<>();
        int n = map.size();
        for (int i = 0; i < n; i++) {
            temp.add(new LinkedList<>());
            for (int j = 0; j < n; j++) {
                temp.get(i).add(new LinkedList<>());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!map.get(i).get(j).isEmpty()) {
                    int dx = Direction.getDxDy(Direction.valueOf(map.get(i).get(j).get(0).dir).getValue())[0];
                    int dy = Direction.getDxDy(Direction.valueOf(map.get(i).get(j).get(0).dir).getValue())[1];

                    if (i + dx >= n || j + dy >= n || i + dx < 0 || j + dy < 0) {
                        map.get(i).get(j).get(0).changeDirection();
                        temp.get(i).get(j).add(map.get(i).get(j).get(0));
                    } else {
                        temp.get(i + dx).get(j + dy).add(map.get(i).get(j).get(0));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp.get(i).get(j).size() > 1) {
                    Bead compositedBead = mergeBeads(temp.get(i).get(j));

                    temp.get(i).get(j).clear();
                    temp.get(i).get(j).add(compositedBead);
                }
            }
        }

        return temp;
    }

    private static Bead mergeBeads(LinkedList<Bead> beads) {
        int weightSum = 0;
        String direction = null;
        int n = 0;
        int x = beads.get(0).x;
        int y = beads.get(0).y;

        for (Bead bead : beads) {
            weightSum += bead.weight;
            if (n < bead.num) {
                direction = bead.dir;
                n = bead.num;
            }
        }

        return new Bead(n, x, y, direction, weightSum);
    }

    public enum Direction {
        U(0), D(1), L(2), R(3);

        private int value;

        Direction(int value) {
            this.value = value;
        }

        public static Direction getDirection(int value) {
            switch (value) {
                case 0:
                    return U;
                case 1:
                    return D;
                case 2:
                    return L;
                case 3:
                    return R;
                default:
                    return null;
            }
        }

        public static int[] getDxDy(int value) {
            switch (value) {
                case 0:
                    return new int[]{-1, 0};
                case 1:
                    return new int[]{1, 0};
                case 2:
                    return new int[]{0, -1};
                case 3:
                    return new int[]{0, 1};
                default:
                    return null;
            }
        }

        public int getValue() {
            return value;
        }
    }

    public static class Bead {
        int num;
        int x;
        int y;
        String dir;
        int weight;

        public Bead(int num, int x, int y, String dir, int weight) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.weight = weight;
        }

        public void changeDirection() {
            switch (dir) {
                case "U":
                    dir = "D";
                    break;
                case "D":
                    dir = "U";
                    break;
                case "L":
                    dir = "R";
                    break;
                case "R":
                    dir = "L";
                    break;
            }
        }
    }
}