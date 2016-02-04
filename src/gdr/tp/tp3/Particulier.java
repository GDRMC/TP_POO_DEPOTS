package gdr.tp.tp3;

/**
 * Classe Particulier
 * @author GDR
 */
public class Particulier extends Client {
    
    private String prenom;

    /**
     * Constructeur
     * @param nom nom du particulier
     * @param prenom prénom du particulier
     * @param adresse adresse du particulier
     */
    public Particulier(String nom, String prenom, String adresse) {
        super(nom, adresse);
        this.prenom = prenom;
    }
    
    /**
     * Renvoie le prénom du particulier
     * @return prénom
     */
    public String donnePrenom(){
        return this.prenom;
    }
}
