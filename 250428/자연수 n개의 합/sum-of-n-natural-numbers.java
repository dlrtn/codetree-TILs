import java.util.Scanner;

public class Main {    
    public static final int MAX_S = 2000000000;
    
    // 변수 선언
    public static long s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        s = sc.nextLong();

        long left = 1;                          // 가장 작은 숫자 값을 설정합니다.
        long right = MAX_S;                     // 가장 큰 숫자 값을 설정합니다.
        long maxNum = 0;                        // 최대이므로, 답이 될 수 있는 값보다 더 작은 값으로 설정합니다.

        while (left <= right) {                 // [left, right]가 유효한 구간이면 계속 수행합니다.
            long mid = (left + right) / 2;      // 가운데 위치를 선택합니다.
            if(mid * (mid + 1) / 2 <= s) {      // 1부터 n까지의 합이 s보다 같거나 작다면
                left = mid + 1;                 // 오른쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 left를 바꿔줍니다.
                maxNum = Math.max(maxNum, mid); // 답의 후보들 중 최댓값을 계속 갱신해줍니다.
            }
            else                               
                right = mid - 1;                // s보다 큰 경우라면 right를 바꿔줍니다.
        }

        System.out.print(maxNum);               // 조건을 만족하는 최대 n의 값을 반환합니다.
    }
}