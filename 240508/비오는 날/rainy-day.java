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

        arr.stream().filter(WeatherData::isWeatherRain).findFirst().get().print();
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