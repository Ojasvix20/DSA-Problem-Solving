class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        //LAND then water:

        int landWater = findFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);

        //Water then land
        int waterLand = findFinishTime(waterStartTime, waterDuration, landStartTime, landDuration);

        return Math.min(landWater, waterLand);
    }

    public int findFinishTime(int[] start1, int[] duration1, int[] start2, int[] duration2) {
        int n = start1.length;
        int m = start2.length;

        int finish1 = (int) 1e9;
        for (int i = 0; i < n; i++) {
            int curr = start1[i] + duration1[i];
            finish1 = Math.min(finish1, curr);
        }
        int finish2 = (int) 1e9;
        for (int i = 0; i < m; i++) {
            finish2 = Math.min(finish2, Math.max(start2[i], finish1) + duration2[i]);
        }
        return finish2;
    }
}