package gdr.tp.tp2polynome;

/**
 * Repr&eacute;sente un polyn&ocirc;me de la forme : a_n x^n + a_n-1 x^n-1 + ...
 * a_0 o&ugrave; a sont les coefficients et n les degr&eacute;s.
 *
 */
public class Polynome
{
    private SequenceMonome seqMonome;

    /**
     * Cr&eacute;e un polyn&ocirc;me vide
     */
    public Polynome()
    {
        this.seqMonome = new SequenceMonome();
    }

    /**
     * Cr&eacute;e un polyn&ocirc;me &agrave; partir d'une tableau dont chaque
     * &eacute;l&eacute;ment est lui-m&ecirc;me un tableau de deux
     * &eacute;l&eacute;ments : le coefficient et le degr&eacute;.
     *
     * @param listeCoeffDeg
     */
    public Polynome(int[][] listeCoeffDeg)
    {
        this.seqMonome = new SequenceMonome(listeCoeffDeg);
    }

    @Override
    public String toString()
    {
        String affichage = "(";
        for (int i = 0; i < this.seqMonome.taille(); i++)
        {
            affichage += (i > 0 ? " + " : "") + this.seqMonome.donneMonome(i).toString();
        }
        return affichage + ")";
    }

    /**
     * Retourne le degr&eacute; du polyn&ocirc;me.
     *
     * @return degre
     */
    public int donneDegre()
    {
        return this.seqMonome.maxDegre();
    }

    /**
     * Retourne un polyn&ocirc;me representant le resultat de l'addition du
     * polyn&ocirc;me avec un autre polyn&ocirc;me p.
     *
     * @param p polyn&ocirc;me a&agrave; additionner
     * @return resultat le polyn&ocirc;me representant la somme de this et p.
     */
    public Polynome addition(Polynome p)
    {
        int tailleThis = this.seqMonome.taille();
        int tailleP = p.seqMonome.taille();
        Polynome resultat = new Polynome();
        int idxThis = 0, idxP = 0;
        // tant que la fin d'un des deux polynomes n'est pas atteinte
        while (idxThis < tailleThis && idxP < tailleP)
        {
            int degreThis = this.seqMonome.donneMonome(idxThis).degre();
            int coeffThis = this.seqMonome.donneMonome(idxThis).coeff();
            int degreP = p.seqMonome.donneMonome(idxP).degre();
            int coeffP = p.seqMonome.donneMonome(idxP).coeff();
            if (degreThis == degreP)
            {
                resultat.seqMonome.ajouterMonome(new Monome(coeffThis + coeffP, degreThis));
                idxThis++;
                idxP++;
            }
            else if (degreThis > degreP)
            {
                resultat.seqMonome.ajouterMonome(new Monome(this.seqMonome.donneMonome(idxThis)));
                idxThis++;
            }
            else // degreThis < degreP
            {
                resultat.seqMonome.ajouterMonome(new Monome(p.seqMonome.donneMonome(idxP)));
                idxP++;
            }
        }
        if (idxThis == tailleThis)
        {
            // recopie des monomes restants de this
            while (idxP < tailleP)
            {
                resultat.seqMonome.ajouterMonome(new Monome(p.seqMonome.donneMonome(idxP)));
                idxP++;
            }
        }
        else // recopie des monomes restant de p
        {
            while (idxThis < tailleThis)
            {
                resultat.seqMonome.ajouterMonome(new Monome(this.seqMonome.donneMonome(idxThis)));
                idxThis++;
            }
        }
        return resultat;
    }

    public Polynome derive()
    {
        Polynome resultat = new Polynome();        
        /* A COMPLETER !... */
        return resultat;
    }

    public boolean equals(Polynome p)
    {
        if (this == p)
        {
            return true;
        }
        else if (p == null)
        {
            return false;
        }
        else if (this.donneDegre() != p.donneDegre())
        {
            return false;
        }
        else if (this.seqMonome.taille() != p.seqMonome.taille())
        {
            return false;
        }
        else
        {
            for (int i = 0; i < this.seqMonome.taille(); i++)
            {
                if (!this.seqMonome.donneMonome(i).equals(p.seqMonome.donneMonome(i)))
                {
                    return false;
                }
            }
            return true;
        }
    }
}
