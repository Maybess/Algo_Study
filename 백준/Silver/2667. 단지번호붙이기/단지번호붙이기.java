import java.util.*;

public class Main {
    static int n;
    static int[][] a;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        a = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] row = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                a[i][j] = row[j] - '0';
            }
        }

        int townNum = 2; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    dfs(i, j, townNum);
                    townNum++; 
                }
            }
        }

       
        int totalTowns = townNum - 2;
        int[] counts = new int[totalTowns];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] >= 2) {
                    counts[a[i][j] - 2]++;
                }
            }
        }

        Arrays.sort(counts);
        System.out.println(totalTowns);
        for (int count : counts) {
            System.out.println(count);
        }
    }


    static void dfs(int r, int c, int townNum) {
        a[r][c] = townNum;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                if (a[nr][nc] == 1) {
                    dfs(nr, nc, townNum);
                }
            }
        }
    }
}