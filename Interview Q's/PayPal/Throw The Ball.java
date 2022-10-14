import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'throwTheBall' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY receiver
     *  2. LONG_INTEGER seconds
     */

    public static int throwTheBall(List<Integer> receiver, long seconds) {
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        int hasBall = 1;
        int targ = -1;
        
        // for(int i = 0; i<receiver.size(); i++)
        // {
        //     targ = receiver.get(i);
        //     if(targ==1)
        //     {
        //         continue;
        //     }
        //     else if(hmap.containsKey(hasBall))
        //     {
        //         continue;
        //     }
        //     else
        //     {
        //         hmap.put(hasBall, targ);
        //         hasBall = targ;
        //     }
        //     System.out.println(hmap);
        // }
        // hmap.put(targ,1);
        // System.out.println(hmap+"&&&");
        
        int ans = -1;
        for(long i=0; i<seconds; i++)
        {
            hmap.put(hasBall,receiver.get(hasBall-1));
            hasBall = receiver.get(hasBall-1);
            
            if(i==seconds-2)
            {
                return hmap.get(hasBall);
            }
        }
        //System.out.println(hmap);
        
        return hmap.get(hasBall);
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int receiverCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> receiver = IntStream.range(0, receiverCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long seconds = Long.parseLong(bufferedReader.readLine().trim());

        int result = Result.throwTheBall(receiver, seconds);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}





public static int throwTheBall(List<Integer> receiver, long seconds) {
    int hasBall = 1;
    for(long i=1; i<=seconds; i++)
    {
        hasBall = receiver.get(hasBall-1);
    }
    return hasBall;
}

//Time Limit Exceeded