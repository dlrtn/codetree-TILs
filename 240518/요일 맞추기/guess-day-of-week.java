import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


enum month {
    JANUARY(1, 31),
    FEBRUARY(2, 28),
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
    private final int day;

    month(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}

enum Week {
    Mon, Tue, Wed, Thu, Fri, Sat, Sun;

    public static Week getWeek(int day) {
        while (day < 0) {
            day += 7;
        }
        return Week.values()[day % 7];
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int count = d2 - d1;
        for (int i = 1; i < m2; i++) {
            count += month.values()[i - 1].getDay();
        }
        for (int i = 1; i < m1; i++) {
            count -= month.values()[i - 1].getDay();
        }

        System.out.println(Week.getWeek(count));
    }
}