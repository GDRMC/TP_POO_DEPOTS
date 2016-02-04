package gdr.tp.tp3;

/**
 * Classe CompteBancaireRemunere
 * @author GDR
 */
public class CompteBancaireRemunere extends CompteBancaire {
    
    private double tauxInteret;
    private static final double TAUX_INTERET_MENSUEL_DEFAUT = 0.03; //3%
    
    /**
     * Constructeur
     * @param soldeInitial solde initial
     * @param c client
     */
    public CompteBancaireRemunere(double soldeInitial, Client c){
        super(soldeInitial,c);
        this.tauxInteret = TAUX_INTERET_MENSUEL_DEFAUT;
    }
    
    /**
     * Constructeur
     * @param numeroCompte numéro compte
     * @param soldeInitial solde initial
     * @param tauxInteretMensuel taux interet
     * @param c client
     */
    public CompteBancaireRemunere(int numeroCompte, double soldeInitial, double tauxInteretMensuel, Client c){
        super(numeroCompte, soldeInitial, c);
        this.tauxInteret = tauxInteretMensuel;
    }
    
    /**
     * Constructeur
     * @param soldeInitial solde initial
     * @param tauxInteret taux interet
     * @param c client
     */
    public CompteBancaireRemunere(double soldeInitial, double tauxInteret, Client c) {
        super(soldeInitial,c);
        this.tauxInteret = tauxInteret;
    }
    
    /**
     * Constructeur
     * @param c client
     */
    public CompteBancaireRemunere(Client c){
        super(0, c);
        this.tauxInteret = TAUX_INTERET_MENSUEL_DEFAUT;
    }
    
    /**
     * Crédite les interets mensuels
     */
    public void crediterInteretMensuel(){
        double montantpl = this.consulter()*this.tauxInteret;
        this.crediter(montantpl);
    }
    
    @Override
    public String toString(){
        return "Compte n° "+this.donneNumero()+" de Mr/Mme/Mlle "+this.donneDetenteur().donneNom()+" : \n - Solde: "+this.tauxInteret+" € - Taux d'interêts mensuels: "+this.tauxInteret;
    }
}
