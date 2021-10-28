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
import java.awt.Graphics;
import java.util.ArrayList;



/**
 *
 * @author khali
 */
public class Vertex {
    private Object o;
    private Vector pos, vel, acc, posToDraw;
    private Color color;

    public Vertex(Object o){
        this.o = o;
        this.pos = new Vector((int) (100 + Math.random() * 1000), 100+(int) (Math.random() * 1000));
        this.vel = new Vector(0,0);
        this.acc = new Vector(0,0);
    }
    
    public Vector calcForce (ArrayList<Vertex> vertices){
        Vector result = new Vector();
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) != this){
                
                Vector aux = this.pos.sub(vertices.get(i).pos);
                double aux2 = 10 / Math.pow(aux.size(), 2);
                
                aux = aux.unit().mul(aux2);
                result = result.add(aux);
            }
        }
        acc = this.acc.add(result);
        return result;
    }
    
    public Vector calcForceEdge(ArrayList<Edge> ejes){
        Vector result = new Vector();
        for (int i = 0; i <ejes.size() ; i++) {
            Vector aux = ejes.get(i).getForce(this);
            result = result.add(aux);
        }
        acc = this.acc.add(result);
        return result;
    }
    
    public void updatePosition(){
        vel.add(acc);
        pos.add(vel);
        vel = vel.mul(0.99);
    }
    
    public void draw(Graphics g){
        String name="";
        if(o instanceof User){
            User u = (User)o;
            g.setColor(Color.green);
            name = "Usuario";
        }else if(o instanceof Wallet){
            Wallet w = (Wallet)o;
            g.setColor(Color.blue);
            name = "Billetera";
        }else if(o instanceof Block){
            Block b = (Block)o;
            g.setColor(Color.magenta);
            name = "Bloque";
        }else if(o instanceof Transaction){
            Transaction t = (Transaction)o;
            g.setColor(Color.cyan);
            name = "Transacción";
        }else if(o instanceof State){
            State e = (State)o;
            g.setColor(Color.pink);
            name = "Estado";
        }
        
        g.fillOval((int)(posToDraw.getX()-20), (int)(posToDraw.getY()-20), 40, 40);
        g.setColor(Color.black);
        g.drawString(name, (int)(posToDraw.getX()-20), (int)(posToDraw.getY()-20));
    }
    
    
    public Vector getCentroid(ArrayList<Vertex> vertices){
        double sx = 0, sy = 0;
        for (int i = 0; i < vertices.size(); i++) {
             sx += vertices.get(i).posToDraw.getX();
             sy += vertices.get(i).posToDraw.getY();
        }
        return new Vector (sx/vertices.size(), sy/vertices.size());
    }
    
    public Object getO(){
        return o;
    }
    
    public void setPosToDraw(Vector v){
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

    public Color getColor() {
        return color;
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
