package de.silverdawn.Model;

public class CalculatorMemory {

    public static CalculatorMemory _instance;

    StringBuilder storedString;

    public static CalculatorMemory getInstance(){
        return new CalculatorMemory();
    }

    public StringBuilder getStoredString(){
        this.storedString = new StringBuilder();
        return this.storedString;
    }
}
