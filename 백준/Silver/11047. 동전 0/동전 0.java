import java.io.*;
import java.util.*;

public class Main{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int []C = new int[N];
		int cnt = 0;
		int div =0;
		int ans =0;
		for(int i =0;i<N;i++)
		{
			C[i]=sc.nextInt();
			
			if(K<C[i]&&cnt==0)
			{
				cnt=i-1;
			}
			
		}
		if(cnt==0)
		{
			cnt=N-1;
		}
		
	
			for(int i = cnt;i>=0;i--)
			{
				div=K/C[i];
				ans +=div;
				K=K%C[i];
			}
		
		
		System.out.println(ans);
	}
}