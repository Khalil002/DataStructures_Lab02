package System;

/*
 * @Group #9
 */
import android.util.Base64;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transaction {

    private final String transactionId;
    private PublicKey sender;
    private PublicKey reciepient;
    private final float value;
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
        return Util.applySha256(
                Util.getStringFromKey(sender)
                + Util.getStringFromKey(reciepient)
                + Float.toString(value) + sequence
        );
    }

    //genera la firma de la transaccion
    public void generateSignature(PrivateKey privateKey) {
        String data = Util.getStringFromKey(sender)
                + Util.getStringFromKey(reciepient)
                + Float.toString(value);
        byte[] dataB = data.getBytes();
        checksumBeta = Util.getCRC32Checksum(dataB);
        data = data + Util.getStringFromKey(privateKey);
        dataB = data.getBytes();
        checksumAlpha = Util.getCRC32Checksum(dataB);
    }

    //Verifica si hubo algun cambio en los datos de la transaccion
    public boolean verifiySignature() {
        String data = Util.getStringFromKey(sender) +
                Util.getStringFromKey(reciepient) + Float.toString(value);
        byte[] dataB = data.getBytes();
        return checksumAlpha - checksumBeta == checksumAlpha - Util.getCRC32Checksum(dataB);
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
        return "transactionId=" + transactionId;
    }

    public String saveString() {
        return Util.getStringFromKey(sender) + "," + Util.getStringFromKey(reciepient) + "," + value + "," + checksumAlpha + "," + checksumBeta + "\n";
    }
}
