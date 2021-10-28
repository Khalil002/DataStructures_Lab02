/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

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

    private String transactionId; 
    private PublicKey sender; 
    private PublicKey reciepient; 
    private float value;
    private long checksumAlpha;
    private long checksumBeta;
    private static int sequence = 0; 

    //Constructor normal
    public Transaction(PublicKey from, PublicKey to, float value) {
        this.sender = from;
        this.reciepient = to;
        this.value = value;
        this.transactionId = calculateHash();
        
    }
    
    //Constructor (Abrir archivos)
    public Transaction(String senderStringKey, String reciepientStringKey, float value, long checksumAlpha, long checksumBeta) {
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
        this.checksumAlpha = checksumAlpha;
        this.checksumBeta = checksumBeta;
        this.transactionId = calculateHash();
    }

    //Calcula el hash de la transaccion
    private String calculateHash() {
        sequence++; //Asegura que no pueda haber 2 transacciones con el mismo hash
        return StringUtil.applySha256(
                StringUtil.getStringFromKey(sender)
                + StringUtil.getStringFromKey(reciepient)
                + Float.toString(value) + sequence
        );
    }

    //genera la firma de la transaccion
    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(sender) 
                + StringUtil.getStringFromKey(reciepient) 
                + Float.toString(value);
        byte[] dataB = data.getBytes();
        checksumBeta = StringUtil.getCRC32Checksum(dataB);
        data = data + StringUtil.getStringFromKey(privateKey);
        dataB = data.getBytes();
        checksumAlpha = StringUtil.getCRC32Checksum(dataB);
    }

    //Verifica si hubo algun cambio en los datos de la transaccion
    public boolean verifiySignature() {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value);
        byte[] dataB = data.getBytes();
        return checksumAlpha - checksumBeta == checksumAlpha - StringUtil.getCRC32Checksum(dataB);
    }

    public String getTransactionId() {
        return transactionId;
    }

    public PublicKey getSender() {
        return sender;
    }

    public PublicKey getReciepient() {
        return reciepient;
    }

    public float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionId=" + transactionId + ", sender=" + sender + ", reciepient=" + reciepient + ", value=" + value + ", checksumAlpha=" + checksumAlpha + ", checksumBeta=" + checksumBeta + '}';
    }
    
    public String saveString(){
        return StringUtil.getStringFromKey(sender)+","+StringUtil.getStringFromKey(reciepient)+","+value+","+checksumAlpha+","+checksumBeta+"\n";
    }
}