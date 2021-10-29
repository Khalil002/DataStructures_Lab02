/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import System.Block;
import System.Transaction;
import System.User;
import System.Wallet;
import System.State;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;


/**
 *
 * @author khali
 */
public class Vertex {
    private Object o;
    private Vector pos, vel, acc, posToDraw;

    public Vertex(Object o){
        this.o = o;
        this.pos = new Vector((int) (300 + Math.random() * 300 - 150), 300 + (int) (Math.random() * 300 - 150));
        this.vel = new Vector(0, 0);
        this.acc = new Vector(0, 0);
        this.posToDraw = new Vector(0, 0);
    }
    
    public void updatePosition() {
        vel.add(acc);
        pos.add(vel);
        vel = vel.mul(0.99);
    }
    
    public void Draw(Graphics2D g){
        String name = "";
        if(o instanceof User){
            User u = (User)o;
            name = "Usuario";
            g.setColor(Color.yellow);
        }else if(o instanceof Wallet){
            Wallet w = (Wallet)o;
            name = "Billetera";
            g.setColor(Color.green);
        }else if(o instanceof Block){
            Block b = (Block)o;
            name = "Bloque";
            g.setColor(Color.cyan);
        }else if(o instanceof Transaction){
            Transaction t = (Transaction)o;
            name = "Transacción";
            g.setColor(Color.blue);
        }else if(o instanceof State){
            State e = (State)o;
            name = "Estado";
            g.setColor(Color.pink);
        }
        g.fillOval((int) (this.posToDraw.getX() - 20), (int) (this.posToDraw.getY() - 20), 40, 40);
        g.setColor(Color.black);
        g.drawString(name, (int) (this.posToDraw.getX() - 20), (int) (this.posToDraw.getY() - 20));
    }
    
    public Object getO(){
        return o;
    }
    
    public Vector getCentroid(ArrayList<Vertex> vertices) {
        double sx = 0, sy = 0;
        for (int i = 0; i < vertices.size(); i++) {
            sx += vertices.get(i).posToDraw.getX();
            sy += vertices.get(i).posToDraw.getY();
        }
        return new Vector(sx / vertices.size(), sy / vertices.size());
    }
    
    public Vector calcForceEdge(ArrayList<Edge> ejes) {
        Vector result = new Vector();
        for (int i = 0; i < ejes.size(); i++) {
            Vector aux = ejes.get(i).getForce(this);
            result = result.add(aux);
        }
        acc = this.acc.add(result);
        return result;
    }
    
    public Vector calcForce(ArrayList<Vertex> vertices) {
        Vector result = new Vector();
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) != this) {

                Vector aux = this.pos.sub(vertices.get(i).pos);
                double aux2 = 10 / Math.pow(aux.size(), 2);

                aux = aux.unit().mul(aux2);
                result = result.add(aux);
            }
        }
        acc = this.acc.add(result);
        return result;
    }
    
    public void setPosToDraw(Vector v) {
        posToDraw = v;
    }

    public Vector getPos() {
        return pos;
    }

    public Vector getVel() {
        return vel;
    }

    public Vector getAcc() {
        return acc;
    }

    public Vector getPosToDraw() {
        return posToDraw;
    }

    public void setPos(Vector pos) {
        this.pos = pos;
    }

    public void setVel(Vector vel) {
        this.vel = vel;
    }

    public void setAcc(Vector acc) {
        this.acc = acc;
    }
    
}
