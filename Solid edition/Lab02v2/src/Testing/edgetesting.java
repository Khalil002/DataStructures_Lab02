/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import java.awt.Graphics;

/**
 *
 * @author khali
 */
public class edgetesting {
    vertextesting v, u;
    int length;
    float c1, c2;
    
    public edgetesting(int l, vertextesting v, vertextesting u){
        this.v=v;
        this.u=u;
        this.length=l;
        this.c1=2;
        this.c2=1;
    }

    void draw(Graphics g) {
        g.drawLine((int)v.pos.getX(), (int)v.pos.getY(), (int)u.pos.getX(), (int)u.pos.getY());
    }
    
    
}
