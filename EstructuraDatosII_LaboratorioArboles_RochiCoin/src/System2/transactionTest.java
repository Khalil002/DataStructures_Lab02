/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System2;

import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.Signature;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khali
 */
public class transactionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wallet a = new Wallet("0");
        Wallet b = new Wallet("1");

        Transaction t = new Transaction(a.publicKey, b.publicKey, 10);
        t.generateSignature(a.privateKey);
        
        FileOutputStream sigfos;
        try {
            sigfos = new FileOutputStream("sig");
            sigfos.write(t.signature);
            sigfos.close();
            System.out.println(t.signature.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(transactionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(transactionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FileInputStream sigIn;
        byte[] asf=null;
        try {
            File f = new File("sig");
            asf= Files.readAllBytes(f.toPath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(transactionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(transactionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(asf.toString());
        
    }

}
