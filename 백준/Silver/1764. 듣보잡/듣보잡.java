import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
        }
        
        Arrays.sort(a);
        
        ArrayList<String> result = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
            String b = br.readLine();
            
            if (Arrays.binarySearch(a, b) >= 0) {
                result.add(b);
            }
        }
        
        Collections.sort(result);
        
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}