package questions;

public class bit2151MaximumGoodPeoplBasedonStatements {

public int maximumGood(int[][] A) {
    int n = A.length, ans = 0;
    for (int num = 1 << n; num < 1 << (n + 1); num++) {
        System.out.println(num);
        String permutation = Integer.toBinaryString(num).substring(1);
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (permutation.charAt(i) == '0') continue;
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 2) continue;
                if ((A[i][j] == 1 && permutation.charAt(j) == '0') || (A[i][j] == 0 && permutation.charAt(j) == '1')) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }
        if (flag) {
            int count = 0;
            for (char c: permutation.toCharArray()) 
                if (c == '1') 
                    count++;
            ans = Math.max(ans, count);
        }
    }
    return ans;
}
}
