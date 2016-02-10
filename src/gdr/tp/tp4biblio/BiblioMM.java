package gdr.tp.tp4biblio;

import java.util.ArrayList;

/**
 * La classe BiblioMM fournit un moyen de stocker des objets
 * CD et DVD. Une liste de tous les CD et DVD peut etre affichee
 * en mode texte.
 * 
 */
public class BiblioMM
{
    private ArrayList<EltMM> liste;

    /**
     * Construit une bibliotheque vide.
     */
    public BiblioMM()
    {
        this.liste = new ArrayList();
    }

    /**
     * Ajoute un CD a la bibliotheque.
     * @param unCD Le CD a ajouter.
     */
    public void ajouterCD(CD unCD)
    {
        this.liste.add(unCD);
    }

    /**
     * Ajoute un DVD a la bibliotheque.
     * @param unDVD Le DVD a ajouter.
     */
    public void ajouterDVD(DVD unDVD)
    {
        this.liste.add(unDVD);
    }

    /**
     * Affiche une liste de tous les CD et DVD actuellement dans
     * la bibliotheque.
     */
    public void affiche()
    {
        for(EltMM element : this.liste) {
            System.out.println(element);   
        }
    }
    
    public ArrayList<EltMM> rechercherTitre(String str){
        ArrayList<EltMM> ar = new ArrayList();
        for(EltMM element : liste){
            if(element.donneTitre().contains(str)){
                ar.add(element);
            }
        }
        return ar;
    }
    
    public boolean emprunterTitre(String str){
        ArrayList<EltMM> emprunt = this.rechercherTitre(str);
        if(emprunt.size()==1 && emprunt.get(0).donneEtatRayon()){
            emprunt.get(0).changeEtatRayon(false);
            return true;
        }
        else {
            return false;
        }
    }
}
