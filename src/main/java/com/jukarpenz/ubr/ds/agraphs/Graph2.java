package com.jukarpenz.ubr.ds.agraphs;

import java.util.*;

public class Graph2 {

    public static ArrayList<Integer> bfsOfGraph(int v, ArrayList<Boolean> adj[]){
        ArrayList<Boolean> vis = new ArrayList<Boolean>(v);
        ArrayList<Integer> bfs_traversal = new ArrayList<Integer>();

        for(int i=0;i<v; ++i){
            Queue<Integer> q = new LinkedList<Integer>();
            vis.set(i,true);
            q.add(i);

            while(!q.isEmpty()){
                int gNode=q.poll();
                //q.peek();
//                q.poll();
                bfs_traversal.add(gNode);
                for(int it=0;it<adj[gNode].toArray().length;it++){
                    if(adj[gNode].get(it)==true){
                        if(vis.get(it)==true){
                            vis.set(it,true);
                            q.add(it);
                        }
                    }
                }
            }
        }
        return bfs_traversal;
    }

    private int nv;
    private LinkedList<Integer> adj [];

    Graph2(int v){
        this.nv=v;
        adj = new LinkedList[v];
        for(int i =0;i<v;i++){
            adj[i]=new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }
    void bfs (int s, boolean[] vis){
//        System.out.print(v+" ");
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
//        vis[v]=true;

        while(!q.isEmpty()){
            int currentVertex = q.poll();
            if(vis[currentVertex]==true){
//                System.out.println("\nVertex " + currentVertex + " already visited");
                continue;
            }
            vis[currentVertex]=true;
            System.out.print(currentVertex + " ");
//            for (int vi:adj[cv]) {
            for(int ajdIdx=0;ajdIdx<adj[currentVertex].toArray().length;ajdIdx++){
                //get adj from current vertex cv
                int currVxIdxAdj = adj[currentVertex].get(ajdIdx);
                //check if visited
                if(vis[currVxIdxAdj]==false){
                    q.add(adj[currentVertex].get(ajdIdx));
                }
            }
        }
    }

    void dfs(int s, boolean[] visited){

//        Queue<Integer> q = new LinkedList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        st.push(s);

        int lastVisited=-1;
        while(!st.isEmpty()){
            int cv = st.pop();
            if(visited[cv]==false){
                //TODO whatever you want with it
                System.out.print(cv + " ");
            }
            visited[cv]=true;
            lastVisited=cv;
            //get first child
            Integer nv = this.adj[cv].poll();
            if(nv!=null){
                dfs(nv,visited);
                if(nv>0){
                    st.push(lastVisited);
                }
            }
        }

    }

    public static void main(String[] args) {

//        LinkedList<Integer> li = new LinkedList<Integer>();
//        int gd = li.poll() != null ? li.poll() : 0;
//        System.out.println(gd);
//        li.add(0);
//        li.add(0);
//        li.add(1);
//        li.add(2);
//        li.add(3);
//        li.add(1);
//
//        System.out.println(li);
//        gd = li.poll() != null ? li.poll() : 0;
//        System.out.println(gd);
//        System.out.println(li);
//        System.out.println(li.poll());
//        System.out.println(li.poll());
//        System.out.println(li.poll());
//        System.out.println(li.poll());
//        System.out.println(li);
//        if(true) return;


        int nvs = 4;
        Graph2 g = new Graph2(nvs);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);


        //BFS
        g=new Graph2(nvs);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);


        int s=2;
        System.out.println("Starting at " + s);

        boolean [] visited = new boolean[nvs];
//        g.bfss(s, visited);

        nvs = 9;
        s=0;
        g=new Graph2(nvs);

        g.addEdge(0,1);
        g.addEdge(0,5);
        g.addEdge(0,6);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(1,5);
        g.addEdge(4,2);
        g.addEdge(4,6);
        g.addEdge(6,0);

        visited = new boolean[nvs];
        g.dfs(s, visited);

//        s=1;
//        System.out.println();;
//        System.out.println("Starting at " + s);
//        g.dfss(s);
//
//        s=0;
//        System.out.println();;
//        System.out.println("Starting at " + s);
//        g.dfss(s);
//        System.out.println();;
//        g.dfss(s);

    }

    void bfss(int s, boolean [] visited){
//        System.out.println(visited.length);
//        System.out.println(Arrays.stream(visited.));
        bfs(s,visited);
        System.out.println();
        //support unplugged nodes
        for (int i=0; i<visited.length;i++) {
            boolean vn = visited[i];
            System.out.println("Vx["+i+"]: " + vn);
            if(vn==false){
                bfss(i,visited);
            }
        }
    }


    void dfss(int s, boolean [] visited){
        dfs(s,visited);
        System.out.println();
        //support unplugged nodes
        for (int i=0;1==0 && i<visited.length;i++) {
            boolean vn = visited[i];
            System.out.println("Vx["+i+"]: " + vn);
            if(vn==false){
                bfss(i,visited);
            }
        }
    }


}

