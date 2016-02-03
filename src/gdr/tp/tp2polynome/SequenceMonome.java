package gdr.tp.tp2polynome;

/**
 * Classe SequenceMonome
 *
 * @author GDR
 */
public class SequenceMonome {

    private Monome[]liste;

    /**
     * Définit une séquence de monômes de taille nulle
     */
    public SequenceMonome() {
        this.liste = new Monome[0];
    }

    /**
     * Définit une séquence de monômes en entrant une liste de coefficients dans
     * un tableau d'integer bidimensionnel
     *
     * @param listeCoeffDeg tableau à deux dimensions de monômes
     */
    public SequenceMonome(int[][] listeCoeffDeg) {
        //compte le nombre de monômes ayant un degré supérieur à 0
        //this.liste = listeCoeffDeg;

        //crée un tableau avec la longueur trouvée dans les degrés positifs
        Monome[] newList = new Monome[this.nbMonoValides(listeCoeffDeg)];
        int maxDegre = this.maxDegre(listeCoeffDeg);
        int curseur = 0;
        for (int curseurDegre = maxDegre; curseurDegre > 0; curseurDegre--) {
            for (int j = 0; j < listeCoeffDeg.length; j++) {
                if (listeCoeffDeg[j][1] >= 1 && listeCoeffDeg[j][0] >= 1) {
                    if (listeCoeffDeg[j][1] == curseurDegre) {
                        newList[curseur] = new Monome(listeCoeffDeg[j][0],listeCoeffDeg[j][1]);
                        curseur++;
                    }
                }
            }
        }

        this.liste = newList;
    }

    /**
     * Ajoute un monôme dans la structure
     *
     * @param mono monôme à insérer
     */
    public void ajouterMonome(Monome mono) {
        Monome[] newList = new Monome[this.liste.length+1];
        for (int i = 0; i < this.liste.length; i++) {
            if(mono.degre() == this.liste[i].degre()){
                newList[i] = mono;
                newList[i+1] = this.liste[i];
                i++;
            } else {
                newList[i] = this.liste[i];
            }
        }
        this.liste = newList;
    }

    /**
     * Renvoie un monôme donné
     *
     * @param index index recherché dans le tableau
     * @return monôme pointé par la valeur d'index
     */
    public Monome donneMonome(int index) {
        return this.liste[index];
    }

    /**
     * Renvoie la taille de la séquence de monômes
     *
     * @return taille de la séquence
     */
    public int taille() {
        if (this.liste == null) {
            return -1;
        } else {
            return this.liste.length;
        }
    }

    /**
     * Renvoie le degré maximum de la séquence de monôme de la classe
     *
     * @return
     */
    public int maxDegre() {
        int maxDegre = -1;
        if (this.liste == null) {
            maxDegre = 0;
        } else if (this.liste.length > 0) {
            for (int i = 0; i < this.liste.length; i++) {
                if (this.liste[i].degre() > maxDegre) {
                    maxDegre = this.liste[i].degre();
                }
            }
        }
        return maxDegre;
    }

    /**
     * Analyse le degré maximum d'un tableau bidimensionnel de monômes entré en
     * paramètre
     *
     * @param listeNC tableau bidimensionnel de monômes
     * @return degré maximum des monômes
     */
    public int maxDegre(int[][] listeNC) {
        int maxDegre = -1;
        for (int i = 0; i < listeNC.length; i++) {
            if (listeNC[i][1] > maxDegre) {
                maxDegre = listeNC[i][1];
            }
        }
        return maxDegre;
    }

    /**
     * Analyse les monômes valides d'un tableau bidimensionnel de monômes
     * (si coeff > 0 et degré > 0)
     *
     * @param listeNC tableau bidimensionnel de monômes
     * @return nombre de degrés positifs des monômes
     */
    public int nbMonoValides(int[][] listeNC) {
        int nb = 0;
        for (int i = 0; i < listeNC.length; i++) {
            if (listeNC[i][1] > 0 && listeNC[i][0] > 0) {
                nb++;
            }
        }
        return nb;
    }
}
