package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) != null) return false;
        adjList.put(vertex, new ArrayList<String>());
        return true;
    }

    public boolean addEdge(String v1, String v2) {
        ArrayList<String> v1List = adjList.get(v1);
        if (v1List == null) return false;
        ArrayList<String> v2List = adjList.get(v2);
        if (v2List == null) return false;
        v1List.add(v2);
        v2List.add(v1);
        return true;
    }

    public boolean removeEdge(String v1, String v2) {
        ArrayList<String> v1List = adjList.get(v1);
        if (v1List == null) return false;
        ArrayList<String> v2List = adjList.get(v2);
        if (v2List == null) return false;
        adjList.get(v1).remove(v2);
        adjList.get(v2).remove(v1);
        return true;
    }

    public boolean removeVertex(String v1) {
        ArrayList<String> v1List = adjList.get(v1);
        if (v1List == null) return false;
        for (String v2: v1List) {
            ArrayList<String> v2List = adjList.get(v2);
            if (v2List == null) return false;
            v2List.remove(v1);
        }
        adjList.remove(v1);
        return true;
    }

    public void printGraph() {
        System.out.println(adjList);
    }

}
