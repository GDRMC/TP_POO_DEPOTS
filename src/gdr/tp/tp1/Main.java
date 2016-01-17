package gdr.tp.tp1;

import java.util.ArrayList;

public class Main {
    
    private ArrayList<Carte> main;
    
    Main(ArrayList<Carte> cartes){
        this.main = new ArrayList();
        this.main.addAll(cartes);
    }
    
    public ArrayList<Carte> donneCartes(){
        ArrayList<Carte> donne = new ArrayList();
        for(int i=0;i<this.main.size();i++){
            donne.add(this.main.get(i));
        }
        return donne;
    }
    
    public int donneValeur(){
        int valeur = 0;
        try{
            for(int i=0;i<this.main.size();i++){
                valeur = valeur + this.main.get(i).donneValeur();
            }
        }catch(Exception e){
            valeur = -1;
        }
        return valeur;
    }
    
    public String toString(){
        String s = "Contenu de la main :\n";
        for(int i=0;i<this.main.size();i++){
            s = s + this.main.get(i).toString()+"\n";
        }
        return s;
    }
}
