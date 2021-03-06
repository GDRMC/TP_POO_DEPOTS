package gdr.tp.tp4biblio;

/**
 * Classe CD
 * La classe CD represente un objet CD.
 * @author gdr
 */
public class CD extends EltMM {

    private String artiste;
    private int nbPistes;

    /**
     * Constructeur CD.
     * @param unTitre Le titre du CD.
     * @param unArtiste Le nom de l'artiste du CD.
     * @param pistes Le nombre de pistes du CD.
     * @param uneDuree La duree du CD.
     */
    public CD(String unTitre, String unArtiste, int pistes, int uneDuree) {
        super(unTitre, uneDuree);
        this.artiste = unArtiste;
        this.nbPistes = pistes;
    }

    /**
     * Donne le nom de l'artiste du CD
     * @return artiste
     */
    public String donneArtiste() {
        return this.artiste;
    }

    /**
     * Donne le nombre de pistes du CD.
     * @return nombre de pistes
     */
    public int donneNbPistes() {
        return this.nbPistes;
    }

    /**
     * Renvoie une description textuelle de l'objet
     * @return un chaine de caracteres decrivant l'objet
     */
    public String toString() {
        String s = "\nCD :\n";
        s += super.toString();
        return s += "Artiste : " + this.artiste + "\npistes : " + this.nbPistes;
    }
}
