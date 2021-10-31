package System;

import java.security.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/*
 * @Group #9
 */
public class Util {

    //Encripta la input con Sha256
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Recibe una llave y la convierte en String usando Base64 encoding
    public static String getStringFromKey(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    //Recibe un ArrayList de transacciones y calcula la merkleRoot correspondiente
    public static String getMerkleRoot(ArrayList<Transaction> transactions) {
        int count = transactions.size();
        ArrayList<String> previousTreeLayer = new ArrayList<String>();
        for (Transaction transaction : transactions) {
            previousTreeLayer.add(transaction.getTransactionId());
        }
        ArrayList<String> treeLayer = previousTreeLayer;
        while (count > 1) {
            treeLayer = new ArrayList<String>();
            for (int i = 1; i < previousTreeLayer.size(); i++) {
                treeLayer.add(applySha256(previousTreeLayer.get(i - 1) + previousTreeLayer.get(i)));
            }
            count = treeLayer.size();
            previousTreeLayer = treeLayer;
        }
        String merkleRoot = (treeLayer.size() == 1) ? treeLayer.get(0) : "";
        return merkleRoot;
    }

    //Calcula el Checksum del array de bytes dado
    public static long getCRC32Checksum(byte[] bytes) {
        Checksum crc32 = new CRC32();
        crc32.update(bytes, 0, bytes.length);
        return crc32.getValue();
    }

}
