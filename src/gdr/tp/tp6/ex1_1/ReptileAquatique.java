package gdr.tp.tp6.ex1_1;

/**
 * Classe représentant un reptile aquatique caracterise par : - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux, - un indicateur
 * booleen precisant si le reptile evolue dans l'eau douce.
 */
public class ReptileAquatique extends Reptile {

    private boolean eauDouce;

    public ReptileAquatique(String nom, boolean venimeux, boolean eauDouce) {
        super(nom, venimeux);
        this.eauDouce = eauDouce;
    }
}
