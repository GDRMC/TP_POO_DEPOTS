package gdr.tp.tp1;

import java.util.ArrayList;

public class Test {
    
    public static void main(String[]args){
        /*
        Carte c1 = new Carte(Rang.AS, Couleur.CARREAU);
        System.out.println(c1.toString());
        System.out.println("Valeur: "+c1.donneValeur());
        
        Carte c2 = new Carte(Rang.CINQ, Couleur.TREFLE);
        System.out.println(c2.toString());
        System.out.println("Valeur: "+c2.donneValeur());
        */
        
        //Test Carte
        /*
        Carte c11 = new Carte(Rang.DEUX, Couleur.CARREAU);
        Carte c21 = new Carte(Rang.QUATRE, Couleur.CARREAU);

        Error pbAccesseurs = new Error("Pb sur les methodes accesseurs de Carte");
        if(c11.donneRang() != Rang.DEUX)
        {
            throw pbAccesseurs;
        }
        if(c11.donneCouleur() != Couleur.CARREAU)
        {
            throw pbAccesseurs;
        }
        if(c21.donneValeur() != 2) // DEUX a l'index 0, TROIS a l'index 1, etc.
        {
            throw pbAccesseurs;
        }
        System.out.println("Test Carte OK");
        */
        //Test Main
        
        /*
        Joueur j1 = new Joueur("Paul");
        // test du comptage des points
        Error pbNbPoints = new Error("Pb sur la methode Joueur.donneNbPoints");
        if (j1.donneNbCredits() != 0)
        {
            throw pbNbPoints;
        }
        j1.incrementeNbCredits();
        if (j1.donneNbCredits() != 1)
        {
            throw pbNbPoints;
        }
        // test de la main

        // contruction d'une main
        Carte c1 = new Carte(Rang.DEUX, Couleur.CARREAU);
        Carte c2 = new Carte(Rang.QUATRE, Couleur.CARREAU);
        Carte c3 = new Carte(Rang.DEUX, Couleur.TREFLE);
        ArrayList<Carte> cartesMain1 = new ArrayList<Carte>();
        cartesMain1.add(c1);
        cartesMain1.add(c2);
        cartesMain1.add(c3);
        Main m1 = new Main(cartesMain1);
        j1.recoitMain(m1);
        Main m2 = j1.donneMain();

        System.out.println(m1+"\n"+m2);
        
        Error pbDonneMain = new Error("Pb sur la methode Joueur.donneMain");
        if(m1 != m2)
        {
            throw pbDonneMain;
        }
        System.out.println("Test Joueur OK");
        
        */
                
        //Test Partie
        
        
    }
    
}
