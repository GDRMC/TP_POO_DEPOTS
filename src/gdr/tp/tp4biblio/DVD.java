package gdr.tp.tp4biblio;

/**
 * Classe DVD
 * La classe DVD represente un objet DVD. L'information sur le DVD est stockee
 * et peut etre accedee. Nous considerons ici uniquement les DVD Video.
 * @author gdr
 */
public class DVD extends EltMM{

    private String realisateur;

    /**
     * Constructeur DVD.
     * @param unTitre Le titre du DVD.
     * @param unRealisateur
     * @param uneDuree La duree du DVD.
     */
    public DVD(String unTitre, String unRealisateur, int uneDuree) {
        super(unTitre, uneDuree);
        this.realisateur = unRealisateur;
    }

    /**
     * Renvoie le réalisateur du DVD
     * @return réalisateur
     */
    public String donneRealisateur() {
        return this.realisateur;
    }

    /**
     * Renvoie une description textuelle de l'objet
     * @return un chaine de caracteres decrivant l'objet
     */
    public String toString() {
        String s = "\nDVD :\n";
        s += super.toString();
        s += "Realisateur : " + this.realisateur + "\n";
        return s;
    }
}
