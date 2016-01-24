package gdr.tp.tp2polynome;

/**
 * Repr&eacute;sente l'unit&eacute; &eacute;l&eacute;mentaire d'un polyn&ocirc;me : a
 * x^b o&ugrave;
 * <code>a</code> repr&eacute;sente le coefficient et
 * <code>b</code> le degr&eacute;.
 *
 */
public class Monome
{
    private int coeff, degre;

    /**
     * Cr&eacute;e un mon&ocirc;me avec un coefficient et un degr&eacute;.
     *
     * @param coeff coefficient du mon&ocirc;me
     * @param degre degr&eacute; du mon&ocirc;me
     */
    public Monome(int coeff, int degre)
    {
        this.coeff = coeff;
        this.degre = degre;
    }

    /**
     * Cr&eacute;e un mon&ocirc;me &agrave; partir d'un autre mon&ocirc;me.
     *
     * @param m le mon&ocirc;me &agrave; copier.
     */
    public Monome(Monome m)
    {
        this.coeff = m.coeff;
        this.degre = m.degre;
    }

    /**
     * Retourne le coefficient du mon&ocirc;me.
     *
     * @return coefficient
     */
    public int coeff()
    {
        return this.coeff;
    }

    /**
     * Retourne le degr&eacute; du mon&ocirc;me.
     *
     * @return degr&eacute;
     */
    public int degre()
    {
        return this.degre;
    }

    public boolean equals(Monome m)
    {
        if (this == m)
        {
            return true;
        }
        else if (m == null)
        {
            return false;
        }
        else
        {
            return (this.coeff == m.coeff && this.degre == m.degre);
        }
    }
	
    @Override
    public String toString()
    {
        String affichage = "";
        if (this.coeff != 1)
            affichage += Integer.toString(this.coeff);
        if (this.degre != 0)
            affichage += "x^" + Integer.toString(this.degre);
        return affichage;
    }
}
