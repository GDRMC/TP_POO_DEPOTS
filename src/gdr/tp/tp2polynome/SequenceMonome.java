package gdr.tp.tp2polynome;

/**
 * Classe SequenceMonome
 *
 * @author GDR
 */
public class SequenceMonome {

    private int[][] liste;

    /**
     * Définit une séquence de monômes de taille nulle
     */
    public SequenceMonome() {
        this.liste = new int[0][2];
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
        int[][] newList = new int[this.nbMonoValides(listeCoeffDeg)][2];
        int maxDegre = this.maxDegre(listeCoeffDeg);
        int curseur = 0;
        for (int curseurDegre = maxDegre; curseurDegre > 0; curseurDegre--) {
            for (int j = 0; j < listeCoeffDeg.length; j++) {
                if (listeCoeffDeg[j][1] >= 1 && listeCoeffDeg[j][0] >= 1) {
                    if (listeCoeffDeg[j][1] == curseurDegre) {
                        newList[curseur][0] = listeCoeffDeg[j][0];
                        newList[curseur][1] = listeCoeffDeg[j][1];
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
        int[][] newList = new int[this.liste.length + 1][2];
        newList[0][0] = mono.coeff();
        newList[0][1] = mono.degre();
        for (int i = 0; i < this.liste.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    newList[i][j] = mono.coeff();
                } else if (j == 1) {
                    newList[i][j] = mono.degre();
                }
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
        return new Monome(this.liste[index][0], this.liste[index][1]);
    }

    /**
     * Renvoie la taille de la séquence de monômes
     *
     * @return taille de la séquence
     */
    public int taille() {
        if (this.liste == null) {
            return 0;
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
                if (this.liste[i][1] > maxDegre) {
                    maxDegre = this.liste[i][1];
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
     * Analyse le nombre de degrés positifs des monômes d'un tableau
     * bidimensionnel entré en paramètre
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
