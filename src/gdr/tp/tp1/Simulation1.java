package gdr.tp.tp1;


import java.util.ArrayList;

//Equivalent classe TestPartie
public class Simulation1
{
    public static void main(String[] args)
    {
        // Test 1 : deux mains differentes

        // contruction d'une premiere main de 0 + 2 + 0 = 2 pts
        // la valeur d'une carte est donne par l'ordre du rang dans
        // le type enumere
        Carte c1 = new Carte(Rang.DEUX, Couleur.CARREAU);
        Carte c2 = new Carte(Rang.QUATRE, Couleur.CARREAU);
        Carte c3 = new Carte(Rang.DEUX, Couleur.TREFLE);
        ArrayList<Carte> cartesMain1 = new ArrayList<Carte>();
        cartesMain1.add(c1);
        cartesMain1.add(c2);
        cartesMain1.add(c3);
        Main m1 = new Main(cartesMain1);

        // contruction d'une seconde main de 12 + 2 + 11 = 25 pts
        Carte c4 = new Carte(Rang.AS, Couleur.CARREAU);
        Carte c5 = new Carte(Rang.QUATRE, Couleur.COEUR);
        Carte c6 = new Carte(Rang.ROI, Couleur.TREFLE);
        ArrayList<Carte> cartesMain2 = new ArrayList<Carte>();
        cartesMain2.add(c4);
        cartesMain2.add(c5);
        cartesMain2.add(c6);
        Main m2 = new Main(cartesMain2);

        // creation des joueurs
        Joueur paul = new Joueur("Paul");
        Joueur fred = new Joueur("Fred");
        paul.recoitMain(m1);
        // on donne a Fred la meme main qu'a Paul
        fred.recoitMain(m1);
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs.add(paul);
        joueurs.add(fred);

        // la partie est configuree pour etre gagnee en 1 pt
        Partie partie = new Partie(joueurs, new Jeu(), 3, 1);

        // Test 1 : deux mains identiques
        ArrayList<Joueur> classementJoueursT1 = partie.donneClassementTour();
        for (Joueur joueur : classementJoueursT1)
        {
            System.out.print(joueur + " a la main : " + joueur.donneMain());
            System.out.println(", valeur : " + joueur.donneMain().donneValeur() + " pts.");
        }
        Error pbDonneClassementTour =
                new Error("Pb sur la methode donneClassementTour de la classe Partie");

        // il doit y avoir 2 elements dans la liste
        if (classementJoueursT1.size() != 2)
        {
            throw pbDonneClassementTour;
        }
        Joueur gagnantTour = partie.donneGagnantTour();
        Error pbDonneGagnantTour = new Error("Pb sur la methode Partie.donneGagnantTour");
        // il ne doit pas exister de gagnant...
        if (gagnantTour != null)
        {
            throw pbDonneGagnantTour;
        }
        else
        {
            System.out.println("Aucun gagnant pour le tour.");
        }

        // Test 2 : deux mains de valeurs differentes : val(m1) < val(m2)
        fred.recoitMain(m2);
        ArrayList<Joueur> classementJoueursT2 = partie.donneClassementTour();
        for (Joueur joueur : classementJoueursT2)
        {
            System.out.print(joueur + " a la main : " + joueur.donneMain());
            System.out.println(", valeur : " + joueur.donneMain().donneValeur() + " pts.");
        }
        // il doit y avoir 2 elements dans la liste
        if (classementJoueursT2.size() != 2)
        {
            throw pbDonneClassementTour;
        }
        // le gagnant du tour doit etre "Fred"
        if (classementJoueursT2.get(0) != fred)
        {
            throw pbDonneClassementTour;
        }
        gagnantTour = partie.donneGagnantTour();

        if (gagnantTour != fred)
        {
            throw pbDonneGagnantTour;
        }
        else
        {
            System.out.println(gagnantTour + " gagne le tour.");
        }

        // Test 3 : on verifie que le gagnant de la partie est Fred
        // partie gagn\'ee en 1 pt
        Joueur gagnantPartie = partie.donneGagnantPartie();
        if (gagnantPartie != fred)
        {
            throw new Error("Pb sur la methode Partie.donneGagnantPartie");
        }
        else
        {
            System.out.println("Gagnant de la partie = " + gagnantPartie);
        }
        System.out.println("Test Joueur OK");
    }
}
