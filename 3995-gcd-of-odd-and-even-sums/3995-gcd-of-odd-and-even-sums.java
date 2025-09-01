class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddSum = n*n;
        int evenSum = n*(n+1);

        int res = gcd(oddSum,evenSum);
        return res;
    }

    private int gcd(int a, int b) {
        while(b!=0) {
            int temp = b;
            b =a%b;
            a=temp;
        }
        return a;
    }
}