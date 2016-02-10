package gdr.tp.tp4colis;

public class ConteneurUrgent extends Conteneur {
    
    private int poidsMax;
    
    public ConteneurUrgent(int distance, int volumeMax, int poidsMax){
        super(distance, volumeMax);
        this.poidsMax = poidsMax;
    }
    
    
    @Override
    public boolean conditionChargement(Colis c){
        return ((super.donnePoids()+c.donnePoids()) < this.poidsMax) && super.conditionChargement(c);
    }
}
