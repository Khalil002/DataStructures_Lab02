/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import Graph.Vector;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author khali
 */
public class vertextesting {

    Vector pos, disp;

    public vertextesting(Vector pos) {
        this.pos = pos;
        disp = new Vector(0, 0);
    }

    void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillOval((int)pos.getX()-15, (int)pos.getY()-15, 30, 30);
    }
}
