package by.amushinsky.algorithms.graph;

import by.amushinsky.algorithms.basic.LinkedListBag;
import by.amushinsky.algorithms.basic.api.Bag;

import java.util.Arrays;

/**
 * Created by Andrei_Mushinsky on 27/09/2016.
 */
public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedListBag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge edge) {
        adj[edge.getSource()].add(edge);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new LinkedListBag<>();
        for (Bag<DirectedEdge> v : adj) {
            for (DirectedEdge e : v) {
                bag.add(e);
            }
        }
        return bag;
    }
}
