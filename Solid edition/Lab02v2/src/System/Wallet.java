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
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.*;
import android.util.Base64;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Wallet {

    private String ownerID;
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private float balance;
    
    //Constructor normal
    public Wallet(String ownerID) {
        generateKeyPair();
        this.ownerID = ownerID;
        this.balance = 0;
        
    }
    
    //Constructor (abrir archivos)
    public Wallet(String ownerID, String publicKeyString, String privateKeyString, float balance){
        this.ownerID = ownerID;
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        KeyFactory factory = null;
        try {
            factory = KeyFactory.getInstance("ECDSA", "BC");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] publicKeyByte = Base64.decode(publicKeyString, Base64.NO_WRAP);
        byte[] privateKeyByte = Base64.decode(privateKeyString, Base64.NO_WRAP);
        try {
            publicKey = (PublicKey) factory.generatePublic(new X509EncodedKeySpec(publicKeyByte));
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            privateKey = (PrivateKey) factory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyByte));
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.balance = balance;
    }

    //Genera las llaves publicas y privadas
    public void generateKeyPair() {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            
            keyGen.initialize(ecSpec, random);   
            KeyPair keyPair = keyGen.generateKeyPair();
            
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getOwnerID(){
        return ownerID;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }
    public PublicKey getPublicKey() {
        return publicKey;
    }
    public float getBalance() {
        return balance;
    }
    
    public void setBalance(float balance){
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Llave pública=" + StringUtil.getStringFromKey(publicKey);
    }

    public String saveString() {
        return ownerID+","+StringUtil.getStringFromKey(publicKey)+","+StringUtil.getStringFromKey(privateKey)+","+balance+"\n";
    }
}
