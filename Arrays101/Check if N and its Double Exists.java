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