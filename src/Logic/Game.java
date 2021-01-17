package Logic;

import Datas.Map;
import Datas.Move;
import Datas.Player;
import Datas.Territory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    /*************** ATTRIBUTES ****************/
    private  Map map;
    private ArrayList <Territory> allTerritories;
    private final ArrayList<Player> players;
    /******************************************/



    /************** METHODS ***************/
    // void displayMap()
    // void territoriesDistribution (ArrayList<Territory> allTerritories, Random random)
    // void distributionStrengthTerritory (int totalStrength, Player p, Random r, boolean firstDistribution)
    // Territory getTerritoryById(int id)
    // void infoPlayer(Player p)
    // void throwDices(Move move)
    // int nbOfcontiguousTerritory(Player p)
    // int askAction(Scanner input, int indexPlayer)
    // void isPlayerLoose()
    // boolean isEndTurn(boolean endTurn, int firstPlayer, int indexPlayer)
    // Player whoIsWinner()
    // boolean checkEnd()
    /*************************************/




    /*************** CONSTRUCTOR **************/
    public Game(ArrayList<Player> players, Map newMap){


        allTerritories = new ArrayList<Territory>();
        this.players = players;
        this.map = newMap;
    }




    /************* DISPLAY MAP *******************/

    public void displayMap(int nbPlayers){

        System.out.println("=============== MAP ===============");

        for(int y = 0; y < this.map.x; y++) {
            System.out.println();

            for (int x = 0; x < this.map.y; x++){

                System.out.print("[T : " + this.map.getMap()[y][x].getId() + "  ");
                System.out.print("P" + this.map.getMap()[y][x].getPlayerId() + "  ");
                System.out.print("DICE : "+this.map.getMap()[y][x].getStrength() + "  ] ");

            }
            System.out.println();

        }
        System.out.println("===================================");
        System.out.println();

    }




    /*********** TERRITORIES DISTRIBUTION *********/

    public void territoriesDistribution( Random random){
        System.out.println("ter size : "+this.allTerritories.size());

        int playerIndex = 0;

        // Create a random territory
        Territory randomTerritory = new Territory(0,0);

        // Create a deep copy of allTerritories to avoid changes
        ArrayList<Territory> temp = new ArrayList<Territory>();
        Iterator<Territory> iterator = this.allTerritories.iterator();


        while(iterator.hasNext())
        {
            //Add the object clones
            temp.add((Territory) iterator.next().clone());
        }
        int nbTerritoryToDistribute = this.allTerritories.size();

        // While there are territories to distribute in th list
        while(temp.size() != 0){

            //choose a random index among the size of the list
            int randomIndex  = ThreadLocalRandom.current().nextInt(temp.size());
            //System.out.println("index random"+ randomIndex);
            //System.out.println("territoire random : "+ temp.get(randomIndex).getId());

            //set the player id in the map

            for(int y = 0; y < this.map.x; y++) {

                for (int x = 0; x < this.map.y; x++) {

                    if(temp.get(randomIndex).getId() == this.map.getMap()[y][x].getId()) {
                        this.map.getMap()[y][x].setPlayerId(players.get(playerIndex).getId());
                        //System.out.println("je donne le territoire"+ this.map.getMap()[y][x].getId()+" au player "+ players.get(playerIndex).getId() );
                    }
                }
            }

            //set the player id in all territories

            for(Territory t : this.allTerritories){
                if(t.getId() == temp.get(randomIndex).getId())
                    t.setPlayerId(players.get(playerIndex).getId());
            }



            //give the territory to the current player
            players.get(playerIndex).getTerritories().add(temp.get(randomIndex));



            temp.remove(temp.get(randomIndex));
            playerIndex++;
            if(playerIndex == players.size() )
                playerIndex = 0;



       }

      for(Player p : this.players){
          System.out.println("player"+ p.getName()+ "nb ter"+p.getTerritories().size());
      }
    }




    /*********** STRENGTH DISTRIBUTION *********/

    public void distributionStrengthTerritory(int totalStrength, Player p, Random r, boolean firstDistribution) {
        System.out.println("Player " + p.getId() + " : " + p.getName().toUpperCase());

        int randomStrength;
        //we remove to the total strength the number of territories of the player because we set at 1 the strength of each territory
        int MAX_STRENGTH = (totalStrength - p.getTerritories().size());
        int indexTerritory = 0;

        //if this the first distribution
        if (firstDistribution) {

            //By default, each territory has 1 strength
            for (Territory t : p.getTerritories()) {
                t.setStrength(1);

                for(int y = 0; y < this.map.x; y++) {

                    for (int x = 0; x < this.map.y; x++) {
                        if(this.map.getMap()[y][x].getId().equals(t.getId()))

                            this.map.getMap()[y][x].setStrength(1);
                    }
                }

            }




        }
        else{
            MAX_STRENGTH = totalStrength;
        }


        while(MAX_STRENGTH > 0){

            randomStrength =  (int)(Math.random() * MAX_STRENGTH) + 1;//random.nextInt(6);

            if(p.getTerritories().get(indexTerritory).getStrength() + randomStrength >= 8)
                continue;

            else{

                for(int y = 0; y < this.map.x; y++) {

                    for (int x = 0; x < this.map.y; x++) {
                        if(this.map.getMap()[y][x].getId().equals(p.getTerritories().get(indexTerritory).getId()))

                        this.map.getMap()[y][x].addStrength(randomStrength);
                    }
                }
                p.getTerritories().get(indexTerritory).addStrength(randomStrength);
                System.out.println("on met au territoire "+ p.getTerritories().get(indexTerritory).getId()+"une force de "+ randomStrength);
            }

        MAX_STRENGTH = MAX_STRENGTH-randomStrength;
            System.out.println("Max strength : "+ MAX_STRENGTH);
            indexTerritory++;
            if(indexTerritory == p.getTerritories().size())
                indexTerritory = 0;

        }


    }

    //This function return a territory for a given ID
    public Territory getTerritoryById(int id){
        for(Territory t : this.allTerritories ){
            if(t.getId() == id){
                return  t;
            }
        }
        System.out.println("null");
        return null;
    }

    /*********** INFO PLAYER *********/

    public void infoPlayer(Player p)
    {
        System.out.println("===================================");
        System.out.println("PLAYER NAME : " + p.getName().toUpperCase());
        System.out.println("TERRITORIES : ");
        for(Territory t : p.getTerritories()) {
            System.out.println("--> "+t.getId() +" (strength : "+ t.getStrength()+")" );
            System.out.println("Neighbour : ");
            for (Territory v : t.getNeighboringTer()) {

                System.out.println(v.getId() +", ");
            }
        }
        System.out.println("===================================");



    }

    /*********** THROW DICES *********/

    public void throwDices(Move move) {
        Random random = new Random();

        Territory attackerTerritory = getTerritoryById(move.getIdAttacker());
        Territory defenderTerritory = getTerritoryById(move.getIdDefender());

        Player attackerPlayer = getPlayerfromTerritory(attackerTerritory);
        Player defendPlayer = getPlayerfromTerritory(defenderTerritory);


        int sumDiceAttacker = 0;
        int sumDiceDefender = 0;

        for (int i = 0; i < attackerTerritory.getStrength(); i++) {

            //random number bewteen 1 and 6
            sumDiceAttacker += (int)(Math.random() * 6) + 1;//random.nextInt(6);

        }
        System.out.println("Attacker result : " + sumDiceAttacker);


        for (int i = 0; i < defenderTerritory.getStrength() ; i++) {

            sumDiceAttacker += (int)(Math.random() * 6) + 1;//random.nextInt(6);
        }
        System.out.println("Defender result : " + sumDiceDefender);


        if (sumDiceAttacker > sumDiceDefender) {

            System.out.println("ATTACKER WINS");

            //the attackerTerritory take the territory, we add it to his list
            attackerPlayer.getTerritories().add(defenderTerritory);


            //change the player of the taken territory
            defenderTerritory.setPlayerId(attackerPlayer.getId());


            //Remove the territory for the loser
           defendPlayer.getTerritories().remove(defenderTerritory);

            //he moves all his dice on the new territory exept 1
            defenderTerritory.setStrength(attackerTerritory.getStrength()-1);

            attackerTerritory.setStrength(1);

            for(Player p: this.players){
                infoPlayer(p);
            }



        }
        else {
            attackerTerritory.setStrength(1);
            System.out.println("DEFENDER WINS");
            for(Player p: this.players){
                infoPlayer(p);
            }
        }



    }


    public int nbOfcontiguousTerritory(Player p) {

        int nb = 0;

        System.out.println("Liste de ses territoires");
        for(Territory t : p.getTerritories()){
            System.out.println(t.getId());

        }

        for (Territory t : p.getTerritories()) {
            for (Territory v : t.getNeighboringTer()) {
                if (p.getTerritories().contains(v)) {
                    System.out.println("neighbor : "+t.getId() + "and"+v.getId());
                    nb++;
                }
            }


        }
        if(nb ==4)
            return nb-1;
        else
          return nb;
    }



    /*********** ASK AN ACTION *********/

    public int askAction(Scanner input, int indexPlayer){
        int choice;
        System.out.println("Player "+ this.players.get(indexPlayer).getId() +" : "+ this.players.get(indexPlayer).getName()+", it's your turn.");
        System.out.println("1.Attack");
        System.out.println("2.Pass");

        return choice = input.nextInt();

    }

    /*********** CHECK IF A PLAYER LOOSE *********/

    public void isPlayerLoose() {

        for (Player p : this.players) {
            if (p.getTerritories().size() == 0) {
                System.out.println("Player " + p.getName() + " doesn't have any territory, he lost !");
                p.setLost(true);
            }
        }
    }

    /*********** CHECK END TURN *********/
    public boolean isEndTurn(boolean endTurn, int firstPlayer, int indexPlayer){

        // If the first player play again, its the end of the turn
        if( indexPlayer == firstPlayer) {
            System.out.println("END TURN");
            return true;
        }
        return false;
    }

    /*********** CHECK END *********/

    public boolean checkEnd(){
        int cpt =0;

        for(Player p: this.players){

            if(p.isLost() == false)
                cpt++;
        }
        if(cpt == 1)
            return true;
        else
            return  false;

    }

    /*********** WHO IS WINNER *********/
    public Player whoIsWinner()
    {
        for(Player p : this.players){
            if(p.isLost() ==false)
                return p;
        }

        return  null;
    }



    /*********** GETTERS *********/

    public Player getPlayerfromTerritory(Territory t){
        for(Player p :this.players){
            if(p.getTerritories().contains(t))
                return p;
        }

        return null;

    }

    public Map getMap() {
        return map;
    }

    public ArrayList<Territory> getAllTerritories() {
        return allTerritories;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    //public String getName(Integer id){return players(id);}

    /*********** SETTERS *********/
    public void setAllTerritories(ArrayList<Territory> allTerritories) {
        this.allTerritories = allTerritories;
    }
}
