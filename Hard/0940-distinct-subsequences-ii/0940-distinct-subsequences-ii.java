class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] endsWith = new long[26];
        long ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            
            long newForCh = (ans + 1) % MOD;
            
            ans = (ans - endsWith[idx] + newForCh) % MOD;
            if (ans < 0) {
                ans += MOD;
            }
            
            endsWith[idx] = newForCh;
        }
        
        return (int) ans;
    }
}