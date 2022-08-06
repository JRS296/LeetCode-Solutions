class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<(m+n); i++)
        {
            if(i>=m)
            {
                // System.out.println(nums1[i]);
                // System.out.println(nums2[i-m]);
                nums1[i]=nums2[i-m];
            }
        }
        
        for(int i=0; i<m+n; i++)
        {
            for(int j=i; j<m+n; j++)
            {
                if(nums1[i]>nums1[j])
                {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }
}