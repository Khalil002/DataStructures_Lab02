/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import System2.Wallet;
import System2.Block;
import System2.Transaction;
import System2.User;
import java.util.ArrayList;
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

    public void insertUser(User user) {
        int randomUser = randUserVertex();
        Vertex v = vertices.get(randomUser);
        Vertex u = new Vertex(user);
        vertices.add(u);
        edges.add(new Edge(v, u));
        insertWallet(u);
    }
    
    public void insertWallet(Vertex v){
        Vertex u = new Vertex(new Wallet());
        vertices.add(u);
        edges.add(new Edge(v,u));
    }
    
    public void insertBlock(Vertex v){
        
    }
    
    public void insertTransaction(Transaction t){
        Vertex v = getLastBlock(vertices.get(1));
        Vertex u = new Vertex(t);
        vertices.add(u);
        edges.add(new Edge(v, u));
        
        //Vertex u1 = new Vertex(new Estado)
    }
    
    public void insertState(){
        
    }
    
    public User searchUser(Vertex v, String publicKey){
        return null;
    }
    
    private Vertex getLastBlock(Vertex v){
        ArrayList<Edge> relatedEdges= new ArrayList();
        for(Edge e: edges){
            if(e.getV().getO() instanceof Block && e.getV().getO() instanceof Block){
                relatedEdges.add(e);
            }
        }
        return getLastBlock(v, relatedEdges);
    }
    
    private Vertex getLastBlock(Vertex v, ArrayList<Edge>relatedEdges){
        Edge edge = null;
        for(Edge e: relatedEdges){
            if(e.getV()==v){
                edge = e;
            }
        }
        if(edge!=null){
            return getLastBlock(edge.getU(), relatedEdges);
        }else{
            return v;
        }
    }

    private int randUserVertex() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, vertices.size() + 1);
        if(vertices.get(randomNum).getO() instanceof User){
            return randomNum;
        }else{
            return randUserVertex();
        }
    }
    

}
