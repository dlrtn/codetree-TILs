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

        int n = Integer.parseInt(st.nextToken());
        List<Student> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr.add(new Student(i, h, w));
        }

        arr.stream().sorted((o1, o2) -> {
            if (o1.height < o2.height) {
                return -1;
            } else if (o1.height > o2.height) {
                return 1;
            } else {
                if (o1.weight > o2.weight) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }).forEach(Student::print);
    }

    public static class Student {

        private int id;
        private int height;
        private int weight;

        public Student(int id, int height, int weight) {
            this.id = id;
            this.height = height;
            this.weight = weight;
        }

        public void print() {
            System.out.println(height + " " + weight + " " + id);
        }
    }
}