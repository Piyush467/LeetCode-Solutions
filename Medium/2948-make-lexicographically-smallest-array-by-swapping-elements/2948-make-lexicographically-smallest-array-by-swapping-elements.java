class Solution {
    public int[] lexicographicallySmallestArray(int[] A, int limit) {
        int[] a  = A.clone();
        Arrays.sort(a);
        List<List<Integer>> groups = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        int id = -1;

        for(int i=0; i<a.length; i++){
            if(i ==0 || a[i] - a[i-1] > limit) {
                groups.add(new ArrayList<>());
                id++;
            }

            groups.get(id).add(a[i]);
            mp.put(a[i], id);
        }
        int[] idx = new int[groups.size()];

        for(int i=0; i<A.length; i++){
            int curr = mp.get(A[i]);
            A[i]= groups.get(curr).get(idx[curr]);
            idx[curr]++;
        }

        return A;
    }
}