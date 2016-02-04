package gdr.tp.tp3;

/**
 * Classe CompteBancaire
 * @author GDR
 */
public class CompteBancaire {
    
    private int numero;
    private double solde;
    private Client client;
    
    private static int nbComptes = 0;
    
    /**
     * Constructeur
     * @param soldeInitial solde initial du compte
     * @param client client
     */
    public CompteBancaire(double soldeInitial, Client client){
        this.client = client;
        this.solde = soldeInitial;
        //genere un numéro de compte aléatoire
        this.numero = this.genererNumeroCompte();
    }
    
    /**
     * Constructeur
     * @param numero numéro de compte
     * @param client client
     */
    public CompteBancaire(int numero, Client client){
        this.numero = numero;
        this.client = client;
        this.solde = 0.0;
    }
    
    /**
     * Constructeur
     * @param numero numéro de compte
     * @param soldeInitial solde initial du compte
     * @param client client
     */
    public CompteBancaire(int numero, double soldeInitial, Client client){
        this.client = client;
        this.numero = numero;
        this.solde = soldeInitial;
    }
    
    /**
     * Consulte le montant du compte
     * @return montant
     */
    public double consulter(){
        return this.solde;
    }
    
    /**
     * Crédite le compte du montant entré
     * @param montant montant à ajouter
     * @return consultation solde
     */
    public double crediter(double montant){
        this.solde += montant;
        return this.consulter();
    }
    
    /**
     * Débite le compte du montant entré
     * @param montant montant à débiter
     * @return consultation solde
     */
    public double debiter(double montant){
        this.solde -= montant;
        return this.consulter();
    }
    
    /**
     * Renvoie le détenteur du compte
     * @return client détenteur
     */
    public Client donneDetenteur(){
        return this.client;
    }
    
    /**
     * Renvoie le numéro de compte
     * @return numéro de compte
     */
    public int donneNumero(){
        return this.numero;
    }
    
    /**
     * Transfert d'argent entre deux comptes
     * @param unCompte compte à créditer
     * @param montantATransferer montant à transférer
     * @return état de la transaction
     */
    public boolean transferer(CompteBancaire unCompte, int montantATransferer){
        boolean ok = false;
        int mnt = montantATransferer;
        if(this.solde-mnt >= 0){
            this.solde-=mnt;
            unCompte.crediter(mnt);
            ok = true;
        }
        return ok;
    }
    
    /**
     * Génère un numéro de compte
     * @return numéro de compte généré
     */
    public int genererNumeroCompte(){
        return this.nbComptes++;
    }
    
    @Override
    public String toString(){
        return "Compte n° "+this.numero+" de Mr/Mme/Mlle "+this.client.donneNom()+" : \n - Solde: "+this.solde+" €";
    }
    
}
