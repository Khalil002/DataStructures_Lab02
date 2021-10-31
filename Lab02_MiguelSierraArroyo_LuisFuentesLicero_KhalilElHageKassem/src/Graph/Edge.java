package Graph;

import java.awt.Color;
import java.awt.Graphics2D;

/*
 * @Group #9
 */
public class Edge {

    private final Vertex v;
    private final Vertex u;

    public Edge(Vertex v, Vertex u) {
        this.v = v;
        this.u = u;
    }

    public void Draw(Graphics2D g) {
        g.setColor(Color.black);
        g.drawLine((int) v.getPos().getX(), (int) v.getPos().getY(), (int) u.getPos().getX(), (int) u.getPos().getY());
    }

    public Vertex getV() {
        return v;
    }

    public Vertex getU() {
        return u;
    }

}
