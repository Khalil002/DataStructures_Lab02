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
import java.security.PublicKey;
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

    public Graph() {
        vertices = new ArrayList();
        edges = new ArrayList();

        File folder = new File("data");
        if (!folder.exists()) {
            try {
                folder.mkdir();
                User genesisUser = new User("Master", "Admin", 0000000000, "admin", "admin");
                Block genesisBlock = new Block("0");
                Wallet genesisWallet = new Wallet(genesisUser.getID());
                genesisWallet.setBalance(999999999);
                Vertex v = new Vertex(genesisUser);
                Vertex u = new Vertex(genesisBlock);
                Vertex v1 = new Vertex(genesisWallet);
                
                vertices.add(v);
                vertices.add(u);
                vertices.add(v1);
                edges.add(new Edge(v, u));
                edges.add(new Edge(v, v1));
                saveUsers();
                saveWallets();
                saveTransactions();
            } catch (Exception e) {
                System.out.println("Error en crear el folder en la clase Grapho, error: " + e);
            }
        } else {
            openFiles();
        }

    }

    public void draw(Graphics2D g) {

    }

    public void saveUsers() {
        File file = new File("data/Usuarios.txt");
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
                    bw.write(o.saveString());
                    
                    bw.flush();
                }
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println("error");

        }
    }

    public void saveTransactions() {
        File file = new File("data/Transacciones.txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("Error en crear el archivo");
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
            System.out.println("error");

        }
    }

    public void saveWallets() {
        File file = new File("data/Billeteras.txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("Error en crear el archivo");
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
            System.out.println("error");

        }
    }

    public void openFiles() {
        File file = new File("data/Usuarios.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("ERROR: en crear el archivo de usuario");
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
                    insertUser(u);
                }

            } catch (Exception ex) {
                System.out.println("ERROR: en leer el archivo usuarios");
            }
        }

        file = new File("data/billeteras.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("ERROR: en crear el archivo billeteras");
            }
        } else {
            try {
                Scanner in = new Scanner(file);
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String data[] = line.split(",");

                    Wallet w = new Wallet(data[0], data[1], data[2], Float.parseFloat(data[3]));
                    Vertex v = searchUser(w.getOwnerID());
                    if (v != null) {
                        insertWallet(v, w);
                    }

                }

            } catch (Exception ex) {
                System.out.println("ERROR: en leer el archivo billeteras");
            }
        }

        file = new File("data/transacciones.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("ERROR: en crear el archivo transacciones");
            }
        } else {
            try {
                Scanner in = new Scanner(file);
                Block genesisBlock = new Block("0");
                Vertex v = new Vertex(genesisBlock);
                vertices.add(v);

                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    String data[] = line.split(",");

                    Transaction t = new Transaction(data[1], data[2], Float.parseFloat(data[3]), Long.parseLong(data[4]), Long.parseLong(data[5]));
                    if (t.verifiySignature()) {
                        insertTransaction(t);
                    }

                }

            } catch (Exception ex) {
                System.out.println("ERROR: en leer el archivo transacciones");
            }
        }
        verifyBlocks();
        verifyWallets();

    }

    //Inserta un usuario al grafo
    public void insertUser(User user) {
        int randomUser = randUserVertex();
        Vertex v = vertices.get(randomUser);
        Vertex u = new Vertex(user);
        vertices.add(u);
        edges.add(new Edge(v, u));
        insertWallet(u, user.getID());
        saveUsers();
    }

    //Inserta una billetera al grafo
    public void insertWallet(Vertex v, String userID) {
        Vertex u = new Vertex(new Wallet(userID));
        vertices.add(u);
        edges.add(new Edge(v, u));
        saveWallets();
    }

    //Inserta una billetera al grafo (abrir archivos)
    public void insertWallet(Vertex v, Wallet w) {
        Vertex u = new Vertex(w);
        vertices.add(u);
        edges.add(new Edge(v, u));
    }

    //Devuelve un ArrayList de billeteras para saber todas las que están a nombre del usuario
    public ArrayList<Wallet> searchUserWallets(User user) {
        ArrayList<Wallet> wallets = new ArrayList();
        Wallet w;
        for (Edge e : edges) {
            if (e.getV().getO() instanceof User && e.getU().getO() instanceof Wallet) {
                User o = (User) e.getV().getO();
                if (o.getID().equals(user.getID())) {
                    w = (Wallet) e.getU().getO();
                    wallets.add(w);
                }
            }
        }
        return wallets;
    }

    //Inserta una transaccion al grafo 
    public void insertTransaction(Vertex from, Vertex to, float value) {
        Wallet a = (Wallet) from.getO();
        Wallet b = (Wallet) to.getO();
        if (verifyTransaction(a, value)) {
            Vertex v = getLastBlock(vertices.get(1));
            Transaction t = new Transaction(a.getPublicKey(), b.getPublicKey(), value);
            t.generateSignature(a.getPrivateKey());
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

    //Inserta una transaccion al grafo (abrir archivos)
    public void insertTransaction(Transaction t) {
        Vertex v = getLastBlock(vertices.get(1));
        Vertex u = new Vertex(t);
        vertices.add(u);
        edges.add(new Edge(v, u));

        Vertex a = searchWallet(t.getSender());
        Vertex b = searchWallet(t.getReciepient());
        Wallet wa = (Wallet) a.getO();
        Wallet wb = (Wallet) b.getO();
        Vertex u1 = new Vertex(new State(wa.getBalance(), wb.getBalance()));
        wa.setBalance(wa.getBalance() - t.getValue());
        wb.setBalance(wb.getBalance() + t.getValue());
        Vertex u2 = new Vertex(new State(wa.getBalance(), wb.getBalance()));
        vertices.add(u1);
        vertices.add(u2);
        edges.add(new Edge(u, u1));
        edges.add(new Edge(u, u2));
        saveTransactions();
    }

    public Vertex searchWallet(PublicKey publicKey) {
        for (Vertex v : vertices) {
            Wallet a = (Wallet) v.getO();
            if (a.getPublicKey().equals(publicKey)) {
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
                if (o.getSender() == w.getPublicKey()) {
                    if (o.verifiySignature()) {
                        total -= o.getValue();
                    }
                } else if (o.getReciepient() == w.getPublicKey()) {
                    if (o.verifiySignature()) {
                        total += o.getValue();
                    }
                }
            }
        }
        if (total == w.getBalance() && total >= value) {
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

    /*
    Regreso un numero indice random de la lista de vertices
    solo si este indice hace referencia a un nodo Usuario
     */
    private int randUserVertex() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, vertices.size()+1);
        if(randomNum!=0)randomNum-=1;
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
            if (e.getV() == v && e.getU().getO() instanceof Transaction) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }
        return false;
    }

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

    private void deleteTransactions(Vertex v) {
        for (Edge e : edges) {
            if (e.getV().getO() == v.getO()) {
                vertices.remove(e.getU());
                deleteStates(e.getU());
                edges.remove(e);
            }
        }
    }

    private void deleteStates(Vertex u) {
        for (Edge e : edges) {
            if (e.getV().getO() == u.getO()) {
                vertices.remove(e.getU());
                edges.remove(e);
            }
        }
    }

    private void verifyWallets() {
        for (Vertex v : vertices) {
            if (v.getO() instanceof Wallet) {
                Wallet w = (Wallet) v.getO();
                if (!verifyTransaction(w, w.getBalance())) {
                    for (Edge e : edges) {
                        if (e.getU() == v) {
                            edges.remove(e);
                        }
                    }
                    vertices.remove(v);
                    System.out.println("Billetera removida por fraude");
                }
            }
        }
    }

}
