import java.util.Random;

public class randomPointNonOverlappingRectangle {
    int[] sums;
    Random random = new Random();
    int[][] globalRect;
    public randomPointNonOverlappingRectangle(int[][] rects) {
        globalRect = rects;
        int sum = 0;
        int i = 0;
        sums = new int[rects.length];
        for(int[] rect : globalRect) {
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            sums[i++] = sum;
        }
    }
    
    public int[] pick() {
        int target = random.nextInt(sums[sums.length - 1]);
        int low = 0;
        int high = sums.length - 1;

        while(low < high) {
            int mid = low + (high - low)/2;
            if(sums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }   
        }

        return pickRect(globalRect[low]);
    }    

    private int[] pickRect(int[] rect) {
        int x1 = rect[0];
        int x2 = rect[2];
        int y1 = rect[1];
        int y2 = rect[3];

        return new int[]{random.nextInt(x2 - x1 + 1), random.nextInt(y2 - y1 + 1)};
    }   
}
