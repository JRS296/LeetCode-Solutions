import java.util.HashSet;

class Solution {
    public boolean checkIfExist(int[] arr) {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr.length; j++)
            {
                if(i==j)
                {
                    continue;
                }
                System.out.println(arr[i]+" "+arr[j]);
                if(arr[i]==arr[j]*2)
                {
                    return true;
                }
            }
        }
        return false;
    }
}

/*
Runtime: 688 ms
Memory Usage: 62.5 MB

Therefore, not at all optimal
 */

class Solution2 {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> store = new HashSet<Integer>();
        
        for (int i = 0; i < arr.length; i++) {
            if (store.contains(2 * arr[i]) || (arr[i] % 2 == 0 && store.contains(arr[i] / 2))) return true;
            store.add(arr[i]);
        }
        return false;
    }
}
 
 /*
Runtime: 3 ms
Memory Usage: 43.6 MB
Much more efficient (using Hashsets)
  */