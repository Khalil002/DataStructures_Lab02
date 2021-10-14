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
import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.util.*;
import android.util.Base64;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Wallet {

    public String ownerID;
    public PrivateKey privateKey;
    public PublicKey publicKey;
    private float balance;
    
    public Wallet(String ownerID) {
        this.ownerID = ownerID;
        generateKeyPair();
        this.balance = 0;
    }
    
    public Wallet(String ownerID, String publicKeyString, String privateKeyString, float balance){
        this.ownerID = ownerID;
        byte[] publicKeyByte = Base64.decode(publicKeyString, Base64.NO_WRAP);
        KeyFactory factory = null;
        try {
            factory = KeyFactory.getInstance("ECDSA", "BC");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            publicKey = (PublicKey) factory.generatePublic(new X509EncodedKeySpec(publicKeyByte));
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] privateKeyByte = Base64.decode(privateKeyString, Base64.NO_WRAP);
        try {
            privateKey =  (PrivateKey) factory.generatePublic(new X509EncodedKeySpec(privateKeyByte));
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Wallet.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.balance = balance;
    }

    public void generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            // Initialize the key generator and generate a KeyPair
            keyGen.initialize(ecSpec, random);   //256 bytes provides an acceptable security level
            KeyPair keyPair = keyGen.generateKeyPair();
            // Set the public and private keys from the keyPair
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //returns balance and stores the UTXO's owned by this wallet in this.UTXOs
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance){
        this.balance = balance;
    }

    @Override
    public String toString(){
        String[] keys = keysToString();
        return ownerID+","+keys[0]+","+keys[1]+","+balance;
    }

    private String[] keysToString() {
        byte[] publicKeyByte = publicKey.getEncoded();
        String publicKeyString = Base64.encodeToString(publicKeyByte, Base64.NO_WRAP);
        byte[] privateKeyByte = privateKey.getEncoded();
        String privateKeyString = Base64.encodeToString(privateKeyByte, Base64.NO_WRAP);
        String[] s = {publicKeyString, privateKeyString};
        return s;
    }
}
