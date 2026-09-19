class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        // int bill = 5;
        for(int i=0;i<bills.length;i++){
            map.put(bills[i],map.getOrDefault(bills[i],0)+1);
            if(bills[i]==5){
                continue;
            }
            else if(bills[i]==10){
                if(map.get(5)>=1){
                    map.put(5,map.getOrDefault(5,0)-1);
                    continue;
                }else{
                    return false;
                }
            }else if(bills[i]==20){
                if(map.get(10)>=1 && map.get(5)>=1){
                    map.put(10,map.getOrDefault(10,0)-1);
                    map.put(5,map.getOrDefault(5,0)-1);
                    continue;
                }
                else if(map.get(5)>=3){
                    map.put(5,map.getOrDefault(5,0)-3);
                    continue;
                }else{
                    return false;
                }
            }
        }    
        return true;
    }
}