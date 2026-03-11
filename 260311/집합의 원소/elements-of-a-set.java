import java.util.Scanner;

public class Main {
    static int[] parent; 
    public static int find(int x) {
        if (parent[x] == x) return x; 
        return parent[x] = find(parent[x]); 
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int qType = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (qType == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}