package gdr.tp.tp1;

public class Joueur {
    
    private Main main;
    
    private String nom;
    private int nbCredits;
    
    Joueur(String nom){
        this.nom = nom;
        this.nbCredits = 0;
    }
    
    public int donneNbCredits(){
        return this.nbCredits;
    }
    
    public void incrementeNbCredits(){
        this.nbCredits++;
    }
    
    public void recoitMain(Main m){
        this.main = m;
    }
    
    public Main donneMain(){
        return this.main;
    }
    
    public String toString(){
        return "Le joueur "+this.nom+" possède "+this.nbCredits+" et a la main suivante :\n"+this.main;
    }
}
