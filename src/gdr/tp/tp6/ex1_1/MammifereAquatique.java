package gdr.tp.tp6.ex1_1;

/**
 * Classe représentant un mammifere aquatique caracterise par : - un nom
 * d'espece, - un indicateur booleen precisant si le mammifere est carnivore, -
 * un indicateur booleen precisant si le mammifere evolue dans l'eau douce.
 */
public class MammifereAquatique extends Mammifere{

    private boolean eauDouce;

    public MammifereAquatique(String nom, boolean carnivore, boolean eauDouce) {
        super(nom, carnivore);
        this.eauDouce = eauDouce;
    }
}
