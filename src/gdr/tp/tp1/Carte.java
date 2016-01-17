package gdr.tp.tp1;

public class Carte {
    
    private Rang rang;
    private Couleur couleur;
    
    public Carte(Rang rang, Couleur couleur){
        this.rang = rang;
        this.couleur = couleur;
    }
    
    public Couleur donneCouleur(){
        return this.couleur;
    }
    
    public Rang donneRang(){
        return this.rang;
    }
    
    public int donneValeur(){
        return this.rang.ordinal();
    }
    
    public String toString(){
        return this.rang.toString()+" de "+this.couleur.toString();
    }
    
}
