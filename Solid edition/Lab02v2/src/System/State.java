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
public class State {
    private final float b1;
    private final float b2;
    
    public State(float b1, float b2) {
        this.b1 = b1;
        this.b2 = b2;
    }

    public float getB1() {
        return b1;
    }
    public float getB2() {
        return b2;
    }

    @Override
    public String toString() {
        return "balance1=" + b1 + " balance2=" + b2;
    }
    
}
