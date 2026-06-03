class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n= landStartTime.length;
        int m= waterStartTime.length;
        int result = (int)1e9;
        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                int landTime= landStartTime[i]+landDuration[i];
                int landWater = Math.max(landTime,waterStartTime[j]) + waterDuration[j];
                result = Math.min(result, landWater);
            }
        }
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                int waterTime= waterStartTime[i]+waterDuration[i];
                int waterLand = Math.max(waterTime,landStartTime[j]) + landDuration[j];
                result = Math.min(result, waterLand);
            }
        }
        return result;

    }
}