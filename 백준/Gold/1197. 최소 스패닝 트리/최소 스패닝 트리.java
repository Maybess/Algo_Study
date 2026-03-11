import java.io.*;
import java.util.*;

public class Main  
{
 static int[] parent;

    public static int find(int x)
    {
        if(parent[x]==x)
        {
            return x;
        }
        return parent[x]= find(parent[x]);
    }

    public static void union(int a,int b)
    {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!=rootB)
            parent[rootB]=rootA;
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int V= sc.nextInt();
        int E= sc.nextInt();

        int [][] edges =new int[E][3]; //시작 끝 가중치
        for (int i=0; i<E;i++)
        {
            edges[i][0] =sc.nextInt();
            edges[i][1]=sc.nextInt();
            edges[i][2]= sc.nextInt();
        }

        Arrays.sort(edges,(o1,o2)->o1[2]-o2[2]);


        parent= new int[V+1];
        for (int i = 1; i <=V;i++)
            parent[i]=i;

        long totalweight=0;
        int edgecnt=0;

        for(int i = 0; i<E; i++)
        {
            int start = edges[i][0];
            int end = edges[i][1];
            int weight= edges[i][2];
            if (find(start)!=find(end))
            {
                union(start, end);
                totalweight += weight;
                edgecnt++;


                if(edgecnt==V-1)break;
            }
        }

        System.out.println(totalweight);



    }   

}


