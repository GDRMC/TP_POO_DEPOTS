package gdr.tp.tp3;

public class Particulier extends Client{
    
    private String prenom;

    public Particulier(String nom, String prenom, String adresse) {
        super(nom, adresse);
        this.prenom = prenom;
    }
    
    public String donnePrenom(){
        return this.prenom;
    }
}
