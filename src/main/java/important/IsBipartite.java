package important;

import org.junit.jupiter.api.Test;

public class IsBipartite {
    int RED = 1;
    int GREEN = 2;
    int UN_COLOR = 0;
    private static boolean result;
    private static int[] color;

    @Test
    public void test() {
        int[][] graph = {{4}, {}, {4}, {4}, {0, 2, 3}};
        System.out.println(isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {
        result = true;
        color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == UN_COLOR) {
                dfs(i, RED, graph);
            }
        }

        return result;
    }


    private void dfs(int note, int c, int[][] graph) {
        color[note] = c;
        for (int j = 0; j < graph[note].length; j++) {
            if (color[graph[note][j]] == c) {
                result = false;
                return;
            } else if (color[graph[note][j]] == UN_COLOR) {
                int nC = color[note] == RED ? GREEN : RED;
                dfs(graph[note][j], nC, graph);
            }
        }
    }

}
