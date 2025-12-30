import java.time.Year;
class Solution {
    public int dayOfYear(String date) {

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int date1 = Integer.parseInt(date.substring(8, 10));
        int ans = 0;
        for (int i = 1; i < month; i++) {
            if (i == 2) {
                ans += 28;
            } else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                ans += 31;
            } else {
                ans += 30;
            }
        }

        if (Year.of(year).isLeap() && month>2) {
            ans+=1;
        }
        ans+=date1;

        return ans;
    }
}