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
        List<WeatherData> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            String week = st.nextToken();
            String weather = st.nextToken();

            arr.add(new WeatherData(date, week, weather));
        }

        arr.stream().sorted((o1, o2) -> {
            String[] o1Date = o1.date.split("-");
            int o1Year = Integer.parseInt(o1Date[0]);
            int o1Month = Integer.parseInt(o1Date[1]);
            int o1Day = Integer.parseInt(o1Date[2]);

            String[] o2Date = o2.date.split("-");
            int o2Year = Integer.parseInt(o2Date[0]);
            int o2Month = Integer.parseInt(o2Date[1]);
            int o2Day = Integer.parseInt(o2Date[2]);

            if (o1Year > o2Year) {
                return 1;
            } else if (o1Year < o2Year) {
                return -1;
            } else {
                if (o1Month > o2Month) {
                    return 1;
                } else if (o1Month < o2Month) {
                    return -1;
                } else {
                    if (o1Day > o2Day) {
                        return 1;
                    }
                    if (o1Day < o2Day) {
                        return -1;
                    }
                }
            }
            return 0;

        }).filter(WeatherData::isWeatherRain).findFirst().ifPresent(WeatherData::print);
    }

    public static class WeatherData {

        private String date;
        private String week;
        private String weather;

        public WeatherData(String date, String week, String weather) {
            this.date = date;
            this.weather = weather;
            this.week = week;
        }

        public void print() {
            System.out.println(date + " " + week + " " + weather);
        }

        public boolean isWeatherRain() {
            return weather.equals("Rain");
        }
    }
}