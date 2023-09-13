package com.jukarpenz.ubr.ds.agraphs;

import java.util.*;

public class Graph {

    private int v;

    private LinkedList<Integer> adj[];

    public Graph(int v){
        this.v=v;
        adj= new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i]=new LinkedList();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void BFS(int s){

        System.out.print("Starting point: ");
        System.out.println(adj[s]);

        boolean visited [] = new boolean[this.v];
        Queue<Integer> queue = new LinkedList<Integer>();
//        Queue<Integer> qr = new LinkedList<Integer>();
        //q.

        visited[s]=true;
        queue.add(s);


        while(queue.size()!=0){
            s=queue.poll();
            System.out.print(s+ " ");

            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {

        int f = 'N';

        System.out.println(f);
        System.out.println(f=='N');


        if(true) return;

        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("""
                Following is Breath First Traversal (starting from vx2)
                """);

//        g.adj.strea
        Arrays.stream(g.adj).forEach(System.out::print);
        System.out.println();
        for (LinkedList<Integer> li:g.adj){
            System.out.println(li);
        }
        for (int i = 0; i < g.adj.length; i++) {
            System.out.println("Vx " + (i+0) + " -> " + g.adj[i]);
        }

//        System.out.println();
        g.BFS(0);

//        ArrayList<Boolean> vis [] = new ArrayList<Boolean>()[g.v];
//        Graph2.bfsOfGraph(g.v,vis);
    }



}


class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node node)
    {
        List<Integer> levels =  new ArrayList<Integer>();

        ArrayList<Integer> ord = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        Node currentNode=null;//queue.poll();

        while(queue!=null && !queue.isEmpty()){
            currentNode=queue.poll();
            ord.add(currentNode.data);
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }

        return ord;
    }

    public class Solution2 {
        static int prevNode = -1;

        //Function to check whether a Binary Tree is BST or not.
        boolean isBST(Node root) {

            if (root.left != null) {
                boolean ln = root.left.data == 'N';
                if (!ln && (root.left.data >= root.data || root.left.data >= prevNode)) {
                    return false;
                }
                if (!ln && isBST(root.left) == false) {
                    return false;
                }
            }

            if (root.right != null) {
                boolean rn = root.right.data == 'N';
                if (!rn && (root.right.data <= root.data || root.right.data <= prevNode)) {
                    return false;
                }
                if (!rn && isBST(root.right) == false) {
                    return false;
                }
                ;
            }
            prevNode = root.data;
            return true;
        }
    }
}