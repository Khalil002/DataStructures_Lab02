/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import Graph.Vector;
import Graph.Vertex;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author khali
 */
public class drawtesting extends JPanel {

    ArrayList<vertextesting> vertices;
    ArrayList<edgetesting> edges;
    int width;
    int height;
    int area;
    double k;
    double temp;
    double coolingRate;
    boolean equilibriumReached;
    int iteracion;
    
    public drawtesting() {
        width = 600;//1041;
        height = 600;//625;
        area = width * height;
        temp = width / 10;
        coolingRate = 0.01;
        equilibriumReached = false;
        vertices = makeBlobList(10);
        edges = makeSpringsFor(vertices, 10);
        k = Math.sqrt(area / vertices.size());
        iteracion =0;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                
                while (!(equilibriumReached)&&iteracion<1000) {
                    int f =0;
                    for(vertextesting v : vertices){
                        f++;
                        System.out.println("v"+f+" x: "+v.pos.getX());
                        System.out.println("v"+f+" y: "+v.pos.getY());
                        System.out.println("");
                    }
                    System.out.println("***********************");
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (vertextesting v : vertices) {
                        v.disp = new Vector(0, 0);
                        for (vertextesting u : vertices) {
                            if (v != u) {
                                Vector d = v.pos.sub(u.pos);
                                v.disp = v.disp.add(d.div(d.size()).mul(fr(d.size())));
                            }
                        }
                    }

                    for (edgetesting e : edges) {
                        Vector d = e.v.pos.sub(e.u.pos);
                        e.v.disp = e.v.disp.sub(d.div(d.size()).mul(fa(d.size())));
                        e.u.disp = e.u.disp.add(d.div(d.size()).mul(fa(d.size())));
                    }

                    equilibriumReached = true;
                    for (vertextesting v : vertices) {
                        if(v.disp.size()>15){
                            equilibriumReached = false;
                        }
                        v.pos = v.pos.add(v.disp.div(v.disp.size()).mul(Math.min(v.disp.size(), temp)));
                        v.pos.setX(Math.min(width, Math.max(0.0, v.pos.getX())));
			v.pos.setY(Math.min(height, Math.max(0.0, v.pos.getY())));
                    }

                    temp = Math.max(temp * (1 - coolingRate), 1);

                    repaint();
                    iteracion++;
                }
            }
        });
        t.start();
        JFrame f = new JFrame();
        f.add(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(width, height);
        f.setVisible(true);
    }

    private double fa(double x) {
        return (Math.pow(x, 2) / k);
    }

    private double fr(double x) {
        return (Math.pow(k, 2) / x);
    }

    private ArrayList<vertextesting> makeBlobList(int numBlobs) {
        ArrayList<vertextesting> out = new ArrayList();
        for (int i = 0; i < numBlobs; i++) {
            vertextesting b = new vertextesting(new Vector((int) (100+Math.random() * width), (int) (Math.random() * height)));
            out.add(b);
        }
        return out;
    }

    private ArrayList<edgetesting> makeSpringsFor(ArrayList<vertextesting> blobs, int restingLength) {
        ArrayList<edgetesting> springs = new ArrayList();

        for (int i = 0; i < blobs.size(); i++) {
            for (int j = i + 1; j < blobs.size(); j++) {
                vertextesting b1 = blobs.get(i);
                vertextesting b2 = blobs.get(j);
                edgetesting s = new edgetesting(restingLength, b1, b2);
                springs.add(s);
            }
        }
        return springs;
    }

    public void paint(Graphics g) {
        super.paint(g);
        for(vertextesting v: vertices){
            v.draw(g);
        }
        for(edgetesting e: edges){
            e.draw(g);
        }
    }

    public static void main(String[] args) {
        new drawtesting();
    }

}
