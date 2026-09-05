class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int currMax = -1;
        int res = 0, max =0;

        for(int i=0; i<nums.length;i++){
            currMax = Math.max(currMax, nums[i]);

            if(i == res) max = currMax;

            if(nums[i] < max-k) res = i+1;
        }
        return res < nums.length ? res : -1;
    }
}