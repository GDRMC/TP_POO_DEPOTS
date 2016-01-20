package gdr.tp.tp2rationnel;

/**
 * Classe Relationnel
 * @author USER
 */
public class Rationnel {

    private int num;
    private int denom;

    /**
     * Constructeur
     * @param num Numérateur
     * @param denom Dénominateur
     */
    private Rationnel(int num, int denom) throws Exception {
        if(denom!=0){
           this.num = num;
        this.denom = denom; 
        } else {
            throw new Exception("Impossible de créer l'objet");
        }
    }
    
    public static Rationnel createRationnel(int num, int denom) throws Exception{
        if(denom!=0){
            return new Rationnel(num,denom);
        } else {
            return null;
        }
    }

    /**
     * Renvoie le dénominateur
     * @return le dénominateur
     */
    public int getDenom() {
        return this.denom;
    }

    /**
     * Renvoie le numérateur
     * @return le numérateur
     */
    public int getNum() {
        return this.num;
    }

    /**
     * Renvoie la représentation réelle
     * @return la représentation réelle
     */
    public double getReal() {
        return (double)this.getNum() / this.getDenom();
    }

    /**
     * Détermine si deux rationnels sont égaux
     * @param r rationnel à tester
     * @return résultat du test d'égalité
     */
    public boolean equals(Rationnel r) {
        if (r.getNum() == this.getNum() && r.getDenom() == this.getDenom()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retourne l'inverse d'un rationnel
     * @return l'inverse du rationnel
     */
    public Rationnel reverse() throws Exception {
        int invNum = this.getNum();
        int invDenom = this.getDenom();
        return createRationnel(invDenom, invNum);
    }
    
    /**
     * Retourne l'opposé d'un rationnel
     * @return l'opposé du rationnel
     */
    public Rationnel opposite() throws Exception{
        return createRationnel(-this.getNum(),this.getDenom());
    }

    /**
     * Additionne deux rationnels
     * @param r rationnel à ajouter
     * @return le résultat de l'addition
     */
    public Rationnel add(Rationnel r) throws Exception{
        if (this.getDenom() != r.getDenom()) {
            Rationnel gadd = createRationnel(this.getNum() * r.getDenom(), this.getDenom() * r.getDenom());
            Rationnel dadd = createRationnel(r.getNum() * this.getDenom(), r.getDenom() * this.getDenom());
            return createRationnel(gadd.getNum() + dadd.getNum(), dadd.getDenom());
        } else {
            return createRationnel(this.getNum() + r.getNum(), r.getDenom());
        }
    }

    /**
     * Soustrait deux rationnels
     * @param r rationnel à soustraire
     * @return le résultat de la soustraction
     */
    public Rationnel minus(Rationnel r) throws Exception{
        if (this.getDenom() != r.getDenom()) {
            Rationnel gadd = createRationnel(this.getNum() * r.getDenom(), this.getDenom() * r.getDenom());
            Rationnel dadd = createRationnel(r.getNum() * this.getDenom(), r.getDenom() * this.getDenom());
            return createRationnel(gadd.getNum() - dadd.getNum(), dadd.getDenom());
        } else {
            return createRationnel(this.getNum() - r.getNum(), r.getDenom());
        }
    }

    /**
     * Multiplie deux rationnels
     * @param r rationnel à multiplier
     * @return le résultat de la soustraction
     */
    public Rationnel multiply(Rationnel r) throws Exception {
        return createRationnel(this.getNum() * r.getNum(), this.getDenom() * r.getDenom());
    }

    /**
     * Divise deux rationnels
     * @param r rationnel à diviser
     * @return le résultat de la division
     */
    public Rationnel divide(Rationnel r) throws Exception {
        return createRationnel(this.getNum() * r.reverse().getNum(), this.getDenom() * r.reverse().getDenom());
    }
    
    public String toString(){
        return "Rationnel: ("+this.getNum()+"/"+this.getDenom()+")";
    }
}
