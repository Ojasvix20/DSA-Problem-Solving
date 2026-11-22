class Solution {
    public String[] assignUmbrella(int[] rain) {
        int alice = 0, bob = 0, n = rain.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            if (rain[i] == 0) {
                ans[i] = "None";
                continue;
            } else {

                //check if alice needs
                if (i < n - 1 && rain[i] == rain[i + 1]) {
                    if (alice == bob) {
                        ans[i] = "Alice";
                        alice++;
                        continue;
                    } else {
                        if (alice < bob) {
                            ans[i] = "Alice";
                            alice++;
                            continue;
                        } else {
                            ans[i] = "Bob";
                            bob++;
                            continue;
                        }
                    }
                }
                //bob needs for sure
                ans[i] = "Bob";
                bob++;
            }
        }
        return ans;
    }
}