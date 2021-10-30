package System;

/*
 * @Group #9
 */
public class State {

    private final float balanceSender;
    private final float balanceRecipient;

    public State(float b1, float b2) {
        this.balanceSender = b1;
        this.balanceRecipient = b2;
    }

    public float getBalanceSender() {
        return balanceSender;
    }

    public float getBalanceRecipient() {
        return balanceRecipient;
    }

    @Override
    public String toString() {
        return "Remitente= " + balanceSender + " Recipiente= " + balanceRecipient;
    }

}
