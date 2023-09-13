package com.jukarpenz.ubr.ds.agraphs;

import java.util.LinkedList;

public class GraphGPT {
    private int V;
    private LinkedList<Integer>[] adj;

    public GraphGPT(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public void dfs(int source) {
        boolean[] visited = new boolean[V];
        dfsUtil(source, visited);
    }

    private void dfsUtil(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfsUtil(v, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphGPT g = new GraphGPT(9);
        g.addEdge(0,1);
        g.addEdge(0,5);
        g.addEdge(0,6);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(1,5);
        g.addEdge(4,2);
        g.addEdge(4,6);
        g.addEdge(6,0);
        g.dfs(0);
    }
}