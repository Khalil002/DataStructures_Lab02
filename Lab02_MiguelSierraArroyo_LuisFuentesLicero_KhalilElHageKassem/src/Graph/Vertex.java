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
import javax.vecmath.Vector2d;


/**
 *
 * @author khali
 */
public class Vertex {
    private Object o;
    private Vector2d pos, vel, acc, posToDraw;
    private Color color;

    public Vertex(Object o){
        this.o = o;
        this.pos = new Vector2d((int) (100 + Math.random() * 1000), 100+(int) (Math.random() * 1000));
        this.vel = new Vector2d(0,0);
        this.acc = new Vector2d(0,0);
    }
    
    public Vector2d calcForce (ArrayList<Vertex> nodes){
        Vector2d result = new Vector2d();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) != this){
                
            }
        }
        return result;
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
        if(o instanceof User){
            User u = (User)o;
            
        }else if(o instanceof Wallet){
            Wallet w = (Wallet)o;
            
        }else if(o instanceof Block){
            Block b = (Block)o;
            
        }else if(o instanceof Transaction){
            Transaction t = (Transaction)o;
            
        }else if(o instanceof State){
            State e = (State)o;
            
        }
    }
    
    public Object getO(){
        return o;
    }
}
