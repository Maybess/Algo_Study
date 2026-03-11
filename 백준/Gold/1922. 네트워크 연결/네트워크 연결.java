import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int cost = 0;
        int edge = 0;

        for (int i = 0; i < m; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int weight = edges[i][2];
            if (find(a) != find(b)) {
                union(a, b);
                cost += weight;
                edge++;
            }
            if (edge == n - 1)
                break;
        }
        System.out.println(cost);

    }

}
