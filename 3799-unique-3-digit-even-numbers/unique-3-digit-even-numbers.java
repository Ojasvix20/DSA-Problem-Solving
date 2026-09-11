class Solution {
    static HashSet<Integer> set;

    public int totalNumbers(int[] digits) {
        set = new HashSet<>();
        boolean[] used = new boolean[digits.length];
        solve(digits, 0,0,used); //arr, index, place(ones, tens, hunds), number formed

        return set.size();
    }

    public void solve(int[] digits, int place, int num, boolean[] used) {

        // 3 digits formed
        if (place == 3) {
            set.add(num);
            return;
        }

        for (int i = 0; i < digits.length; i++) {

            // already used this copy of the digit
            if (used[i]) {
                continue;
            }

            // hundreds place cannot be 0
            if (place == 0 && digits[i] == 0) {
                continue;
            }

            // units place must be even
            if (place == 2 && digits[i] % 2 != 0) {
                continue;
            }

            // TAKE
            used[i] = true;

            solve(
                    digits,
                    place + 1,
                    num * 10 + digits[i],
                    used);

            // NOT TAKE / undo
            used[i] = false;
        }
    }

}