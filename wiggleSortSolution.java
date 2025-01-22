import java.util.*;
public class wiggleSortSolution {
    public void wiggleSort(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        int left = (n-1)/2;
        int right = n-1;

        int[] temp = nums.clone();

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                nums[i] = temp[left--];
            } else {
                nums[i] = temp[right--];
            }
        }
    }
}
