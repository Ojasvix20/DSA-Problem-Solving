class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int[] C = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            for (int j = 0; j <=i; j++) {
                if (set.contains(B[j]))
                    count++;
            }
            C[i] = count;
            count=0;
        }

        return C;
    }
}