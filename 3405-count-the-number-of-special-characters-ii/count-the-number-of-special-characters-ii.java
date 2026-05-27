class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character, Integer> lower = new HashMap<>();
        Map<Character, Integer> upper = new HashMap<>();
        int count=0;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(Character.isLowerCase(c)){
                lower.put(c,i);
            }
            if(Character.isUpperCase(c) && !upper.containsKey(c)){
                upper.put(c,i);
            }
        }
        for(char c: upper.keySet()){
            if(lower.containsKey(Character.toLowerCase(c)) && lower.get(Character.toLowerCase(c)) < upper.get(c)){
                count++;
            }
        }    
        return count;    

    }
}