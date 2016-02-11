package gdr.tp.tp4colis;

/**
 * Represente un colis pouvant etre chargé dans un conteneur.
 * @author gdr
 */
public class Colis {

    private int poids;
    private int volume;
    private int numero;
    private static int nbColis = 0; // permet de donner un numero aux colis

    /**
     * Constructeur colis
     * @param poids poids en kg
     * @param volume volume en m3
     */
    public Colis(int poids, int volume) {
        this.poids = poids;
        this.volume = volume;
        this.numero = nbColis++;
    }

    /**
     * Retourne le poids du colis en kg
     * @return le poids du colis
     */
    public int donnePoids() {
        return this.poids;
    }

    /**
     * Retourne le volume du colis en m3.
     * @return le volume du colis
     */
    public int donneVolume() {
        return this.volume;
    }

    /**
     * Affichage du colis
     * @return
     */
    public String toString() {
        return "poids = " + this.poids + ", volume = " + this.volume;
    }

    /**
     * Egalité de deux colis
     * @param c colis à tester
     * @return égaux ou non
     */
    public boolean equals(Colis c) {
        if (c == null) {
            return false;
        }
        if (this.numero != c.numero) {
            return false;
        } else {
            return true;
        }
    }

}
