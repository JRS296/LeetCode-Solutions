//Attempt #1 

class Solution {
    public int maximumJumps(int[] nums, int target) {
        int ans = 0;
        int i=0;
        int j=0;
        int flag=0;
        for(i=0; i<nums.length-1; i++) {
            j=i+1;
            //System.out.println(i+" "+j);
            while(j<nums.length) {
                int temp = nums[j]-nums[i];
                //System.out.println(nums[j]+" "+nums[i]+" nums");
                if(-target<=temp && temp <= target) {
                    ans++;
                    i=j-1;
                    break;
                } else {
                    j++;
                }
            }
            
            if(j==nums.length-1) flag++;
            
        }
        System.out.println(flag);
        
        
        return (ans==0 || flag==0) ? -1 : ans;
    }
}

//Attempt #2

class Solution2 {
    public int maximumJumps(int[] nums, int target) {
        int dp[]=new int[nums.length];
        
        for(int i=nums.length-2;i>=0;i--){
            int max=0;
            int l=0;
            for(int j=i+1;j<nums.length;j++){
                int fir=nums[j]-nums[i];
                if(fir>=-target && fir<=target){
                    
                    if(j<nums.length-1){
                        int m=dp[j];
                        if(m>max) max=m;
                    }else{
                        if(1>max){
                            max=1;
                            l=1;
                        }
                    }
                }
            }
           
                if(l==1) dp[i]=1;
                else if(max>0) dp[i]=max+1;
            }
        

        return (dp[0]>0) ? dp[0] : -1;
    }
}