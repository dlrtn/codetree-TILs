import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    
    public static int n;
    public static int[] arr = new int[MAX_N];
    public static int[] mergedArr = new int[MAX_N];

    public static void merge(int low, int mid, int high) {
        int i = low, j = mid + 1;            // 각 리스트 내의 원소 위치를 잡습니다.

        int k = low;                         // 병합 시 원소를 담을 위치를 유지합니다.
        while(i <= mid && j <= high) {       // 두 리스트 내의 원소가 아직 남아있다면
            if (arr[i] <= arr[j])            // 첫 번째 리스트 내의 원소가 더 작다면
                mergedArr[k++] = arr[i++];   // 해당 원소를 옮겨줍니다. 
            else
                mergedArr[k++] = arr[j++];   // 그렇지 않다면 두 번째 리스트 내의 원소를 옮겨줍니다.
        }

        while(i <= mid)                      // 아직 첫 번째 리스트 내 원소가 남아있다면
            mergedArr[k++] = arr[i++];       // 남은 원소들을 전부 옮겨줍니다.
        
        while(j <= high)                     // 아직 두 번째 리스트 내 원소가 남아있다면
            mergedArr[k++] = arr[j++];       // 남은 원소들을 전부 옮겨줍니다.
        
        for(int l = low; l <= high; l++)     // 병합된 리스트를 다시
            arr[l] = mergedArr[l];           // 원본 리스트에 옮겨줍니다.
    }

    public static void mergeSort(int low, int high) {
        if(low < high) {                   // 원소의 개수가 2개 이상인 경우에만 진행
            int mid = (low + high) / 2;    // 가운데 원소의 위치
            mergeSort(low, mid);           // 왼쪽 부분에 대해 병합정렬 진행
            mergeSort(mid + 1, high);      // 우측 부분에 대해 병합정렬 진행
            merge(low, mid, high);         // 정렬된 두 리스트를 하나로 병합
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        mergeSort(0, n - 1);

        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}