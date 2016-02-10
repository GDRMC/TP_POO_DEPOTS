package gdr.tp.tp4colis;

import java.util.ArrayList;

public class Conteneur {
    
    private int distance;
    private int volumeMax;
    
    private ArrayList<Colis> remorque;
    
    public Conteneur(int distance, int volumeMax){
        this.distance = distance;
        this.volumeMax = volumeMax;
        this.remorque = new ArrayList();
    }
    
    public int donneDistance(){
        return this.distance;
    }
    
    public int donnePoids(){
        int total = 0;
        for(Colis colis : remorque){
            total += colis.donnePoids();
        }
        return total;
    }
    
    private int donneVolume(){
        int total = 0;
        for(Colis colis : remorque){
            total += colis.donneVolume();
        }
        return total;
    }
    
    public int cout(){
        return donneDistance()*donnePoids();
    }
    
    public boolean conditionChargement(Colis c){
        return donneVolume()+c.donneVolume() > this.volumeMax;
    }
    
    public boolean ajout(Colis c){
        if(conditionChargement(c)){
            return false;
        } else {
            this.remorque.add(c);
            return true;
        }
    }
}
