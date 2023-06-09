//Attempt #1 - 5mins?
//Link: https://leetcode.com/problems/reverse-integer/description/

class Solution {
    public int reverse(int x) {
        long finalNum = 0;
        while(x!=0){
            int lastDig = x%10;
            finalNum += lastDig;
            finalNum = finalNum*10;
            x= x/10;
        }
        finalNum = finalNum/10;
        if(finalNum > Integer.MAX_VALUE || finalNum<Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            return (int)(-1*finalNum);
        }
        return (int)finalNum;
    }
}

/*
TC - O(n)
SC - O(1)
 */

//Another Solution

class Solution2 {
    public int reverse(int x) {
        int ans = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        
        while(x!=0){ //When all digits are popped from x(using x/10), x will become 0 and loop will stop
            int lastDigit = x%10; //Extracting last digit
            x = x/10; //Removing last digit from x
            
            
            //ans can be very large from max value, so first condition; ans/10 can be equal to max/10 and lastdigit of ans can be larger than last digit of max so second condition.
            if( (ans>max/10) || (ans==max/10 && lastDigit>7) ){
                return 0;
            }
            //Same is true for min value
            if( (ans<min/10) || (ans==min/10 && lastDigit<-8) ){
                return 0;
            }
            
            ans = ans*10 + lastDigit; //Appending lastDigit to ans
        }
        
        return ans;
    }
}