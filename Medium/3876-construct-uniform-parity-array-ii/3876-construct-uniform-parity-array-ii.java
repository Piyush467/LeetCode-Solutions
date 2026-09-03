class Solution {
    public boolean uniformArray(int[] nums) {
         int min = nums[0], odd = 0;

        for (int x : nums) {
            min = Math.min(min, x);
            odd |= x & 1;
        }

        return (min & 1) == odd;
    }
}