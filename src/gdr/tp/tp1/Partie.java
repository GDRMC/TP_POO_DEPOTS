package gdr.tp.tp1;

import java.util.ArrayList;

public class Partie {
    
    //valeurs fixes de la partie
    private final int NB_CARTES_MAIN;
    private final int NB_POINTS_GAGNANTS;

    private ArrayList<Joueur> joueurs;
    private Jeu jeu;
    
    public Partie(ArrayList<Joueur> liste, Jeu jdc, int nbCartesMain, int nbPointsGagnants){
        //convertit l'arraylist de joueurs pour les inscrire dans la partie
        this.joueurs = liste;
        //affecte le jeu entré en paramètre dans la partie
        this.jeu = jdc;
        //nombre de carte distribuées par main
        this.NB_CARTES_MAIN = nbCartesMain;
        //nombre de points pour gagner la partie
        this.NB_POINTS_GAGNANTS = nbPointsGagnants;
    }
    
    public void distribuerCartes(){
        //Mélange le jeu
        this.jeu.melanger();
        //distribuer les cartes a tous les joueurs
        for(int i=0;i<this.joueurs.size();i++){
            //crée la main à donner au joueur
            Main m = this.jeu.donnerCartes(NB_CARTES_MAIN);
            //attribue la main au joueurs
            this.joueurs.get(i).recoitMain(m);
        }
    }
    
    public ArrayList<Joueur> donneClassementTour(){
        //classe chaque joueur par nombre de points
        ArrayList<Joueur> classement = new ArrayList();
        for(int i=0;i<this.joueurs.size();i++){
            
            //détermine si le classement est vide ou non, puis insère en se basant sur la valeur
            if(classement.size()==0){
                //insère le premier joueur
                classement.add(this.joueurs.get(i));
            } else {
                int cpt = 0;
                //tant que la valeur de la main du joueur visé est inférieure à la valeur du joueur à insérer
                for(int j=0;j<classement.size()&&classement.size()<this.joueurs.size();j++){
                    if(classement.get(j).donneMain().donneValeur() <= this.joueurs.get(i).donneMain().donneValeur()){
                        classement.add(cpt, this.joueurs.get(i));
                    }
                }
            }
        }
        return classement;
    }
    
    public Joueur donneGagnantPartie(){
        ArrayList<Joueur> classement = this.donneClassementTour();
        if(classement.get(0).donneNbCredits() >= this.NB_POINTS_GAGNANTS){
            return classement.get(0);
        } else {
            return null;
        }
    }
    
    public Joueur donneGagnantTour(){
        ArrayList<Joueur> classement = donneClassementTour();
        if(classement.get(0).donneMain().donneValeur()==classement.get(1).donneMain().donneValeur()){
            //si ax-aequo retourne null, incrémente crédits pour les deux joueurs
            classement.get(0).incrementeNbCredits();
            classement.get(1).incrementeNbCredits();
            return null;
        } else {
            //sinon retourne joueur top classement, incrémente crédit pour le joueur gagnant
            classement.get(0).incrementeNbCredits();
            return classement.get(0);
        }
    }
    
    public void recupererCartes(){
        for(int i=0;i<this.joueurs.size();i++){
            Main m = this.joueurs.get(i).donneMain();
            this.jeu.replacerCartes(m);
        }
    }
}
