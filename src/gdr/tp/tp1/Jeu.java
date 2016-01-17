package gdr.tp.tp1;

import java.util.ArrayList;
import java.util.Collections;

public class Jeu {
    
    ArrayList<Carte> jeu;
    
    public Jeu(){
        //Initialise le jeu
        this.jeu = new ArrayList();
        //Remplit le jeu
        for(Couleur c : Couleur.values()){
            for(Rang r : Rang.values()){
                this.jeu.add(new Carte(r,c));
            }
        }
    }
    
    public void melanger(){
        Collections.shuffle(jeu);
    }
    
    public Main donnerCartes(int nb){
        ArrayList<Carte> donner = new ArrayList();
        for(int i=0;i<this.jeu.size()&&i<nb;i++){
            donner.add(this.jeu.get(i));
        }
        return new Main(donner);
    }
    
    public void replacerCartes(Main main){
        this.jeu.addAll(main.donneCartes());
    }
    
    public String toString(){
        String s = "";
        s=s+"Contenu du jeu :\n";
        for(int i=0;i<this.jeu.size();i++){
            s=s+this.jeu.get(i).toString()+"\n";
        }
        return s;
    }
}
