package gdr.tp.tp4colis;

import java.util.ArrayList;

/**
 * Classe Conteneur
 * @author gdr
 */
public class Conteneur {
    
    private int distance;
    private int volumeMax;
    
    private ArrayList<Colis> remorque;
    
    /**
     * Constructeur
     * @param distance distance à parcourir
     * @param volumeMax volume maximum du conteneur
     */
    public Conteneur(int distance, int volumeMax){
        this.distance = distance;
        this.volumeMax = volumeMax;
        this.remorque = new ArrayList();
    }
    
    /**
     * Renvoie la distance à parcourir
     * @return distance
     */
    public int donneDistance(){
        return this.distance;
    }
    
    /**
     * Renvoie le poids du conteneur
     * @return poids
     */
    public int donnePoids(){
        int total = 0;
        for(Colis colis : remorque){
            total += colis.donnePoids();
        }
        return total;
    }
    
    /**
     * Renvoie le volume du conteneur
     * @return volume
     */
    private int donneVolume(){
        int total = 0;
        for(Colis colis : remorque){
            total += colis.donneVolume();
        }
        return total;
    }
    
    /**
     * Renvoie le cout du conteneur
     * @return cout
     */
    public int cout(){
        return donneDistance()*donnePoids();
    }
    
    /**
     * Vérifie les conditions de chargement d'un colis
     * @param c colis à tester
     * @return colis peut être chargé ou non
     */
    public boolean conditionChargement(Colis c){
        return donneVolume()+c.donneVolume() < this.volumeMax;
    }
    
    /**
     * Ajoute un colis dans le conteneur
     * @param c colis à ajouter
     * @return true si les conditions sont remplies et charge, sinon renvoie false
     */
    public boolean ajout(Colis c){
        if(conditionChargement(c)){
            return false;
        } else {
            this.remorque.add(c);
            return true;
        }
    }
}
