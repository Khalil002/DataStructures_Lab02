/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import System.Wallet;
import System.Block;
import System.State;
import System.Transaction;
import System.User;
import java.awt.Graphics2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.vecmath.Vector2d;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author khali
 */
public class Graph {

    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    User genesisUser;
    Block genesisBlock;

    public Graph() {
        vertices = new ArrayList();
        edges = new ArrayList();
        genesisUser = new User("Master", "Admin", 0000000000, "admin", "admin");
        genesisBlock = new Block("0");

        Vertex v = new Vertex(genesisUser);
        Vertex u = new Vertex(genesisBlock);
        vertices.add(v);
        vertices.add(u);
        edges.add(new Edge(v, u));
    }

    public void draw(Graphics2D g){
        
    }
    
    //NotWorkingYet
    public void guardarArchivos() {
        File folder = new File("data");
        try {
            folder.mkdir();
        } catch (Exception e) {
            System.out.println("Error en crear el folder");
        }
        File file = new File(folder, "usuarios.csv");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("Error en crear el archivo usuarios");
        }
        try (FileWriter fw = new FileWriter(file, false)) {
            BufferedWriter bw = new BufferedWriter(fw);

            for (Vertex v : vertices) {
                if (v.getO() instanceof User) {
                    User o = (User) v.getO();
                    bw.write(o.toString());
                    bw.flush();
                }
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println("error");

        }

        File file2 = new File(folder, "transacciones.csv");
        try {
            file2.createNewFile();
        } catch (IOException ex) {
            System.out.println("Error en crear el archivo");
        }
        try (FileWriter fw = new FileWriter(file2, false)) {
            BufferedWriter bw = new BufferedWriter(fw);

           //bw.write(r.recorrerBloques());
            bw.flush();
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println("error");

        }

    }

    public void openFiles() {
        File folder = new File("data");
        if (!folder.exists()) {
            try {
                folder.mkdir();
            } catch (Exception e) {
                System.out.println("Error en crear el folder");
            }
        }

        File file = new File(folder, "usuarios.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error en crear el archivo de usuario");
            }
        } else {
            try {
                Scanner in = new Scanner(file);
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String[] data = line.split(",");

                    User u = new User(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);
                    insertUser(u);

                }

            } catch (Exception ex) {
                System.out.println(ex + "bruh?");
            }
        }

        File file1 = new File(folder, "transacciones.csv");
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error en crear el archivo transacciones");
            }
        } else {
            try {
                Scanner in = new Scanner(file1);
                int i = 0;
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String data[] = line.split(",");

                    //Transaction t = new Transaction(data[0], data[1], Float.parseFloat(data[2]), data[3]);

                }

            } catch (Exception ex) {
                System.out.println(ex + " error en insertarTransacciones del archivo");
            }
            //System.out.println(r.preOrder(r.usuario));
        }

        File file2 = new File(folder, "billeteras.csv");
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error en crear el archivo billeteras");
            }
        } else {
            try {
                Scanner in = new Scanner(file1);
                int i = 0;
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String data[] = line.split(",");

                    Wallet w = new Wallet(data[0], data[1], data[2], Float.parseFloat(data[3]));
                    Vertex v = searchUser(w.ownerID);
                    if (v != null) {
                        insertWallet(v, w);
                    }

                }

            } catch (Exception ex) {
                System.out.println(ex + " error en insertarBilletera del archivo");
            }
            //System.out.println(r.preOrder(r.usuario));
        }

    }

    //Inserta un usuario al grafo
    public void insertUser(User user) {
        int randomUser = randUserVertex();
        Vertex v = vertices.get(randomUser);
        Vertex u = new Vertex(user);
        vertices.add(u);
        edges.add(new Edge(v, u));
        insertWallet(u, user.getID());
    }

    //Inserta una billetera al grafo
    public void insertWallet(Vertex v, String userID) {
        Vertex u = new Vertex(new Wallet(userID));
        vertices.add(u);
        edges.add(new Edge(v, u));
    }

    public void insertWallet(Vertex v, Wallet w) {
        Vertex u = new Vertex(w);
        vertices.add(u);
        edges.add(new Edge(v, u));
    }
    
    //Devuelve un ArrayList de billeteras para saber todas las que están a nombre del usuario
    public ArrayList<Wallet> searchUserWallets(User user){
        ArrayList<Wallet> wallets = new ArrayList();
        Wallet w;
        for (Edge e: edges){
            if (e.getV().getO() instanceof User && e.getV().getO() == user && e.getU().getO() instanceof Wallet){
                w = (Wallet)e.getU().getO();
                wallets.add(w);
            }
        }
        return wallets;
    } 

    //Inserta una transaccion con sus debidos estados al grafo
    public void insertTransaction(Vertex from, Vertex to, float value) {
        Wallet a = (Wallet) from.getO();
        Wallet b = (Wallet) to.getO();
        if (verifyTransaction(a, value)) {
            Vertex v = getLastBlock(vertices.get(1));
            Transaction t = new Transaction(a.publicKey, b.publicKey, value);
            t.generateSignature(a.privateKey);
            Vertex u = new Vertex(t);
            vertices.add(u);
            edges.add(new Edge(v, u));

            Vertex u1 = new Vertex(new State(a.getBalance(), b.getBalance()));
            a.setBalance(a.getBalance() - value);
            b.setBalance(b.getBalance() + value);
            Vertex u2 = new Vertex(new State(a.getBalance(), b.getBalance()));
            vertices.add(u1);
            vertices.add(u2);
            edges.add(new Edge(u, u1));
            edges.add(new Edge(u, u2));
        }

    }

    public Vertex searchWallet(String publicKey) {
        for (Vertex v : vertices) {
            Wallet a = (Wallet) v.getO();
            if (a.publicKey.equals(publicKey)) {
                return v;
            }
        }
        return null;
    }

    public Vertex searchUser(String userID) {
        for (Vertex v : vertices) {
            if (v.getO() instanceof User) {
                User o = (User) v.getO();
                if (o.getID().equals(userID)) {
                    return v;
                }
            }
        }
        return null;
    }

    public Vertex searchLoginUser(String email, String password) {
        for (Vertex v : vertices) {
            if (v.getO() instanceof User) {
                User o = (User) v.getO();
                if (o.getEmail().equals(email) && o.getPassword().equals(password)) {
                    return v;
                }
            }
        }
        return null;
    }

    public boolean verifyTransaction(Wallet w, float value) {
        int total = 0;
        for (Vertex v : vertices) {
            if (v.getO() instanceof Transaction) {
                Transaction o = (Transaction) v.getO();
                if (o.sender == w.publicKey) {
                    if (o.verifiySignature()) {
                        total -= o.value;
                    }
                } else if (o.reciepient == w.publicKey) {
                    if (o.verifiySignature()) {
                        total += o.value;
                    }
                }
            }
        }
        if (total == w.getBalance() && total > value) {
            return true;
        }
        return false;
    }

    /*
    Elimina las aristas no necesarias para acelerar el proceso 
    de busqueda del ultimo bloque
     */
    private Vertex getLastBlock(Vertex v) {
        ArrayList<Edge> relatedEdges = new ArrayList();
        for (Edge e : edges) {
            if (e.getV().getO() instanceof Block && e.getV().getO() instanceof Block) {
                relatedEdges.add(e);
            }
        }
        return getLastBlock(v, relatedEdges);
    }

    //Busca el ultimo bloque disponible en la blockchain
    private Vertex getLastBlock(Vertex v, ArrayList<Edge> relatedEdges) {
        Edge edge = null;
        for (Edge e : relatedEdges) {
            if (e.getV() == v) {
                edge = e;
            }
        }
        if (edge != null) {
            return getLastBlock(edge.getU(), relatedEdges);
        } else {
            if (isBlockFull(v)) {
                Block vblock = (Block) v.getO();
                Block ublock = new Block(vblock.hash);
                Vertex u = new Vertex(ublock);
                vertices.add(u);
                edges.add(new Edge(v, u));
                return u;
            } else {
                return v;
            }

        }
    }

    /*
    Regreso un numero indice random de la lista de vertices
    solo si este indice hace referencia a un nodo Usuario
     */
    private int randUserVertex() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, vertices.size() + 1);
        if (vertices.get(randomNum).getO() instanceof User) {
            return randomNum;
        } else {
            return randUserVertex();
        }
    }

    //Revisa si el bloque tiene 3 transacciones (lleno)
    private boolean isBlockFull(Vertex v) {
        int count = 0;
        for (Edge e : edges) {
            if (e.getV() == v) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }
        return false;
    }

}
