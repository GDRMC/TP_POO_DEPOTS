package gdr.tp.tp3;

public class CompteBancaireRemunere extends CompteBancaire {
    
    private double tauxInteret;
    private static final double TAUX_INTERET_MENSUEL_DEFAUT = 0.03; //3%
    
    public CompteBancaireRemunere(double soldeInitial, Client c){
        super(soldeInitial,c);
        this.tauxInteret = TAUX_INTERET_MENSUEL_DEFAUT;
    }
    
    public CompteBancaireRemunere(int numeroCompte, double soldeInitial, double tauxInteretMensuel, Client c){
        super(numeroCompte, soldeInitial, c);
        this.tauxInteret = tauxInteretMensuel;
    }
    
    public CompteBancaireRemunere(double soldeInitial, double tauxInteret, Client c) {
        super(soldeInitial,c);
        this.tauxInteret = tauxInteret;
    }
    
    public CompteBancaireRemunere(Client c){
        super(0, c);
        this.tauxInteret = TAUX_INTERET_MENSUEL_DEFAUT;
    }
    
    public void crediterInteretMensuel(){
        double montantpl = this.consulter()*this.tauxInteret;
        this.crediter(montantpl);
    }
    
    @Override
    public String toString(){
        return "Compte n° "+this.donneNumero()+" de Mr/Mme/Mlle "+this.donneDetenteur().donneNom()+" : \n - Solde: "+this.tauxInteret+" € - Taux d'interêts mensuels: "+this.tauxInteret;
    }
}
