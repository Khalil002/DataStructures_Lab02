/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
    
    public void Draw(Graphics2D g) {
        g.setColor(Color.black);
        g.drawLine((int)v.getPos().getX(), (int)v.getPos().getY(), (int)u.getPos().getX(), (int)u.getPos().getY());
    }
    
    public Vertex getV() {
        return v;
    }

    public Vertex getU() {
        return u;
    }  

    @Override
    public String toString() {
        return "Edge{" + "v=" + v + ", u=" + u + '}';
    }

    
}
