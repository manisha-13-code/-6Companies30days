public class incremovableSubarrayCountSolution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(check(nums, i, j)) count++;
            }
        }

        return count;
    }

    public boolean check(int[] nums, int i, int j) {

        int prev = -1;

        for(int k = 0; k < nums.length; k++) {
            
            if(k >= i && k <= j) continue;

            if(prev >= nums[k]) return false;

            prev = nums[k];
        }

        return true;
    }
}
