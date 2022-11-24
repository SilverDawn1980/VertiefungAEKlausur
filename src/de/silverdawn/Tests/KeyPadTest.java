package de.silverdawn.Tests;

import de.silverdawn.Controler.CalculateListener;
import de.silverdawn.Controler.ClearListener;
import de.silverdawn.Controler.KeypadListener;
import de.silverdawn.Model.CalculatorMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.util.Random;

public class KeyPadTest {

    @Before
    public void before() {
        CalculatorMemory.getInstance().getStoredString().setLength(0);
    }


    /**
     * Test für die Klasse KeypadListener
     * Punkte : 10
     */
    @Test
    public void testKeypadButton() {
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            int x = r.nextInt(10);
            JButton myButton = new JButton(String.valueOf(x));
            myButton.addActionListener(new KeypadListener());
            myButton.doClick();
            Assert.assertEquals(String.valueOf(x), CalculatorMemory.getInstance().getStoredString().toString());
        }
    }


    /**
     * Test für den C-Button
     * Punkte : 10
     */
    @Test
    public void testClearButton() {
        Random r = new Random();
        int x = r.nextInt(10);
        JButton myButton = new JButton(String.valueOf(x));
        myButton.addActionListener(new KeypadListener());
        myButton.doClick();
        JButton clearButton = new JButton();
        clearButton.addActionListener(new ClearListener());
        clearButton.doClick();
        Assert.assertEquals("", CalculatorMemory.getInstance().getStoredString().toString());
    }

    /**
     * Tests für Additionen, Substraktionen, Multiplikationen, Divisionen
     * Erster Test : 12 Punkte , jeder weitere 6 Punkte
     */

    @Test
    public void testAddition() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int x = r.nextInt(100);
            int y = r.nextInt(100);
            String calcme = String.valueOf(x).concat("+").concat(String.valueOf(y));
            JButton myButton = new JButton(calcme);
            myButton.addActionListener(new KeypadListener());
            myButton.doClick();
            JButton equalsButton = new JButton();
            equalsButton.addActionListener(new CalculateListener());
            equalsButton.doClick();
            int result = x+y;
            Assert.assertEquals(String.valueOf(result), CalculatorMemory.getInstance().getStoredString().toString());
        }
    }


    @Test
    public void testSubstract() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int x = r.nextInt(100);
            int y = r.nextInt(100);
            String calcme = String.valueOf(x).concat("-").concat(String.valueOf(y));
            JButton myButton = new JButton(calcme);
            myButton.addActionListener(new KeypadListener());
            myButton.doClick();
            JButton equalsButton = new JButton();
            equalsButton.addActionListener(new CalculateListener());
            equalsButton.doClick();
            int result = x-y;
            Assert.assertEquals(String.valueOf(result), CalculatorMemory.getInstance().getStoredString().toString());
        }
    }


    @Test
    public void testMult() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int x = r.nextInt(100);
            int y = r.nextInt(100);
            String calcme = String.valueOf(x).concat("*").concat(String.valueOf(y));
            JButton myButton = new JButton(calcme);
            myButton.addActionListener(new KeypadListener());
            myButton.doClick();
            JButton equalsButton = new JButton();
            equalsButton.addActionListener(new CalculateListener());
            equalsButton.doClick();
            int result = x*y;
            Assert.assertEquals(String.valueOf(result), CalculatorMemory.getInstance().getStoredString().toString());
        }
    }

    @Test
    public void testDiv() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            double x = r.nextInt(100);
            double y = r.nextInt(100);
            String calcme = String.valueOf(x).concat("/").concat(String.valueOf(y));
            JButton myButton = new JButton(calcme);
            myButton.addActionListener(new KeypadListener());
            myButton.doClick();
            JButton equalsButton = new JButton();
            equalsButton.addActionListener(new CalculateListener());
            equalsButton.doClick();
            double result = x/y;
            Assert.assertEquals(String.valueOf(result), CalculatorMemory.getInstance().getStoredString().toString());
        }
    }
}
