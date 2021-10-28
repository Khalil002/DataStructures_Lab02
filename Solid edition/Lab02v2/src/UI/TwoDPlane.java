package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
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
    

    public TwoDPlane(JPanel placeHolder) {
        initComponents();
        placeHolder.setVisible(false);
        this.setBounds(placeHolder.getBounds());
        this.setBorder(placeHolder.getBorder());
        this.setBackground(Color.white);
        this.setVisible(true);

        WIDTH = this.getWidth();
        HEIGHT = this.getHeight();
        xPan = WIDTH / 2;
        yPan = HEIGHT / 2;
        this.drawBackground = true;
        scale=1;

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
                        scale/=1.05;
                    } else if (i < 0) {
                        scale*=1.05;
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

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.translate(xPan, yPan);
        g2.scale(scale, scale);
        
        if (drawBackground) {
            drawBackground(g2);
        }

        draw(g2);

    }

    private void drawBackground(Graphics2D g2) {
        int x1 = (int)((-1 * (xPan - WIDTH / 2) - WIDTH / 2)/scale);
        int x2 = (int)((-1 * (xPan - WIDTH / 2) + WIDTH / 2)/scale);
        int y1 = (int)((-1 * (yPan - HEIGHT / 2) - HEIGHT / 2)/scale);
        int y2 = (int)((-1 * (yPan - HEIGHT / 2) + HEIGHT / 2)/scale);
        
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
