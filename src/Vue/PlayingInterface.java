package Vue;

import javax.swing.*;
import java.util.List;


public class PlayingInterface extends JFrame {

    //retrieve players' name (for two players for the moment
    List<String> names;

    public PlayingInterface(String title){
        super(title);
        setSize(780, 450);


    }

    public static void main(String[] args){
        new PlayingInterface("Dice Wars");
    }
}
