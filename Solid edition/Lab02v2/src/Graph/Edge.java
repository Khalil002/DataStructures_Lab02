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
        g.drawLine((int) (v.getPosToDraw().getX()), (int) (v.getPosToDraw().getY()), (int) (u.getPosToDraw().getX()), (int) (u.getPosToDraw().getY()));
    }

    public Vector getForce(Vertex toCalc){
        Vector dir;
        if (this.v == toCalc){
            dir = u.getPos().sub(v.getPos());
        } else {
            dir = v.getPos().sub(u.getPos());
        }
        double t = dir.size()-10;
        double ss = Math.signum(t)*Math.log(Math.abs(t))*0.01;
        dir = dir.unit().mul(ss);
        return dir;
    }
    
    public Vertex getV() {
        return v;
    }

    public Vertex getU() {
        return u;
    }  

}
