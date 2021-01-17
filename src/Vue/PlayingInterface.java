package Vue;

import Datas.Map;
import Logic.Game;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class PlayingInterface extends JFrame {

    //retrieve players' name (for two players for the moment)
   // List<String> names;
    private Map map;
    private DiceWarsInterface menu;
    private JLabel rules;
    private JLabel player2;
    private JLabel player1;
    private JPanel mainPanel;
    private static Game newGame;


    //private static final long serialVersionUID = 1L;


    //playing window

    int row, col;
    JPanel panel;

    //creation of the map
    //goal : retrieve the map of the game and instead of numbers from 0 to 10, the ID of the territory, the ID of the
    //player and the strength of the territory
    //realization : create another constructor for the map to display in the 'Map' class

    JButton[][] jbut = { { new JButton("0"), new JButton("1"), new JButton("2") },
            { new JButton("3"), new JButton("4"), new JButton("5"), new JButton("6"), new JButton("7") },
            { new JButton("8"), new JButton("9") }, { new JButton("10") }
    };


    public PlayingInterface(String title){
        super(title);
        //setLayout(null);
        this.setContentPane(mainPanel);
        mainPanel.setBackground(Color.DARK_GRAY);
        player1.setFont(new Font("Verdana", Font.PLAIN, 14));
        player2.setFont(new Font("Verdana", Font.PLAIN, 14));
        rules.setFont(new Font("Verdana", Font.PLAIN, 18));
        player1.setForeground(Color.PINK);
        player2.setForeground(Color.orange);




        this.pack();


        this.setVisible(true);




    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
         player1 = new JLabel("hey");
        //player1.setText(String.valueOf(newGame.getPlayers().get(0)));
      //  player1.setText("hello");
       // System.out.println(newGame.getPlayers().get(1));
    }

    public static void main(String[] args){
        new PlayingInterface("Dice Wars");
    }


}
