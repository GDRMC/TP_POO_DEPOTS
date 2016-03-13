package gdr.tp.tp7;

import java.util.ArrayList;

/**
 *
 * @author GDR
 */
public class Fichier extends Noeud {
    
    public int taille;

    public Fichier(String nomFichier, int tailleFichier) {
        nom = nomFichier;
        taille = tailleFichier;
    }

    @Override
    public boolean ajouteElt(Noeud nouveau) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimeElt(Noeud existant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Noeud> donneElementsFils() {
        return new ArrayList<Noeud>();
    }

    @Override
    public int taille() {
        return taille;
    }

    @Override
    public ArrayList<Noeud> rechercheElt(String nom) {
        ArrayList<Noeud> correspondance = new ArrayList<>();
        if(this.nom.equals(nom)){
            correspondance.add(this);
        } 
        return correspondance;
    }
    
    
    
    @Override
    public String toString(){
        return "  "+super.toString()+"; ";
    }
    
}
