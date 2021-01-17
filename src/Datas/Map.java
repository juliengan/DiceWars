package Datas;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Map {

    /*************** ATTRIBUTES ****************/
    private Territory[][] map;
    private ArrayList<Territory> listOfTerritories;
    public int x;
    public int y;
    /******************************************/


    /**************** METHODS *****************/

    public Territory[][] getMap() {
        return map;
    }

    public ArrayList<Territory> getListOfTerritories() {
        return listOfTerritories;
    }

    public Territory getTerritory(int x, int y) {
        return this.map[x][y];
    }

    /*************** CONSTRUCTORS ************/
    //initialize the map from a chosen CSV file
        public Map(File file) throws FileNotFoundException {
            Scanner choice = new Scanner(System.in);
            System.out.println("1 : easy map\n" +
                    "2 : medium \n" +
                    "3 : Difficult map\n ");
            choice.nextInt();

            //switch(choice)
            //....................................
            //....................................

            Scanner sc;
            sc = new Scanner(new File("test.txt"));
            while(sc.hasNext())
                System.out.println(sc.nextLine());

        //Créer un territoire ajouter un id
        // l'ajouter au tableau map  : map.add(t)
    }

    //Initialize a random map
    public Map(int nbPlayers) {

    ;

        Random rand = new Random();

        //alloue la liste des territoires
        this.listOfTerritories = new ArrayList<Territory>();




        for (int i = 0; i < nbPlayers*4; i++) {
            Territory t = new Territory(i+1, 0);
            this.listOfTerritories.add(t);

        }

        //neighbours
        for (Territory t : this.listOfTerritories) {
            t.UpdateneighboringTer(t);
        }

        //Creation of four territory : o is the water
     /*  Territory o = new Territory(0,0);
       Territory t1 = new Territory(1,0);
       Territory t2 = new Territory(2,0);
       Territory t3 = new Territory(3,0);
       Territory t4 = new Territory(4,0);

        //Initialization of neighbours
        t1.UpdateneighboringTer(t3);

        t2.UpdateneighboringTer(t3);
        t2.UpdateneighboringTer(t4);

        t3.UpdateneighboringTer(t1);
        t3.UpdateneighboringTer(t2);
        t3.UpdateneighboringTer(t4);

        t4.UpdateneighboringTer(t2);
        t4.UpdateneighboringTer(t3);*/


        // Add all territories to the list of territories
      /* listOfTerritories.add(o);
       listOfTerritories.add(t1);
       listOfTerritories.add(t2);
       listOfTerritories.add(t3);
       listOfTerritories.add(t4);*/

        int index;


        ArrayList<Territory> temp = new ArrayList<Territory>();
        Iterator<Territory> iterator = this.listOfTerritories.iterator();

        while(iterator.hasNext())
        {
            //Add the object clones
            temp.add((Territory) iterator.next().clone());
        }

        if(nbPlayers == 2){
            x = 2;
            y = 4;
            this.map = new Territory[x][y];
        }
        if(nbPlayers == 3){
            x = 4;
            y = 3;
            this.map = new Territory[x][y];
        }
       if(nbPlayers == 4){
            x = 4;
            y = 4;
            this.map = new Territory[x][y];
        }

      if(nbPlayers == 5){
            x = 4;
            y = 5;
            this.map = new Territory[x][y];
        }


       if(nbPlayers == 6){
            x = 4;
            y = 6;
            this.map = new Territory[x][y];
        }









        while (temp.size() != 0) {


            for (int i = 0; i <x; i++) {
                for (int j = 0; j < y; j++) {
                    if(temp.size() == 0)
                        break;


                    //index au hasard dans la liste de tous les territoires
                    index = rand.nextInt(temp.size());

                    this.map[i][j] = temp.get(index);


                    temp.remove(temp.get(index));
                }
            }
        }



    }
}



