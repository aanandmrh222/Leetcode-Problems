class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);
        while(low<=high) {
            int mid = low + (high-low)/2;
            double totalHours = calHours(piles, mid);
            if(totalHours <= h) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    private int findMax(int[] piles) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) max = piles[i];
        }
        return max;
    }
    private double calHours(int[] piles, int k) {
        double hours = 0;
        for (int pile : piles) {
            hours +=  Math.ceil((double)pile / k); 
        }
        return hours;
    }
}
