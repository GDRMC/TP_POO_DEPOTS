package gdr.tp.tp6.ex1_1;

/**
 * Classe représentant un mammifere terrestre caracterise par : - un nom
 * d'espece, - un indicateur booleen precisant si le mammifere est carnivore -
 * un nom d'habitat (biotope).
 */
public class MammifereTerrestre extends Mammifere{

    private String habitat;

    public MammifereTerrestre(String nom, boolean carnivore, String habitat) {
        super(nom, carnivore);
        this.habitat = habitat;
    }
}
