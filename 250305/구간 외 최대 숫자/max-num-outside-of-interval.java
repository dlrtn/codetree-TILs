import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static int[] arr;
    static int[] segmentTree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        segmentTree = new int[4 * N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        buildSegmentTree(0, N - 1, 1);
        
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken()) - 1;
            int bi = Integer.parseInt(st.nextToken()) - 1;
            
            int maxLeft = (ai > 0) ? query(0, N - 1, 1, 0, ai - 1) : Integer.MIN_VALUE;
            int maxRight = (bi < N - 1) ? query(0, N - 1, 1, bi + 1, N - 1) : Integer.MIN_VALUE;
            
            bw.write(Math.max(maxLeft, maxRight) + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    static void buildSegmentTree(int start, int end, int node) {
        if (start == end) {
            segmentTree[node] = arr[start];
            return;
        }
        
        int mid = (start + end) / 2;
        buildSegmentTree(start, mid, 2 * node);
        buildSegmentTree(mid + 1, end, 2 * node + 1);
        segmentTree[node] = Math.max(segmentTree[2 * node], segmentTree[2 * node + 1]);
    }
    
    static int query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return Integer.MIN_VALUE;
        if (left <= start && end <= right) return segmentTree[node];
        
        int mid = (start + end) / 2;
        int leftMax = query(start, mid, 2 * node, left, right);
        int rightMax = query(mid + 1, end, 2 * node + 1, left, right);
        return Math.max(leftMax, rightMax);
    }
}
