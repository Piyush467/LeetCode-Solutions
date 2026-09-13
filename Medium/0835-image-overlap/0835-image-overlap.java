class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        List<int[]> l1 = new ArrayList<>();
        List<int[]> l2 = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(img1[i][j] == 1) l1.add(new int[]{i,j});
                if(img2[i][j] == 1) l2.add(new int[]{i,j});
            }
        }

        int[][] count = new int[2*n][2*n];
        int best = 0;
        for(int[] a: l1){
            for(int[] b : l2){
                int dx = b[0]-a[0] + n;
                int dy = b[1]-a[1] + n;
                best = Math.max(best, ++count[dx][dy]);
            }
        }
        return best;
    }
}