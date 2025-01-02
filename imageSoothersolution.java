public class imageSoothersolution {
    public int[][] imageSmoother(int[][] img) {
        
        int m = img.length;
        int n = img[0].length;
        int[][] ans = new int[m][n];
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                cnt = 0;
                int curr = 0;
                for(int dr = -1; dr <= 1; dr++) {
                    for(int dc = -1; dc <= 1; dc++) {
                        int nr = i + dr;
                        int nc = j + dc;

                        if(nr >= 0 && nr < m && nc >= 0 && nc < n) {
                            curr += img[nr][nc];
                            cnt++;
                        }
                    }
                }
                ans[i][j] = (curr)/cnt;
            }
        }

        return ans;
    }
}
