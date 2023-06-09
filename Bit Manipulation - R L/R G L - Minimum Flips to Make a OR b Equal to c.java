class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        
        // Iterate through the bits of a, b, and c
        while (a > 0 || b > 0 || c > 0) {
            int bit_a = a & 1;  // Get the least significant bit of a
            int bit_b = b & 1;  // Get the least significant bit of b
            int bit_c = c & 1;  // Get the least significant bit of c

            // Check if the least significant bit of c is 0
            if (bit_c == 0) {
                // If c is 0, both a and b should have their corresponding bits as 0
                // Add the sum of bit_a and bit_b to flips to account for the necessary flips
                flips += (bit_a + bit_b);
            } else {
                // If c is 1, at least one of a and b should have its corresponding bit as 1
                if (bit_a == 0 && bit_b == 0) {
                    // If both bit_a and bit_b are 0, increment flips by 1 to indicate the need for a flip
                    flips += 1;
                }
            }

            // Shift bits to the right
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}