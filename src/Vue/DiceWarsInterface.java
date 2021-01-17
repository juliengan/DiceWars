package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiceWarsInterface extends JFrame{
    private JPanel mainPanel;
    private JButton OKButton;
    private JLabel tfname;
    private JTextField enterYourNameTextField;
    private JTextField textField1;
    private JLabel Name2;
    private JButton playButton;
    List players;

    private PlayingInterface playingmode = new PlayingInterface("Dice Wars");


    public DiceWarsInterface(String title){
        super(title);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        setVisible(true);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String P1 = enterYourNameTextField.getText();
                String P2 = textField1.getText();
                setVisible(false);
                playingmode.setVisible(true);
                players.add(P1);
                players.add(P2);
            }
        });
    }

    public List getPlayers(){return players;}

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args){
        new DiceWarsInterface("Dice Wars");
    }
}
