class Solution {
    public int minInsertions(String s) {
        int res =0,x=0 ;
        int n = s.length();

        for(int i=0; i<n; ++i){
            if(s.charAt(i) == '(') {
                ++x;
            } else {
                if(i < n-1 && s.charAt(i + 1) == ')'){
                    ++i;
                }
                else{
                    ++res;
                }
                if( x == 0){
                    ++res;
                }
                else{
                    --x;
                }
            }
        }
        res += x << 1;
        return res;
    }
}