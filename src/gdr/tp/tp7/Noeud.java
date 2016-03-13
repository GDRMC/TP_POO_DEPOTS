package gdr.tp.tp7;

import java.util.ArrayList;

/**
 * Classe Noeud
 * @author Grégory
 */
public abstract class Noeud {
    
    public String nom;
    private Noeud pere;

    public abstract boolean ajouteElt(Noeud nouveau);

    public abstract boolean supprimeElt(Noeud existant);

    public abstract ArrayList<Noeud> donneElementsFils();
    
    public abstract int taille();
    
    public abstract ArrayList<Noeud> rechercheElt(String nom);
    
    public Noeud donneParent(){
        return this.pere;
    }
    
    public void setParent(Noeud noeud){
        this.pere = noeud;
    }
    
    @Override
    public String toString(){
        return this.nom;
    }

}
