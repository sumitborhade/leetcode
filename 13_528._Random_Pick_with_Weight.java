class Solution {

    private int[] rArray;

    public Solution(int[] w) {
        rArray = new int[w.length];
        rArray[0] = w[0];
        
        for(int i=1; i<w.length; i++) {
            rArray[i] = w[i] + rArray[i-1];
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int randomNum = rand.nextInt(rArray[rArray.length-1]) + 1;
        
        int left = 0;
        int right = rArray.length-1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(randomNum == rArray[mid]) {
                return mid;
            } else if(rArray[mid] < randomNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
