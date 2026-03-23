import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static int[] op = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int result, int index) {
        if (index == N) {
            MAX = Math.max(MAX, result);
            MIN = Math.min(MIN, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch (i) {
                    case 0:
                        dfs(result + num[index], index + 1);
                        break;
                    case 1:
                        dfs(result - num[index], index + 1);
                        break;
                    case 2:
                        dfs(result * num[index], index + 1);
                        break;
                    case 3:
                        dfs(result / num[index], index + 1);
                        break;
                }

                op[i]++;
            }
        }
    }
}