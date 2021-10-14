/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System2;

/**
 *
 * @author khali
 */
import android.util.Base64;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transaction {

    public String transactionId; // this is also the hash of the transaction.
    public PublicKey sender; // senders address/public key.
    public PublicKey reciepient; // Recipients address/public key.
    public float value;
    public byte[] signature; // this is to prevent anybody else from spending funds in our wallet.

    ////public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    ////public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();

    private static int sequence = 0; // a rough count of how many transactions have been generated. 

    // Constructor: 
    public Transaction(PublicKey from, PublicKey to, float value) {
        this.sender = from;
        this.reciepient = to;
        this.value = value;
    }
    
    //NotWorkingYet
    //Constructor for when adding data from .csv
    public Transaction(String transactionId, String senderStringKey, String reciepientStringKey, String signature, float value) {
        this.transactionId = transactionId;
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        KeyFactory factory = null;
        try {
            factory = KeyFactory.getInstance("ECDSA", "BC");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] senderKeyByte = Base64.decode(senderStringKey, Base64.NO_WRAP);
        byte[] reciepientKeyByte = Base64.decode(reciepientStringKey, Base64.NO_WRAP);
        try {
            this.sender = (PublicKey) factory.generatePublic(new X509EncodedKeySpec(senderKeyByte));
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.reciepient = (PublicKey) factory.generatePublic(new X509EncodedKeySpec(reciepientKeyByte));
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.value = value;
    }

    // This Calculates the transaction hash (which will be used as its Id)
    private String calculateHash() {
        sequence++; //increase the sequence to avoid 2 identical transactions having the same hash
        return StringUtil.applySha256(
                StringUtil.getStringFromKey(sender)
                + StringUtil.getStringFromKey(reciepient)
                + Float.toString(value) + sequence
        );
    }

    //Signs all the data we dont wish to be tampered with.
    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value);
        signature = StringUtil.applyECDSASig(privateKey, data);
    }

    //Verifies the data we signed hasnt been tampered with
    public boolean verifiySignature() {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value);
        return StringUtil.verifyECDSASig(sender, data, signature);
    }

    //NotWorkingYet
    @Override
    public String toString(){
        byte[] publicKeyByte = sender.getEncoded();
        String publicKeyString = Base64.encodeToString(publicKeyByte, Base64.NO_WRAP);
        byte[] public2KeyByte = reciepient.getEncoded();
        String public2KeyString = Base64.encodeToString(public2KeyByte, Base64.NO_WRAP);
        return transactionId+","+publicKeyString+","+public2KeyString+","+signature;
    }
}