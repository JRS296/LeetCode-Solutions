import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    /*
     * Complete the 'getMaximumGreyness' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY pixels as parameter.
     */

    public static int getMaximumGreyness(List<String> pixels) {
    // Write your code here
        
        HashMap<String, Integer> mp = new HashMap<String, Integer>();
        
        int ans = -9999;
        System.out.println(pixels);
        int b = pixels.get(0).length();
        int l = pixels.size();
        
        int arr[][] = new int[l][b];
        
        for(int i=0; i<l; i++)
        {
            for(int j=0; j<b; j++)
            {
                int x = Integer.parseInt(String.valueOf(pixels.get(i).charAt(j)));
                
                arr[i][j] = x;
                System.out.println(arr[i][j]);
                
                int grey = greyness(arr, l, b, i, j);
                System.out.println(grey);
            }
        }
        
        
        
        return ans;
    }
    public static int greyness(int[][] arr, int l, int b, int e, int f)
    {
        int ans = 0;
        ArrayList<Integer> s0r = new ArrayList<Integer>(l);
        ArrayList<Integer> s1r = new ArrayList<>(l);
        ArrayList<Integer> s0c = new ArrayList<>(b);
        ArrayList<Integer> s1c = new ArrayList<>(b);
        
        for(int i=0; i<l; i++)
        {
            for(int j=0; j<b; j++)
            {
                
                if(arr[i][j]==1)
                {
                    s1r.add(1);
                }
                if(arr[i][j]==0)
                {
                    s0r[i]++;
                }
            }
        }   
        
        for(int j=0; j<b; j++)
        {
            for(int i=0; i<l; i++)
            {
                if(arr[i][j]==1)
                {
                    s1c[j]++;
                }
                if(arr[i][j]==0)
                {
                    s0c[j]++;
                }
            }
        }
        
        System.out.println("greyness vals:" + s1c + " " + s0c + " " + s1r + " " + s0r + " ");
        ans = (s1r[e]+s1c[f])+(s0r[e]+s0c[f]);
        
        return ans;  
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int pixelsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> pixels = new ArrayList<>();

        for (int i = 0; i < pixelsCount; i++) {
            String pixelsItem = bufferedReader.readLine();
            pixels.add(pixelsItem);
        }

        int result = Result.getMaximumGreyness(pixels);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
