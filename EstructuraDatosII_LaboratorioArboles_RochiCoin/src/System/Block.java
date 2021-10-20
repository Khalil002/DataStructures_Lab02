
package System;

import java.util.ArrayList;
import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    public String merkleRoot;
    public long timeStamp; 
    public int nonce;

    //Constructor 
    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    //Calculate new hash based on blocks contents
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash
                + Long.toString(timeStamp)
                + Integer.toString(nonce)
                + merkleRoot
        );
        return calculatedhash; 
    }
    
    /*
    public void mineBlock(int difficulty, ArrayList<Transaction> transactions) {
        merkleRoot = StringUtil.getMerkleRoot(transactions);
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }*/

}