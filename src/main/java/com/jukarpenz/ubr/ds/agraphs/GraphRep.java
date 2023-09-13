package com.jukarpenz.ubr.ds.agraphs;

import java.util.*;

public class GraphRep {

    int v;
//    int [] adj [] ;
    //store vertex pointers
    int [][] adj  ;
    List<Integer> adjL [];
    boolean [] visited;

    public void addEdge(int idx, int ... pointers){
        int ps [] = Arrays.copyOf(pointers, pointers.length);
        adj[idx]=ps;
    }

    void addEdgeD(int vx, int w){
        this.adjD[vx].add(w);
    }

    public GraphRep(int v){
        this.v = v;
        this.visited = new boolean[v];
//        int [][] adj = new int[this.v][];
        this.adj = new int[this.v][];

        this.adjD = new LinkedList[v];
        for(int i=0; i<v; i++){
            this.adjD[i]=new LinkedList<Integer>();
        }
//        for(int i=0;i<this.v;i++){
//
//        }
    }

    public static void main(String[] args) {
        GraphRep g = new GraphRep(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int v = 4;
        int start = 0;

        g = new GraphRep(v);
        g.addEdge(0, 1,2);
        g.addEdge(1, 2);
//        g.addEdge(2, 0,3);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        v=4;start=2;
        g=new GraphRep(v);
        g.addEdge(0, 1,2);
        g.addEdge(1, 2);
        g.addEdge(2, 0,3);
        g.addEdge(3, 3);
        //g.bfs(start);



        int nvs = 9;
        int s=4;
        g=new GraphRep(nvs);

        g.addEdgeD(0,1);
        g.addEdgeD(0,5);
        g.addEdgeD(0,6);
        g.addEdgeD(1,3);
        g.addEdgeD(1,4);
        g.addEdgeD(1,5);
        g.addEdgeD(4,2);
        g.addEdgeD(4,6);
        g.addEdgeD(6,0);

        //g.visited = new boolean[nvs];
        g.dfs(s);

        System.out.println();

        v=4;
        g=new GraphRep(v);
        g.addEdgeD(0, 1);
        g.addEdgeD(0, 2);
        g.addEdgeD(1, 2);
        g.addEdgeD(2, 0);
        g.addEdgeD(2, 3);
        g.addEdgeD(3, 3);
        g.dfs(0);

        System.out.println();

        v=5;
        g=new GraphRep(v);
//        g.addEdge(0,1);
//        g.addEdge(0,2);
        g.addEdge(0,1);
        g.addEdge(1);
//        g.addEdge(2,4);
        g.addEdge(2,0,4,3);
        g.addEdge(3);
        g.addEdge(4);
//        g.dfs(2);
        System.out.println();
        g.bfs(0);
    }


    void dfs(int s){
        visited[s]=true;
        System.out.print(s + " ");
        LinkedList<Integer> vxNeightboors=adjD[s];
        for (Integer n:vxNeightboors) {
            if(visited[n]==false){
               dfs(n);
            }
        }
    }

//0 1 3 4 2 6 5
    void dfs0(int s){

        Stack<Integer> st = new Stack<Integer>();
        st.push(s);
//        visited[s]=true;

        while(!st.isEmpty()){
            int vx = st.pop();
            if(visited[vx]==true){
//                continue;
            }
            System.out.print(vx + " " );

            if(!adjD[vx].isEmpty()){
                Integer nv = adjD[vx].poll();
                if(visited[nv]==false){
                    st.push(nv);
//                    System.out.println("pushing: "+nv);
                    visited[nv]=true;
                    dfs(nv);
                }
            }
        }

    }

//    Stack<Integer> st;
    private LinkedList<Integer> adjD [];
    void dfsEdge(int edgeIndex){
        if(visited[edgeIndex]==true){
            System.out.println("skept idx: " + edgeIndex);
            return;
        }
        System.out.println("Visiting idx: " + edgeIndex);
        visited[edgeIndex]=true;
    }

    void bfs(int start){
        int c=0;
//        for(int [] ed:this.adj){
//            System.out.print(c++ + " -> ");
//            for(int p:ed){
//                System.out.print(p+" ");
//            }
//            System.out.println();
//        }

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int vx = q.poll();
//            System.out.print(vx+"("+visited[vx]+") ");
            System.out.print(vx+" ");
            for(int ps:this.adj[vx]){
//                System.out.println(vx+": "+ ps);
                if(visited[ps]==false){
                    visited[ps]=true;
                    q.add(ps);
                }
            }
        }
    }

}
