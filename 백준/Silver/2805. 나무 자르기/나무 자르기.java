import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if (max < a[i]) {
                max = a[i];
            }
        }

        long low = 0;
        long high = max;
        long answer = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] > mid) {
                    sum += (a[i] - mid);
                }
            }

            if (sum >= m) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}