package Vue;

import javax.swing.*;
import java.awt.*;

public class Playing extends JFrame {
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

    public Playing(String title) {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        for (row = 0; row < jbut.length; row++) {
            for (col = 0; col < jbut[row].length; col++) {
                add(jbut[row][col], gbc);

                gbc.gridx++;
                if (gbc.gridy == 0 && gbc.gridx >= 3) {
                    gbc.gridy++;
                    gbc.gridx = 0;
                } else if (gbc.gridy == 1 && gbc.gridx >= 5) {
                    gbc.gridy++;
                    gbc.gridx = 0;
                }

            }

        } }
}
