package com.jukarpenz.ubr.ds.agraphs;

import java.util.*;

public class GraphD {

    private int v;
    private List<List<iPair>> adj;

    GraphD(int v){
        this.v=v;
        adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w){
        adj.get(u).add(new iPair(v, w));
        adj.get(v).add(new iPair(u,w));
    }

    void shortestPath(int src){
        PriorityQueue<iPair> pq = new PriorityQueue<>(this.v, Comparator.comparingInt(o -> o.first));
        int[]dist=new int[this.v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new iPair(0,src));
        dist[src]=0;

//        while(!pq.contains(src)){
        while(!pq.isEmpty()){
            int u = pq.poll().second;

            for(iPair v:adj.get(u)){
                if(dist[v.first]>dist[u]+v.second){
                    dist[v.first]=dist[u]+v.second;
                    pq.add(new iPair(dist[v.first],v.first));
                }
            }
        }

        System.out.println("Vertex\t\tDistance from source");
        for(int i = 0; i<this.v;i++)
            System.out.println(i+"\t\t"+dist[i]);

    }

    static class iPair{
        int first, second;
        iPair(int f, int s){
            this.first=f;
            this.second=s;
        }
    }

    public static void main(String[] args) {
        int v = 9;
        int src = 0;

        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFS(3);


        if(true)
            return;

        GraphD gd = new GraphD(v);

        gd.addEdge(0, 1, 4);
        gd.addEdge(0, 7, 8);
        gd.addEdge(1, 2, 8);
        gd.addEdge(1, 7, 11);
        gd.addEdge(2, 3, 7);
        gd.addEdge(2, 8, 2);
        gd.addEdge(2, 5, 4);
        gd.addEdge(3, 4, 9);
        gd.addEdge(3, 5, 14);
        gd.addEdge(4, 5, 10);
        gd.addEdge(5, 6, 2);
        gd.addEdge(6, 7, 1);
        gd.addEdge(6, 8, 6);
        gd.addEdge(7, 8, 7);

        gd.shortestPath(src);
    }
}
