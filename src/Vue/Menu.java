package Vue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Menu extends JFrame {
    private Integer nbPlayers;
    private ArrayList<String> names;

    public Menu(String gameTitle, boolean menu){
        super(gameTitle);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JLabel player1 = new JLabel("Player name 1 : ");
        JTextField tfPlayer1 = new JTextField(20);
        JPanel pNom = new JPanel();
        pNom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pNom.add(player1);
        pNom.add(tfPlayer1);

        JLabel player2 = new JLabel("Player name 2 : ");
        JTextField tfPlayer2 = new JTextField(20);
        JPanel pPrenom = new JPanel();
        pPrenom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pPrenom.add(player2);
        pPrenom.add(tfPlayer2);

        ButtonGroup bgchoice = new ButtonGroup();
        JRadioButton map1 = new JRadioButton("Map 1", true);
        JRadioButton map2 = new JRadioButton("Map 2", false);
        JPanel mapChoice = new JPanel();
        JLabel labelChoice = new JLabel("Choose your map : ");
        bgchoice.add(map1);
        bgchoice.add(map2);
        mapChoice.add(labelChoice);
        mapChoice.add(map1);
        mapChoice.add(map2);


        p1.setLayout(new GridLayout(5, 1));
        p1.add(pNom);
        p1.add(pPrenom);
        p1.add(mapChoice);

        //retrieve the number of players chosen by the user
        JLabel lnbPlayers = new JLabel("Number of players : ");
        String nbPlayers[] = {"2", "3", "4", "5", "6"};
        JComboBox jComboBox = new JComboBox(nbPlayers);

        JComboBox cbCategorie = jComboBox;
        JPanel pCategorie = new JPanel();
        pCategorie.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pCategorie.add(lnbPlayers);
        pCategorie.add(cbCategorie);

        p2.add(pCategorie);

        JButton bValider = new JButton("Play");
        JButton bAnnuler = new JButton("Quit");



        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        p3.add(bValider);
        p3.add(bAnnuler);

        setLayout(new BorderLayout());
        add(p1, "West");
        add(p2, "East");
        add(p3, "South");
        pack();
        setSize(700,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //once the player clicked on "Play", retrieve all the choices

        /**nb players**/
        Integer playerChoice = (Integer) jComboBox.getEditor().getItem();
        System.out.println(playerChoice);

        /***player names**/ //stacked inside a String list (size : nbPlayers)
        names = new ArrayList<String>();
        for (int i = 0 ; i < playerChoice ; i++)
        {
            //retrieve the name of first player then then player
            String x = tfPlayer1.getText();
            names.add(x);
        }


        //display
        for(String name : names){
            System.out.println(name);
        }


    }
}
