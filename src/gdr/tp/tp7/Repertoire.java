package gdr.tp.tp7;

import java.util.ArrayList;

/**
 *
 * @author GDR
 */
public class Repertoire extends Noeud {
    
    public ArrayList<Noeud> elementsFils;

    public Repertoire(String racine) {
        nom = racine;
        elementsFils = new ArrayList<>();
    }

    @Override
    public boolean ajouteElt(Noeud nouveau) {
        boolean existe = false;
        for(Noeud noeud : elementsFils){
            if(noeud.nom.equals(nouveau.nom)){
                existe = true;
            }
        }
        if(!existe){
            nouveau.setParent(this);
            elementsFils.add(nouveau);
        }
        return !existe;
    }

    @Override
    public boolean supprimeElt(Noeud existant) {
        boolean existe = false;
        boolean supprime = false;
        for(Noeud noeud : elementsFils){
            if(noeud.nom.equals(existant.nom)){
                existe = true;
            }
        }
        if(existe){
            existant.setParent(null);
            elementsFils.remove(existant);
            supprime = true;
        }
        return supprime;
    }

    @Override
    public ArrayList<Noeud> donneElementsFils() {
        return elementsFils;
    }

    @Override
    public int taille() {
        int tailleTotale = 0;
        for(Noeud noeud : elementsFils){
            tailleTotale += noeud.taille();
        }
        return tailleTotale;
    }

    @Override
    public ArrayList<Noeud> rechercheElt(String nom) {
        ArrayList<Noeud> correspondance = new ArrayList<>();
        if(this.nom.equals(nom)){
            correspondance.add(this);
        }
        ArrayList<Noeud> sousListe;
        for(Noeud noeud : elementsFils){
            sousListe = noeud.rechercheElt(nom);
            if(!sousListe.isEmpty()){
                correspondance.addAll(sousListe);
            }
        }
        return correspondance;
    }
    
    
    
    @Override
     public String toString(){
        String s = "-"+super.toString()+"; ";
        for ( int i = 0 ; i < this.elementsFils.size() ; i++){
            s=s + "\n   "+this.elementsFils.get(i).toString()+" ";
        }
        return s;
    }

}
