import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        NumberCount numberCount = new NumberCount();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            numberCount.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        for (int i = 0; i <= n - m; i++) {
            NumberCount tempNumberCount = new NumberCount();
            for (int j = 0; j < m; j++) {
                tempNumberCount.add(arr[i + j]);
            }
            if (numberCount.equals(tempNumberCount)) {
                count++;
            }
        }

        System.out.println(count);


    }

    public static class NumberCount {

        int zeroCount;
        int oneCount;
        int twoCount;
        int threeCount;
        int fourCount;
        int fiveCount;
        int sixCount;
        int sevenCount;
        int eightCount;
        int nineCount;

        public NumberCount() {
            this.zeroCount = 0;
            this.oneCount = 0;
            this.twoCount = 0;
            this.threeCount = 0;
            this.fourCount = 0;
            this.fiveCount = 0;
            this.sixCount = 0;
            this.sevenCount = 0;
            this.eightCount = 0;
            this.nineCount = 0;
        }

        public void add(int num) {
            switch (num) {
                case 0:
                    zeroCount++;
                    break;
                case 1:
                    oneCount++;
                    break;
                case 2:
                    twoCount++;
                    break;
                case 3:
                    threeCount++;
                    break;
                case 4:
                    fourCount++;
                    break;
                case 5:
                    fiveCount++;
                    break;
                case 6:
                    sixCount++;
                    break;
                case 7:
                    sevenCount++;
                    break;
                case 8:
                    eightCount++;
                    break;
                case 9:
                    nineCount++;
                    break;
            }
        }

        public boolean equals(NumberCount numberCount) {
            return this.zeroCount == numberCount.zeroCount &&
                    this.oneCount == numberCount.oneCount &&
                    this.twoCount == numberCount.twoCount &&
                    this.threeCount == numberCount.threeCount &&
                    this.fourCount == numberCount.fourCount &&
                    this.fiveCount == numberCount.fiveCount &&
                    this.sixCount == numberCount.sixCount &&
                    this.sevenCount == numberCount.sevenCount &&
                    this.eightCount == numberCount.eightCount &&
                    this.nineCount == numberCount.nineCount;
        }
    }

}