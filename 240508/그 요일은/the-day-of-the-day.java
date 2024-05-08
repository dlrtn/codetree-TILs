import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        String week = st.nextToken();

        int day = 0;
        for (int i = m1; i < m2; i++) {
            day += Month.values()[i - 1].getDayCounts();
        }

        day += d2 - d1 + 1;

        int answer = day / 7;
        if (day % 7 > Week.valueOf(week).getDay()) {
            answer++;
        }

        System.out.println(answer);

    }

    public enum Week {

        Mon(0),
        Tue(1),
        Wed(2),
        Thu(3),
        Fri(4),
        Sat(5),
        Sun(6);

        private final int day;

        Week(int day) {
            this.day = day;
        }

        public int getDay() {
            return day;
        }
    }

    public enum Month {
        JANUARY(1, 31),
        FEBRUARY(2, 29),
        MARCH(3, 31),
        APRIL(4, 30),
        MAY(5, 31),
        JUNE(6, 30),
        JULY(7, 31),
        AUGUST(8, 31),
        SEPTEMBER(9, 30),
        OCTOBER(10, 31),
        NOVEMBER(11, 30),
        DECEMBER(12, 31);

        private final int month;
        private final int dayCounts;

        Month(int month, int dayCounts) {
            this.month = month;
            this.dayCounts = dayCounts;
        }

        public int getMonth() {
            return month;
        }

        public int getDayCounts() {
            return dayCounts;
        }
    }
}