class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int runningSum = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            runningSum += num;
            
            if(map.containsKey(runningSum - k)) {
                res += map.get(runningSum-k);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0)+1);
        }
        
        return res;
    }
}
