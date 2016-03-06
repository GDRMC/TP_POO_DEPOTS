package gdr.tp.tp6.ex1_2;

/**
 * Classe représentant un reptile terrestre caracterise par : - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux, - un nom
 * d'habitat (biotope).
 */
public class ReptileTerrestre extends Reptile implements Terrestre {

    private String habitat;

    public ReptileTerrestre(String nom, boolean venimeux, String habitat) {
        super(nom, venimeux);
        this.habitat = habitat;
    }
    
}
