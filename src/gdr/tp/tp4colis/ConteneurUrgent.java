package gdr.tp.tp4colis;

/**
 * Classe de ConteneurUrgent héritée de Conteneur
 * @author gdr
 */
public class ConteneurUrgent extends Conteneur {
    
    private int poidsMax;
    
    /**
     * Constructeur
     * @param distance distance à parcourir
     * @param volumeMax volume maximum du conteneur
     * @param poidsMax poids maximum du conteneur
     */
    public ConteneurUrgent(int distance, int volumeMax, int poidsMax){
        super(distance, volumeMax);
        this.poidsMax = poidsMax;
    }
    
    /**
     * Condition de chargement du colis
     * @param c colis à tester dans le conteneur
     * @return peut être chargé ou pas
     */
    @Override
    public boolean conditionChargement(Colis c){
        return ((super.donnePoids()+c.donnePoids()) < this.poidsMax) && super.conditionChargement(c);
    }
}
