/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author khali
 */
public class Edge {

    private final Vertex v;
    private final Vertex u;

    public Edge(Vertex v, Vertex u) {
        this.v = v;
        this.u = u;
    }

    public Vertex getV() {
        return v;
    }

    public Vertex getU() {
        return u;
    }  

}
