import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        LinkedList<LinkedList<Integer>> arr = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            LinkedList<Integer> temp = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }
            arr.add(temp);
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int floor = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            if (direction.equals("L")) {
                pushLeft(floor, arr);
            } else {
                pushRight(floor, arr);
            }

            if (isPropagableToLowerFloor(floor, arr)) {
                propagate(floor + 1, arr, false, direction.equals("L") ? "R" : "L");
            }
            if (isPropagableToUpperFloor(floor, arr)) {
                propagate(floor - 1, arr, true, direction.equals("L") ? "R" : "L");
            }
        }

        for (int i = 0; i < n; i++) {
            arr.get(i).forEach((line) -> System.out.print(line + " "));
            System.out.println();
        }


    }

    public static void pushLeft(int floor, LinkedList<LinkedList<Integer>> arr) {
        int index = floor - 1;

        arr.get(index).addFirst(arr.get(index).pollLast());
    }

    public static void pushRight(int floor, LinkedList<LinkedList<Integer>> arr) {
        int index = floor - 1;

        arr.get(index).addLast(arr.get(index).pollFirst());
    }

    public static void propagate(int floor, LinkedList<LinkedList<Integer>> arr,
            boolean propagationDirection, String direction) {
        if (direction.equals("L")) {
            pushLeft(floor, arr);
        } else {
            pushRight(floor, arr);
        }

        if (!propagationDirection) { // 아래에서 올라온 것
            if (isPropagableToLowerFloor(floor, arr)) {
                propagate(floor + 1, arr, false, direction.equals("L") ? "R" : "L");
            }
        } else { // 위에서 내려온 것
            if (isPropagableToUpperFloor(floor, arr)) {
                propagate(floor - 1, arr, true, direction.equals("L") ? "R" : "L");
            }
        }
    }

    public static boolean isPropagableToLowerFloor(int floor, LinkedList<LinkedList<Integer>> arr) {
        if (floor == arr.size()) {
            return false;
        }

        int floorSize = arr.get(0).size();
        for (int i = 0; i < floorSize; i++) {
            if (Objects.equals(arr.get(floor - 1).get(i), arr.get(floor).get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPropagableToUpperFloor(int floor, LinkedList<LinkedList<Integer>> arr) {
        if (floor == 1) {
            return false;
        }

        int floorSize = arr.get(0).size();
        for (int i = 0; i < floorSize; i++) {
            if (Objects.equals(arr.get(floor - 1).get(i), arr.get(floor - 2).get(i))) {
                return true;
            }
        }
        return false;
    }
}