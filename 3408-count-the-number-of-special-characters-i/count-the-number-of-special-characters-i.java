class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        int count=0;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(Character.isLowerCase(c)){
                lower.add(c);
            }
            if(Character.isUpperCase(c)){
                upper.add(c);
            }
        }
        for(char c: lower){
            if(upper.contains(Character.toUpperCase(c))) count++;
        }
        return count;
    }
}