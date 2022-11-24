package de.silverdawn.View;

import de.silverdawn.Controler.CalculateListener;
import de.silverdawn.Controler.ClearListener;
import de.silverdawn.Controler.KeypadListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    private JPanel contentPane;
    private JPanel keysPanel;
    private JPanel displayPanel;

    public CalculatorView(){

        this.setTitle("JCalc");

        keysPanel = new JPanel();
        this.keysPanel.setLayout(new GridBagLayout());

        int posx = -1;
        int posy = 2;
        for (int i = 1; i < 10; i++) {
            if(posy >= 0){
                if(posx < 2){
                    posx++;
                }
                else{
                    posx = 0;
                    posy--;
                }
                addKeyPadButton(String.valueOf(i),posx,posy,1,1);
            }
        }
        addKeyPadButton("+",3,0,1,1);
        addKeyPadButton("-",3,1,1,1);
        addKeyPadButton("*",3,2,1,1);
        addKeyPadButton("/",3,3,1,1);

        JButton calculate = new JButton("=");
        JButton clear = new JButton("C");
        addKeyPadButton(String.valueOf(0),1,3,2,1);
        addKeyPadButton(".",0,3,1,1);
        addButtontoKeypad("C",4,0,1,2,new ClearListener());
        addButtontoKeypad("=",4,2,1,2,new CalculateListener());

        JTextField displayText = new JTextField();
        displayText.setEnabled(false);
        Font displayFont = new Font("Default", Font.PLAIN,32);
        displayText.setFont(displayFont);

        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        contentPane.add(displayText,gridBagConstraints);
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        contentPane.add(keysPanel,gridBagConstraints);



        this.setContentPane(contentPane);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void addKeyPadButton(String caption,int x,int y,int width,int height){
        addButtontoKeypad(caption, x, y, width, height,new KeypadListener());
    }

    private void addButtontoKeypad(String caption, int x, int y, int width, int height, ActionListener action) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = width;
        gridBagConstraints.gridheight = height;
        JButton newButton = new JButton(caption);
        newButton.setPreferredSize(new Dimension(50,50));
        newButton.addActionListener(action);
        this.keysPanel.add(newButton,gridBagConstraints);
    }

}
