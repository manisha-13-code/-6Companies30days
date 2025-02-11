import java.util.Arrays;

public class minimumMoveSolution {
     public int minMoves2(int[] nums) {
       Arrays.sort(nums);
       int operations = 0;
       int mid = nums[nums.length / 2];

       for(int num : nums) {
        operations += Math.abs(mid - num);
       }

       return operations; 
    }
}
