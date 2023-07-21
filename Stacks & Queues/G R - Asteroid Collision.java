//Attempt #1 - 30mins
//Link: https://leetcode.com/problems/asteroid-collision/description/

//2 ptr approach

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int i=1;
        for(int j=1; j<asteroids.length; j++) {
            while(i>0 && asteroids[i-1]>0 && asteroids[i-1]<-asteroids[j]) {
                i--;
            }
            if(i==0 || asteroids[i-1]<0 || asteroids[j]>0) asteroids[i++]=asteroids[j];
            else if(asteroids[i-1]==-asteroids[j]) i--;
        }
        int[] ret=new int[i];
        for(int j=0; j<i; j++) {
            ret[j]=asteroids[j];
        }
        return ret;
    }
}

//Stack appraoch

/*
 a. If the `asteroid` is bigger than the asteroid on the top, then this asteroid on the top will explode, and we will pop it from the stack.
 b. If the `asteroid` has the same size as the asteroid on the top, then both will explode. Hence we will pop it from the stack; also, we will mark `flag` as `false` because this `asteroid` will also explode, and hence we won't save it into the stack.
 c. If the `asteroid` is smaller than the asteroid on the top, then the asteroid on the top will not explode, so we will not pop it. But the `asteroid` will explode and thus we will mark `flag` as `false`.
*/

class Solution2 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<Integer>();

        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!st.isEmpty() && (st.peek() > 0 && asteroid < 0)) {
                // If the top asteroid in the stack is smaller, then it will explode.
                // Hence pop it from the stack, also continue with the next asteroid in the stack.
                if (Math.abs(st.peek()) < Math.abs(asteroid)) {
                    st.pop();
                    continue;
                }
                // If both asteroids have the same size, then both asteroids will explode.
                // Pop the asteroid from the stack; also, we won't push the current asteroid to the stack.
                else if (Math.abs(st.peek()) == Math.abs(asteroid)) {
                    st.pop();
                }

                // If we reach here, the current asteroid will be destroyed
                // Hence, we should not add it to the stack
                flag = false;
                break;
            }

            if (flag) {
                st.push(asteroid);
            }
        }

        // Add the asteroids from the stack to the vector in the reverse order.
        int[] remainingAsteroids = new int[st.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = st.peek();
            st.pop();
        }

        return remainingAsteroids;
    }
}

