package Vue;

import Datas.Map;

import javax.swing.*;
import java.util.List;


public class PlayingInterface extends JFrame {

    //retrieve players' name (for two players for the moment
    List<String> names;
    private Map map;
    private DiceWarsInterface menu;
    private JLabel rules;
    private JLabel player2;
    private JLabel player1;
    private JPanel mainPanel;

    public PlayingInterface(String title){
        super(title);
        setSize(780, 450);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);


    }

    public static void main(String[] args){
        new PlayingInterface("Dice Wars");
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        player1 = new JLabel();
        player1.setText("Gertrude");
    }
}
