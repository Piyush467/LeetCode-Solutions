class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int curr = 1;

        for(int i=0; i<seq.length(); i++){
            char bracket = seq.charAt(i);

            if(bracket == '(') {
                res[i] = 1-curr;
            } else {
                res[i] = curr;
            }
            curr ^= 1;
        }
        return res;
    }
}