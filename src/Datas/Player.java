package Datas;

import Exceptions.InvalidAttackedTerritory;
import Exceptions.InvalidAttackingTerritory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

    /*************** ATTRIBUTES ****************/
    private final int id ;
    private ArrayList<Territory> territories;
    private String name;
    private boolean lost = false;
    /*******************************************/


    /****************** METHODS ***************/
    // Player (int id)
    // attackTerritory (Scanner input)
    // getTerritorybyId (int id)
    /*****************************************/


    /*************** CONSTRUCTOR **************/
    public Player(Integer id) {
        territories = new ArrayList<>();
        this.id = id;
        //name et boolean lost ?
    }


    /*********** ATTACK TERRITORY ************/
    public Move attackTerritory(Scanner input) throws InvalidAttackedTerritory, InvalidAttackingTerritory {

        Move move = null;
        Integer attack;//id of the attacking territory
        Integer defend;//id of the attacked territory

        // While the move is not valid, we continue to ask to the player
        while (move == null) {

            System.out.print("Enter your territory : ");
            attack = input.nextInt();

            // If the territory doesn't belong to the player
            if (!this.territories.contains(getTerritoryById(attack))) {
                throw new InvalidAttackingTerritory("This is not your territory, you can't attack");
            }
            // If the territory doesn't have enough strength to attack
            else if (getTerritoryById(attack).getStrength() <= 1) {
                throw new InvalidAttackingTerritory("This territory doesn't have enough strength to attack");
                //return move;
            }

            //---------------------------------------------------------------------------------


            System.out.print("Enter the territory you want to attack : ");
            defend = input.nextInt();

            // If the territory is not a neighbour
            if (getTerritoryById(attack).getNeighboringTer().contains(getTerritoryById(defend))) {
                throw new InvalidAttackedTerritory("The territory you want to attack is not your neighbour ");
            }

            //If the territory belongs to the player
            else if (this.territories.contains(getTerritoryById(defend))) {
                throw new InvalidAttackedTerritory("You can't attack your own territory ! ");
            }

            // Creation of the move we can leave the loop and return this.
            move = new Move(attack, defend);
            System.out.println("Your move is : (" + move.getIdAttacker() + " " + move.getIdDefender() + ")");

        }
            return move;

    }


    /*********** GET TERRITORY BY ID ************/
    public Territory getTerritoryById(int id){

        for(Territory t : this.territories){
            if(t.getId() == id){
                return  t;
            }
        }
        return null;
    }




    /*********** SETTERS ************/

    public void setName(String name) {
        this.name = name;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }


    /*********** GETTERS ***********/

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }

    public ArrayList<Territory> getTerritories() {
        return territories;
    }

    public boolean isLost() {
        return lost;
    }
}
