public class niceSubarraysSolution {
    public int niceSubarrays(int[] nums, int k) {
        int l = 0, r = 0;
        int cnt = 0, sum = 0;
        int n = nums.length;

        while(r < n) {
            sum += nums[r] % 2;

            while(sum > k) {
                sum -= nums[l] % 2;
                l++;
            }
            cnt += r - l + 1;
            r++;
        }

        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        return niceSubarrays(nums, k) - niceSubarrays(nums, k - 1);
    }
}
