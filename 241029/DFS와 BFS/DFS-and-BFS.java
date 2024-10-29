package codetest.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken()) - 1;

        int[][] edges = new int[vertex][vertex];
        for (int i = 0; i < edge; i++) {
            StringTokenizer input_edge = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(input_edge.nextToken()) - 1;
            int v = Integer.parseInt(input_edge.nextToken()) - 1;
            edges[u][v] = 1;
            edges[v][u] = 1;
        }

        boolean[] visitedBfs = new boolean[vertex];
        boolean[] visitedDfs = new boolean[vertex];

        dfs(start, edges, visitedDfs);
        System.out.println();

        bfs(start, edges, visitedBfs);
    }

    private static void dfs(int node, int[][] edges, boolean[] visited) {
        visited[node] = true;
        System.out.print((node + 1) + " ");

        for (int i = 0; i < edges.length; i++) {
            if (edges[node][i] == 1 && !visited[i]) {
                dfs(i, edges, visited);
            }
        }
    }



    private static void bfs(int start, int[][] edges, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print((node + 1) + " ");

            for (int i = 0; i < edges.length; i++) {
                if (edges[node][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}