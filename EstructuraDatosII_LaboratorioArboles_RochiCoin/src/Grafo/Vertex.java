/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.vecmath.Vector2d;

/**
 *
 * @author khali
 */
public abstract class Vertex {
    private Vector2d pos, vel, acc;
    private Color c;
    
    public Vertex(Vector2d pos, Color c){
        this.pos = pos;
        this.vel = new Vector2d(0,0);
        this.acc = new Vector2d(0,0);
        this.c = c;
    }
    
    public void accelerate(Vector2d f){
        this.acc.add(f);
    }
    
    public void updatePosition(){
        vel.add(acc);
        pos.add(vel);
        acc.set(0,0);
    }
    
    public void draw(Graphics2D g){
        g.setColor(c);
        
        g.drawOval((int)pos.x, (int)pos.y, 30, 30);
    }
}
