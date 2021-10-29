package UI;

import Graph.Edge;
import Graph.Graph;
import Graph.Vector;
import Graph.Vertex;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

/*
 * @author Khalil
 */
public class TwoDPlane extends JPanel {

    final int WIDTH;
    final int HEIGHT;
    int xPan;
    int yPan;
    float scale;
    boolean drawBackground;
    Graph graph;

    int width;
    int height;
    int area;
    double k;
    double temp;
    double coolingRate;
    boolean equilibriumReached, running;
    int iteracion;
    Thread t;

    public TwoDPlane(JPanel placeHolder, Graph g) {
        initComponents();
        //placeHolder.setVisible(false);
        this.setSize(placeHolder.getSize());
        this.setBorder(placeHolder.getBorder());
        this.setBackground(Color.white);
        this.setVisible(true);

        WIDTH = this.getWidth();
        HEIGHT = this.getHeight();
        xPan = WIDTH / 2;
        yPan = HEIGHT / 2;
        this.drawBackground = true;
        scale = 1;
        this.graph = g;

        area = WIDTH * HEIGHT;
        temp = WIDTH / 10;
        coolingRate = 0.01;
        equilibriumReached = false;
        running = false;
        k = Math.sqrt(area / graph.getVertices().size());
        iteracion = 0;

        MouseAdapter ma = new MouseAdapter() {
            int distanceX;
            int distanceY;
            boolean moving = false;

            //not working
            public void mouseWheelMoved(MouseWheelEvent e) {
                Rectangle rect = new Rectangle(0, 0, WIDTH, HEIGHT);
                if (rect.contains(e.getX(), e.getY())) {
                    int i = e.getWheelRotation();
                    if (i > 0) {
                        scale /= 1.05;
                    } else if (i < 0) {
                        scale *= 1.05;
                    }
                    repaint();
                }
            }

            public void mouseDragged(MouseEvent e) {
                if (moving) {
                    xPan = e.getX() - distanceX;
                    yPan = e.getY() - distanceY;

                }
                repaint();
            }

            public void mousePressed(MouseEvent e) {
                Rectangle rect = new Rectangle(0, 0, WIDTH, HEIGHT);
                if (rect.contains(e.getX(), e.getY())) {
                    distanceX = e.getX() - xPan;
                    distanceY = e.getY() - yPan;
                    moving = true;
                }
            }

            public void mouseReleased(MouseEvent e) {
                distanceX = 0;
                distanceY = 0;
                moving = false;
            }
        };
        addMouseListener(ma);
        addMouseWheelListener(ma);
        addMouseMotionListener(ma);
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!(equilibriumReached) && iteracion < 1000) {
                    System.out.print("");
                    if (running) {
                        int f = 0;
                        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
                        for (Vertex v : graph.getVertices()) {
                            f++;
                            System.out.println("v" + f + " x: " + v.getPos().getX());
                            System.out.println("v" + f + " y: " + v.getPos().getY());
                            System.out.println("");
                        }
                        System.out.println("***********************");
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        for (Vertex v : graph.getVertices()) {
                            v.setDisp(new Vector(0, 0));
                            for (Vertex u : graph.getVertices()) {
                                if (v != u) {
                                    Vector d = v.getPos().sub(u.getPos());
                                    //System.out.println("d: "+d.getX());
                                    //System.out.println("d: "+d.getY());
                                    v.setDisp(v.getDisp().add((d.div(d.size())).mul(fr(d.size()))));
                                    //System.out.println("d: "+v.getDisp().getX());
                                    //System.out.println("d: "+v.getDisp().getY());
                                }
                            }
                        }

                        for (Edge e : graph.getEdges()) {
                            try {
                                Vector d = e.getV().getPos().sub(e.getU().getPos());
                                e.getV().setDisp(e.getV().getDisp().sub(d.div(d.size()).mul(fa(d.size()))));
                                e.getU().setDisp(e.getU().getDisp().add(d.div(d.size()).mul(fa(d.size()))));
                            } catch (Exception ea) {
                                System.out.println("bbbbbbbbbbbbbbbbbbb");
                                System.out.println(e);
                                System.out.println(e.getV().getPos());
                                System.out.println(e.getU().getPos());
                                System.out.println("bbbbbbbbbbbbbbbbbbb");
                            }

                            //System.out.println("d: "+d.getX());
                            //System.out.println("d: "+d.getY());
                        }

                        equilibriumReached = true;
                        for (Vertex v : graph.getVertices()) {
                            if (v.getDisp().size() > 15) {
                                equilibriumReached = false;
                            }
                            v.setPos(v.getPos().add(v.getDisp().div(v.getDisp().size()).mul(Math.min(v.getDisp().size(), temp))));
                            //v.getPos().setX(Math.min(width, Math.max(0.0, v.getPos().getX())));
                            //v.getPos().setY(Math.min(height, Math.max(0.0, v.getPos().getY())));
                        }

                        temp = Math.max(temp * (1 - coolingRate), 1);

                        repaint();
                        iteracion++;
                    }

                }

            }
        });
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.translate(xPan, yPan);
        g2.scale(scale, scale);

        if (drawBackground) {
            drawBackground(g2);
        }

        draw(g2);

    }

    private double fa(double x) {
        return (Math.pow(x, 2) / k);
    }

    private double fr(double x) {
        return (Math.pow(k, 2) / x);
    }

    private void drawBackground(Graphics2D g2) {
        int x1 = (int) ((-1 * (xPan - WIDTH / 2) - WIDTH / 2) / scale);
        int x2 = (int) ((-1 * (xPan - WIDTH / 2) + WIDTH / 2) / scale);
        int y1 = (int) ((-1 * (yPan - HEIGHT / 2) - HEIGHT / 2) / scale);
        int y2 = (int) ((-1 * (yPan - HEIGHT / 2) + HEIGHT / 2) / scale);

        for (int i = x1; i < x2; i++) {
            if (i % 10 == 0) {
                g2.setColor(new Color(224, 224, 224));
                g2.setStroke(new BasicStroke(1));
                g2.draw(new Line2D.Float(i, y1, i, y2));
            }
        }
        for (int w = y1; w < y2; w++) {
            if (w % 10 == 0) {
                g2.setColor(new Color(224, 224, 224));
                g2.setStroke(new BasicStroke(1));
                g2.draw(new Line2D.Float(x1, w, x2, w));
            }
        }
        for (int i = x1; i < x2; i++) {
            if (i % 50 == 0) {
                g2.setColor(new Color(192, 192, 192));
                g2.setStroke(new BasicStroke(2));
                g2.draw(new Line2D.Float(i, y1, i, y2));
            }
        }
        for (int w = y1; w < y2; w++) {
            if (w % 50 == 0) {
                g2.setColor(new Color(192, 192, 192));
                g2.setStroke(new BasicStroke(2));
                g2.draw(new Line2D.Float(x1, w, x2, w));
            }
        }

        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(0, 0, 0));
        g2.draw(new Line2D.Float(x1, 0, x2, 0));
        g2.draw(new Line2D.Float(0, y1, 0, y2));

        //Reset config
        g2.setStroke(new BasicStroke(1));
    }

    //Here you draw whatever you want
    private void draw(Graphics2D g2) {
        graph.draw(g2);
    }

    public void updateGraph(Graph g) {
        this.graph = g;
        this.k = Math.sqrt(area / graph.getVertices().size());
        System.out.println("k: " + k);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void run() {
        running = true;
    }

    public void stop() {
        running = false;
        iteracion = 0;
        equilibriumReached = false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
