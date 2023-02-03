//Attempt #1 - 30mins
//Link: https://leetcode.com/problems/verifying-an-alien-dictionary/description/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
        for(int i=0;i<order.length(); i++)
        {
            hmap.put(order.charAt(i),i);
        }
        //System.out.println(hmap);

        for(int i=0; i<words.length-1; i++)
        {
            //System.out.println(words[i]+" "+words[i+1]);
            int l1 = words[i].length();
            int l2 = words[i+1].length();

            if(l1>l2)
                return false;

            for(int j=0; j<l1; j++)
            {
                if(words[i].charAt(j)!=words[i+1].charAt(j))
                {
                    //System.out.println(hmap.get(words[i].charAt(j))+"->"+words[i].charAt(j)+" "+hmap.get(words[i+1].charAt(j))+"->"+words[i+1].charAt(j));
                    if(hmap.get(words[i].charAt(j))>hmap.get(words[i+1].charAt(j)))
                    {
                        return false;
                    }
                    else
                    {
                        break;
                    }
                        //System.out.println("Hello");
                }

                if(j+1==l2)
                    break;
            }
        }
        return true;
    }
}

/*
118 / 120 testcases passed
 */

//Attempt #2 - 10mins

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
        for(int i=0;i<order.length(); i++)
        {
            hmap.put(order.charAt(i),i);
        }
        //System.out.println(hmap);

        for(int i=0; i<words.length-1; i++)
        {
            //System.out.println(words[i]+" "+words[i+1]);
            int l1 = words[i].length();
            int l2 = words[i+1].length();

            if(l1>l2)
            {
                if(words[i].charAt(0)!=words[i+1].charAt(0))
                {
                    if(hmap.get(words[i].charAt(0))>hmap.get(words[i+1].charAt(0)))
                    {
                        return false;
                    }
                    else
                    {
                        break;
                    }
                }
                else
                {
                    return false;
                }
                
            }
                //return false;

            for(int j=0; j<l1; j++)
            {
                if(words[i].charAt(j)!=words[i+1].charAt(j))
                {
                    //System.out.println(hmap.get(words[i].charAt(j))+"->"+words[i].charAt(j)+" "+hmap.get(words[i+1].charAt(j))+"->"+words[i+1].charAt(j));
                    if(hmap.get(words[i].charAt(j))>hmap.get(words[i+1].charAt(j)))
                    {
                        return false;
                    }
                    else
                    {
                        break;
                    }
                        //System.out.println("Hello");
                }

                if(j+1==l2)
                    break;
            }
        }
        return true;
    }
}

/*
108 cases / 120
 */

//Optimal Solution - https://leetcode.com/problems/verifying-an-alien-dictionary/solutions/3129280/easy-beats-100-with-video-java-c-python/

class Solution {
    //Link: https://leetcode.com/problems/verifying-an-alien-dictionary/solutions/3129280/easy-beats-100-with-video-java-c-python/

    int [] orderMap = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        
        for (int i = 0; i < order.length(); i++){
            orderMap[order.charAt(i) - 'a'] = i;
        }
        
        for(int i =1;i< words.length;i++){
            if(!compare(words[i],words[i-1]))return false;
        }
        return true;
        
    }
    
    public boolean compare(String s1, String s2){
        
            int j = 0;
            while(j<s1.length() && j<s2.length()){
                if(s1.charAt(j) == s2.charAt(j)) j++;
                else if(orderMap[s1.charAt(j)-'a']>orderMap[s2.charAt(j)-'a']) return true;
                else return false;
            }
            if(s1.length()<s2.length())return false;
            return true;
        
    }
}


/*
Runtime
0 ms
Beats
100%
Memory
40.9 MB
Beats
81.13%

Time: O(n)
Space: O(1)
 */