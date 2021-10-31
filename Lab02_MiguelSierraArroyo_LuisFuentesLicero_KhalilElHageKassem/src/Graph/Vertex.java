package Graph;

import System.Block;
import System.Transaction;
import System.User;
import System.Wallet;
import System.State;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/*
 * @Group #9
 */
public class Vertex {

    private Object o;
    private Vector pos, disp;
    private Rectangle area;

    public Vertex(Object o) {
        this.o = o;
        this.pos = new Vector((int) (100 + Math.random() * 1000), (int) (100 + Math.random() * 1000));
        disp = new Vector(0, 0);
        area = new Rectangle((int) (pos.getX() - 20), (int) (pos.getY() - 20), 40, 40);
    }

    public void Draw(Graphics2D g) {
        String name = "";
        if (o instanceof User) {
            name = "Usuario";
            g.setColor(Color.yellow);
        } else if (o instanceof Wallet) {
            name = "Billetera";
            g.setColor(Color.green);
        } else if (o instanceof Block) {
            name = "Bloque";
            g.setColor(Color.cyan);
        } else if (o instanceof Transaction) {
            name = "Transacción";
            g.setColor(Color.blue);
        } else if (o instanceof State) {
            name = "Estado";
            g.setColor(Color.pink);
        }
        g.fillOval((int) pos.getX() - 20, (int) pos.getY() - 20, 40, 40);
        g.setColor(Color.black);
        g.drawString(name, (int) (pos.getX() - 20), (int) (pos.getY() - 20));
    }

    public void calcArea() {
        area = new Rectangle((int) (pos.getX() - 20), (int) (pos.getY() - 20), 40, 40);
    }

    public Rectangle getArea() {
        return this.area;
    }

    public Object getO() {
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

}
