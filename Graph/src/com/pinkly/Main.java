package com.pinkly;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Graph {
    ArrayList<ArrayList<Integer>>graph;
    int vertex;
    int matrix[][];
    Graph(int nodes) {
        vertex = nodes;
        graph = new ArrayList<ArrayList<Integer>>();
        matrix = new int[nodes][nodes];
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<Integer>());
        }
    }
    void addEdge(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
        matrix[a][b] = 1;
        matrix[b][a] = 1;
        System.out.println(a + " , " + b);
    }
    void printGraphLinkedList() {
        System.out.println("\n" + "Output Dalam Bentuk Linked List : " + "\n");
        for (int i = 0; i < vertex; i++) {
            System.out.print("Node : " + i);
            for (int x : graph.get(i)) { 
                System.out.print(" -> " + x);
            }
            System.out.print("\n");
        }
    }
    void printGraphAdjacency() {
        System.out.println("\n" + "Output Dalam Bentuk Matrix : " + "\n");
        for (int i = 0; i < vertex; i++) {
            for (int x = 0; x < vertex; x++) {
                System.out.print(matrix[i][x] + "  ");
            }
            System.out.print("\n");
        }
        System.out.println("\n" + "Node Yang Saling Terhubung : " + "\n");
        for (int i = 0; i < vertex; i++) {
            System.out.print("Node " + i + " Terhubung Ke : ");
            for (int x : graph.get(i)) {
                if (matrix[i][x] == 1) {
                    System.out.print("(" + x + ") ");
                }
            }
            System.out.print("\n");
        }
    }
    void dfsUtil(int node, boolean visited[]) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int x : graph.get(node)) {
            if (visited[x] == false) {
                dfsUtil(x, visited);
            }
        }
    }
    void DFS(int start) {
        boolean visited[] = new boolean[vertex];
        System.out.println("\n" + "DFS Traversal" + "\n");
        dfsUtil(start, visited);
    }
    void BFS(int star) {
        boolean visited[] = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(star);
        System.out.println("\n" + "BFS Traversal" + "\n");
        visited[star] = true;
        while (queue.isEmpty() == false) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int x : graph.get(node)) {
                if (visited[x] == false) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
    }
}
public class Main {
    static void DisplayGraph() {
        System.out.println("Input Edge : " + "\n");
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.printGraphLinkedList();
        graph.printGraphAdjacency();
        graph.DFS(0);
        System.out.print("\n");
        graph.BFS(0);
        System.out.print("\n");
    }
    public static void main(String[] args) {
        System.out.println("\n" + "PROGRAM BY : PINKLY" + "\n");
        DisplayGraph();
        System.out.print("\n");
    }
}
/*
graph.addEdge(0, 1);
        GRAPH 1
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        GRAPH 2
        graph.addEdge(0, 1);
        graph.addEdge(3, 2);
        graph.addEdge(2, 4);
        graph.addEdge(1, 4);
        graph.addEdge(3, 1);
        graph.addEdge(2, 0);
*/