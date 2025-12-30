class Solution {
    public int maximum69Number(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);

        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i)=='6'){
                sb.setCharAt(i, '9');
                break;
            }
        }

        int ans = Integer.parseInt(sb.toString());
        return ans;
    }
}