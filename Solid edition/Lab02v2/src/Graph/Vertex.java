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
import System.StringUtil;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;


/**
 *
 * @author khali
 */
public class Vertex {
    private Object o;
    private Vector pos, disp;

    public Vertex(Object o){
        this.o = o;
        this.pos = new Vector((int) (100+Math.random() * 941), (int) (Math.random() * 625));
        disp = new Vector(0, 0);
    }
    
    
    public void Draw(Graphics2D g){
        //System.out.println("aaaaaaaaaaaaaaaaa");
        //System.out.println(this.toString());
       // System.out.println(""+pos);
        //System.out.println(""+pos.getX());
        //System.out.println(""+pos.getY());
        //System.out.println("aaaaaaaaaaaaaaaaa");
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
        g.fillOval((int)pos.getX()-20, (int)pos.getY()-20, 40, 40);
        g.setColor(Color.black);
        g.drawString(name, (int) (pos.getX()-20), (int) (pos.getY()-20));
    }
    
    public Object getO(){
        return o;
    }
    

    public Vector getPos() {
        return pos;
    }


    public void setPos(Vector pos) {
        this.pos = pos;
    }

    public Vector getDisp() {
        return disp;
    }

    public void setDisp(Vector disp) {
        this.disp = disp;
    }


    @Override
    public String toString() {
        if(o instanceof User){
            User u = (User)o;
            return "user{" + "o=" + u.getName() + '}';
        }else if(o instanceof Wallet){
            Wallet w = (Wallet)o;
            return "wallet{" + "o=" + StringUtil.getStringFromKey(w.getPublicKey()) + '}';
        }else if(o instanceof Block){
            Block b = (Block)o;
            return "block{" + "o=" + b.getHash() + '}';
        }else if(o instanceof Transaction){
            Transaction t = (Transaction)o;
            return "tran{" + "o=" + t.getTransactionId() + '}';
        }else if(o instanceof State){
            State e = (State)o;
            return "estate{" + "o=" + e.getB1() + '}';
        }
        return "a";
    }
    
    
    
}
