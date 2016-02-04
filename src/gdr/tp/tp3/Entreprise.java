package gdr.tp.tp3;

/**
 * Classe Entreprise
 * @author GDR
 */
public class Entreprise extends Client {

    private int numeroSIRET;
    
    /**
     * Constructeur Entreprise
     * @param nom nom de l'entreprise
     * @param adresse adresse de l'entreprise
     * @param numeroSIRET numéro de SIRET de l'entreprise
     */
    public Entreprise(String nom, String adresse, int numeroSIRET) {
        super(nom, adresse);
        this.numeroSIRET = numeroSIRET;
    }
    
    /**
     * Donne numéro de SIRET
     * @return numéro de SIRET
     */
    public int donneNumeroSIRET(){
        return this.numeroSIRET;
    }
    
}
