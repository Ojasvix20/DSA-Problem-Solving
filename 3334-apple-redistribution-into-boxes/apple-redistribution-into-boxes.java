class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sumApples = 0;
        for(int a: apple) sumApples+=a;

        Arrays.sort(capacity);
        int curr = 0;
        int boxes = 0;

        //greedy - take largestt box first:

        for(int i = capacity.length-1; i>=0; i--){
            curr +=capacity[i];
            boxes++;

            if (curr >= sumApples) {
                return boxes;
            }
        }
        return boxes;
    }
}