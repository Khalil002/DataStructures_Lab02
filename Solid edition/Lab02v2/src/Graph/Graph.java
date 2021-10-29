/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import System.Block;
import System.State;
import System.StringUtil;
import System.Transaction;
import System.User;
import System.Wallet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Graph {

    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    String masterID;

    //Constructor del grafo, se encarga de cargar la forma inicial del grafo
    public Graph() {
        vertices = new ArrayList();
        edges = new ArrayList();
        masterID = StringUtil.applySha256("Master" + "Admin" + 0000000000 + "admin@gmail.com" + "admin");

        File folder = new File("data");
        if (!folder.exists()) {
            try {
                folder.mkdir();

                User genesisUser = new User("Master", "Admin", 0000000000, "admin@gmail.com", "admin");
                Block genesisBlock = new Block("0");
                Wallet genesisWallet = new Wallet(genesisUser.getID());
                genesisWallet.setBalance(999999);

                Vertex v = new Vertex(genesisUser);
                Vertex u = new Vertex(genesisBlock);
                Vertex v1 = new Vertex(genesisWallet);
                vertices.add(v);
                vertices.add(u);
                vertices.add(v1);
                edges.add(new Edge(v, u));
                edges.add(new Edge(v, v1));
            } catch (Exception e) {
                System.out.println("\n ***** ERROR ***** "
                        + "\nLocation: Graph class constructor"
                        + "\nError: " + e
                        + "\n ***************** \n");
            }
        } else {
            openFiles();
        }
    }

    //Inserta un nuevo usuaro al grafo
    public void insertUserVertex(User user) {
        int randomUser = randUserVertex();
        Vertex v = vertices.get(randomUser);
        Vertex u = new Vertex(user);
        vertices.add(u);
        edges.add(new Edge(v, u));
    }

    //Busca el vertice que contiene el usuario con el ID dado
    public Vertex searchUserVertex(String userID) {
        for (Vertex v : vertices) {
            if (v.getO() instanceof User) {
                User u = (User) v.getO();
                if (u.getID().equals(userID)) {
                    return v;
                }
            }
        }
        return null;
    }

    //Busca el usuario con el correo y password correspondiente
    public User searchLoginUser(String email, String password) {
        for (Vertex v : vertices) {
            if (v.getO() instanceof User) {
                User o = (User) v.getO();
                if (o.getEmail().equals(email) && o.getPassword().equals(password)) {
                    return o;
                }
            }
        }
        return null;
    }

    //Inserta una nueva billetera al grafo
    public void insertWalletVertex(Vertex v, Wallet w) {
        Vertex u = new Vertex(w);
        vertices.add(u);
        edges.add(new Edge(v, u));
    }

    //Busca una billetera con la llave dada
    public Wallet searchWallet(PublicKey key) {
        for (Vertex v : vertices) {
            if (v.getO() instanceof Wallet) {
                Wallet w = (Wallet) v.getO();
                if (w.getPublicKey().equals(key)) {
                    return w;
                }
            }
        }
        return null;
    }

    //Busca las billeteras correspondientes al usuario con el ID dado
    public ArrayList<Wallet> searchUserWallets(String uID) {
        ArrayList<Wallet> wallets = new ArrayList();
        for (Vertex v : vertices) {
            if (v.getO() instanceof Wallet) {
                Wallet w = (Wallet) v.getO();
                if (w.getOwnerID().equals(uID)) {
                    wallets.add(w);
                }
            }
        }
        return wallets;
    }

    //Busca todas las transacciones relacionadas con la billetera con la llave dada
    public ArrayList<Transaction> searchWalletTransactions(PublicKey key) {
        ArrayList<Transaction> transactions = new ArrayList();
        for (Vertex v : vertices) {
            if (v.getO() instanceof Transaction) {
                Transaction o = (Transaction) v.getO();
                if (o.getSender().equals(key) || o.getReciepient().equals(key)) {
                    transactions.add(o);
                }
            }
        }
        return transactions;
    }

    //Verifica si todas las billeteras tienen su balance correcto
    private void verifyWallets() {
        for (Vertex v : vertices) {
            if (v.getO() instanceof Wallet) {
                Wallet w = (Wallet) v.getO();
                verifyWalletBalance(w);
            }
        }
    }

    //Verifica que la billetera tiene el balance que dice que tiene, sino las corrige
    private void verifyWalletBalance(Wallet a) {
        if (!a.getOwnerID().equals(masterID)) {
            float balance = 0;
            ArrayList<Transaction> transactions = searchWalletTransactions(a.getPublicKey());
            for (Transaction t : transactions) {
                if (a.getPublicKey().equals(t.getSender())) {
                    balance -= t.getValue();
                } else if (a.getPublicKey().equals(t.getReciepient())) {
                    balance += t.getValue();
                }
            }
            if (a.getBalance() != balance) {
                a.setBalance(balance);
            }
        }
    }

    //verifica si la transaccion es realizable y la inserta en el grafo 
    public void insertTransactionVertex(Wallet a, PublicKey b, float value) {
        verifyWalletBalance(a);

        if (a.getBalance() >= value && value >= 0) {
            Transaction t = new Transaction(a.getPublicKey(), b, value);
            t.generateSignature(a.getPrivateKey());
            insertTransactionVertex(t);
        }
    }

    //Inserta un nuevo vertice transaccion al grafo (y sus vertices de estado)
    private void insertTransactionVertex(Transaction t) {
        Vertex v = getLastBlock();
        Vertex u = new Vertex(t);
        vertices.add(u);
        edges.add(new Edge(v, u));
        
        Wallet a = searchWallet(t.getSender());
        Wallet b = searchWallet(t.getReciepient());
        Vertex u1 = new Vertex(new State(a.getBalance(), b.getBalance()));
        a.setBalance(a.getBalance() - t.getValue());
        b.setBalance(b.getBalance() + t.getValue());
        Vertex u2 = new Vertex(new State(a.getBalance(), b.getBalance()));
        vertices.add(u1);
        vertices.add(u2);
        edges.add(new Edge(u, u1));
        edges.add(new Edge(u, u2));
    }

    //Elimina toda instancia de una transaccion dentro del grafo
    private void deleteTransactions(Vertex v) {
        for (Edge e : edges) {
            if (e.getV().getO() == v.getO()) {
                vertices.remove(e.getU());
                deleteStates(e.getU());
                edges.remove(e);
            }
        }
    }

    //Elimina toda instancia de los estados de una transaccion dentro del grafo
    private void deleteStates(Vertex u) {
        for (Edge e : edges) {
            if (e.getV().getO() == u.getO()) {
                vertices.remove(e.getU());
                edges.remove(e);
            }
        }
    }

    //Busca el ultimo bloque disponible en la blockchain
    /*
    Elimina las aristas no necesarias para acelerar el proceso 
    de busqueda del ultimo bloque
     */
    private Vertex getLastBlock() {
        Vertex genb=null;
        for(Vertex v: vertices){
            if(v.getO() instanceof Block){
                Block b = (Block)v.getO();
                if(b.getPreviousHash().equals("0")){
                    genb = v;
                    break;
                }
            }
        }
        
        ArrayList<Edge> relatedEdges = new ArrayList();
        for (Edge e : edges) {
            if (e.getV().getO() instanceof Block && e.getU().getO() instanceof Block) {
                relatedEdges.add(e);
            }
        }
        return getLastBlock(genb, relatedEdges);
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
                Block ublock = new Block(vblock.getHash());
                Vertex u = new Vertex(ublock);
                vertices.add(u);
                edges.add(new Edge(v, u));
                return u;
            } else {
                return v;
            }

        }
    }

    //Revisa si el bloque tiene 3 transacciones (lleno)
    private boolean isBlockFull(Vertex v) {
        int count = 0;
        for (Edge e : edges) {
            if (e.getV() == v && e.getU().getO() instanceof Transaction) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }
        return false;
    }

    //Verifica si la cadena de bloques esta valida, sino la borra desde el error
    private void verifyBlocks() {
        Boolean deleteAllNextBlocks = false;
        for (Edge e : edges) {
            if (e.getV().getO() instanceof Block && e.getU().getO() instanceof Block) {
                if (deleteAllNextBlocks) {
                    edges.remove(e);
                    deleteTransactions(e.getV());
                    vertices.remove(e.getV());
                } else {
                    Block pB = (Block) e.getV().getO();
                    Block cB = (Block) e.getV().getO();
                    if (!pB.getHash().equals(cB.getPreviousHash())) {
                        deleteAllNextBlocks = true;
                        edges.remove(e);
                        deleteTransactions(e.getV());
                        vertices.remove(e.getV());
                    }
                }
            }
        }
    }

    //Verifica si ya existe un usuario con el email dado
    public boolean checkEmail(String text) {
        for (Vertex v : vertices) {
            if (v.getO() instanceof User) {
                User o = (User) v.getO();
                if (o.getEmail().equals(text)) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    Regreso un numero indice random de la lista de vertices
    solo si este indice hace referencia a un nodo Usuario
     */
    private int randUserVertex() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, vertices.size() + 1);
        if (randomNum != 0) {
            randomNum -= 1;
        }
        if (vertices.get(randomNum).getO() instanceof User) {
            return randomNum;
        } else {
            return randUserVertex();
        }
    }

    //Abrre y escribe los datos del grafo
    private void openFiles() {
        //Abre los datos de usuarios
        File file = new File("data/Usuarios.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("\n ***** ERROR ***** "
                        + "\nLocation: Graph.openFiles(), While opening users file"
                        + "\nError: " + ex
                        + "\n ***************** \n");
            }
        } else {
            try {
                Scanner in = new Scanner(file);
                String line = in.nextLine();
                String[] data = line.split(",");

                User u = new User(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);
                vertices.add(new Vertex(u));

                while (in.hasNextLine()) {
                    line = in.nextLine();
                    data = line.split(",");
                    u = new User(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);
                    insertUserVertex(u);
                }

            } catch (Exception ex) {
                System.out.println("\n ***** ERROR ***** "
                        + "\nLocation: Graph.openFiles(), While inserting users to graph"
                        + "\nError: " + ex
                        + "\n ***************** \n");
            }
        }

        //Abre los datos de billeteras
        file = new File("data/billeteras.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("\n ***** ERROR ***** "
                        + "\nLocation: Graph.openFiles(), While opening wallets file"
                        + "\nError: " + ex
                        + "\n ***************** \n");
            }
        } else {
            try {
                Scanner in = new Scanner(file);
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String data[] = line.split(",");

                    Wallet w = new Wallet(data[0], data[1], data[2], Float.parseFloat(data[3]));
                    Vertex v = searchUserVertex(w.getOwnerID());
                    if (v != null) {
                        insertWalletVertex(v, w);
                    }

                }

            } catch (Exception ex) {
                System.out.println("\n ***** ERROR ***** "
                        + "\nLocation: Graph.openFiles(), While inserting wallets to graph"
                        + "\nError: " + ex
                        + "\n ***************** \n");
            }
        }

        //Abre los datos de transacciones
        file = new File("data/transacciones.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("\n ***** ERROR ***** "
                        + "\nLocation: Graph.openFiles(), While opening transactions file"
                        + "\nError: " + ex
                        + "\n ***************** \n");
            }
        } else {
            try {
                Scanner in = new Scanner(file);
                Block genesisBlock = new Block("0");
                Vertex v = new Vertex(genesisBlock);
                vertices.add(v);
                Edge e = new Edge(vertices.get(0), v);
                edges.add(e);
                
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String data[] = line.split(",");
                    Transaction t = new Transaction(data[0], data[1], Float.parseFloat(data[2]), Long.parseLong(data[3]), Long.parseLong(data[4]));
                    if (t.verifiySignature()) {
                        insertTransactionVertex(t);
                    } else {
                    }

                }

            } catch (Exception ex) {
                System.out.println("\n ***** ERROR ***** "
                        + "\nLocation: Graph.openFiles(), While inserting transactions to graph"
                        + "\nError: " + ex
                        + "\n ***************** \n");
            }
        }
        verifyBlocks();
        verifyWallets();
    }

    //Guarda los datos del grafo
    public void saveFiles() {
        //Guarda los datos de los usuarios
        File file = new File("data/Usuarios.txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("\n ***** ERROR ***** "
                    + "\nLocation: Graph.saveFiles(), while creating a new users file"
                    + "\nError: " + ex
                    + "\n ***************** \n");
        }
        try (FileWriter fw = new FileWriter(file, false)) {

            BufferedWriter bw = new BufferedWriter(fw);
            for (Vertex v : vertices) {
                if (v.getO() instanceof User) {
                    User o = (User) v.getO();
                    bw.write(o.saveString());
                    bw.flush();
                }
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println("\n ***** ERROR ***** "
                    + "\nLocation: Graph.saveFiles(), while saving data to users file"
                    + "\nError: " + e
                    + "\n ***************** \n");
        }

        //Guarda los datos de las transacciones
        file = new File("data/Transacciones.txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("\n ***** ERROR ***** "
                    + "\nLocation: Graph.saveFiles(), while creating a new transactions file"
                    + "\nError: " + ex
                    + "\n ***************** \n");
        }
        try (FileWriter fw = new FileWriter(file, false)) {

            BufferedWriter bw = new BufferedWriter(fw);
            for (Vertex v : vertices) {
                if (v.getO() instanceof Transaction) {
                    Transaction o = (Transaction) v.getO();
                    bw.write(o.saveString());
                    bw.flush();
                }
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println("\n ***** ERROR ***** "
                    + "\nLocation: Graph.saveFiles(), while saving data to transactions file"
                    + "\nError: " + e
                    + "\n ***************** \n");

        }

        //Guarda los datos de las billeteras
        file = new File("data/Billeteras.txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("\n ***** ERROR ***** "
                    + "\nLocation: Graph.saveFiles(), while creating a new wallets file"
                    + "\nError: " + ex
                    + "\n ***************** \n");
        }
        try (FileWriter fw = new FileWriter(file, false)) {

            BufferedWriter bw = new BufferedWriter(fw);
            for (Vertex v : vertices) {
                if (v.getO() instanceof Wallet) {
                    Wallet o = (Wallet) v.getO();
                    bw.write(o.saveString());
                    bw.flush();
                }
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println("\n ***** ERROR ***** "
                    + "\nLocation: Graph.saveFiles(), while saving data to wallets file"
                    + "\nError: " + e
                    + "\n ***************** \n");

        }
    }

    //Se encarga de dibujar el grafo
    public void draw(Graphics2D g2) {
        for (Vertex v : vertices) {
            v.setAcc(new Vector());
            v.calcForce(vertices);
            v.calcForceEdge(calcAdj(v));
            v.updatePosition();
        }

        scale();
        Vector centroid = vertices.get(0).getCentroid(vertices);
        Vector aux = (new Vector(300, 300).sub(centroid));
        for (Vertex v : vertices) {
            v.setPosToDraw(v.getPosToDraw().add(aux));
        }
        paint(g2);
    }

    public String getMasterID() {
        return masterID;
    }

    public void scale() {
        double XMin = Integer.MAX_VALUE;
        double YMin = Integer.MAX_VALUE;
        double XMax = Integer.MIN_VALUE;
        double YMax = Integer.MIN_VALUE;

        for (Vertex v : vertices) {
            if (v.getPos().getX() < XMin) {
                XMin = v.getPos().getX();
            }
            if (v.getPos().getY() < YMin) {
                YMin = v.getPos().getY();
            }
            if (v.getPos().getX() > XMax) {
                XMax = v.getPos().getX();
            }
            if (v.getPos().getY() > YMax) {
                YMax = v.getPos().getY();
            }
        }

        double length_x = XMax - XMin;
        double length_y = YMax - YMin;
        double length = Math.max(length_x, length_y);
        for (Vertex v : vertices) {
            Vector vv = v.getPos();
            vv = vv.mul(400 / length);
            v.setPosToDraw(vv);
        }
    }

    public void paint(Graphics2D gg) {
        for (Vertex v : vertices) {
            v.Draw(gg);
        }
        for (Edge e : edges) {
            e.Draw(gg);
        }

    }

    //Devuelve los ejes asociados a un vértice
    public ArrayList<Edge> calcAdj(Vertex v) {
        ArrayList<Edge> e = new ArrayList();
        for (Edge edge : this.edges) {
            if (edge.getU().equals(v) || edge.getV().equals(v)) {
                e.add(edge);
            }
        }
        return e;
    }

    public void a() {
        for(Edge e: edges){
            System.out.println(e);
            System.out.println("");
        }
    }

}
