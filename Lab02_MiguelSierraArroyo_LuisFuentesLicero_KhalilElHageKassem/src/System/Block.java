package System;

import java.util.ArrayList;
import java.util.Date;

/*
 * @Group #9
 */
public class Block {

    private String hash;
    private String previousHash;
    private String merkleRoot;
    private long timeStamp;
    private int nonce;

    //Constructor 
    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    //Calcula el hash del bloque
    public String calculateHash() {
        String calculatedhash = Util.applySha256(
                previousHash
                + Long.toString(timeStamp)
                + Integer.toString(nonce)
                + merkleRoot
        );
        return calculatedhash;
    }

    //Mina el bloque cuando esta lleno
    public void mineBlock(int difficulty, ArrayList<Transaction> transactions) {
        merkleRoot = Util.getMerkleRoot(transactions);
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public int getNonce() {
        return nonce;
    }

    @Override
    public String toString() {
        return "hash=" + hash;
    }

}
