import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr.add(Integer.parseInt(st.nextToken()));
        }

        while (isExplorable(arr, m)) {
            int nowNumber = 0;
            int count = 0;

            LinkedList<Integer> temp = new LinkedList<>();
            for (Integer boomNumber : arr) {
                if (nowNumber != boomNumber) {
                    if (count < m) {
                        for (int i = 0; i < count; i++) {
                            temp.add(nowNumber);
                        }
                    }

                    nowNumber = boomNumber;
                    count = 1;
                } else {
                    count++;
                }
            }
            if (count < m) {
                for (int i = 0; i < count; i++) {
                    temp.add(nowNumber);
                }
            }

            arr = temp;

        }

        System.out.println(arr.size());
        arr.forEach(System.out::println);
    }

    public static boolean isExplorable(List<Integer> arr, int explosionThreshold) {
        int count = 0;
        int nowBoomNumber = 0;

        for (Integer integer : arr) {
            if (nowBoomNumber != integer) {
                nowBoomNumber = integer;
                count = 1;
            } else {
                count++;
            }

            if (count >= explosionThreshold) {
                return true;
            }
        }

        return false;
    }
}