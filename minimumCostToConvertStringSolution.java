import java.util.*;
public class minimumCostToConvertStringSolution {
    int charCount = 26;
    int INF = Integer.MAX_VALUE / 2;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] graph = buildConversionGraph(original, changed, cost);
        optimizePathGraph(graph);
        return computeTotalConversionCost(source, target, graph);
    }

    public int[][] buildConversionGraph(char[] original, char[] changed, int[] cost) {
        int[][] graph = new int[charCount][charCount];
        for (int[] it : graph) {
            Arrays.fill(it, INF);
        }
        for (int i = 0; i < charCount; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < cost.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            graph[from][to] = Math.min(graph[from][to], cost[i]);
        }
        return graph;
    }

    public void optimizePathGraph(int[][] graph) {
        for (int k = 0; k < charCount; k++) {
            for (int i = 0; i < charCount; i++) {
                if (graph[i][k] < INF) {
                    for (int j = 0; j < charCount; j++) {
                        if (graph[k][j] < INF) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }

            }
        }
    }

    public long computeTotalConversionCost(String source, String target, int[][] graph) {
        long totalCost = 0;

        for(int i = 0; i < source.length(); i++) {
             int sourceChar = source.charAt(i) - 'a';
            int targetChar = target.charAt(i) - 'a';
            if (sourceChar != targetChar) {
                if (graph[sourceChar][targetChar] == INF) {
                    return -1L;
                }
                totalCost += graph[sourceChar][targetChar];
            }
        }
        return totalCost;
        }
}
