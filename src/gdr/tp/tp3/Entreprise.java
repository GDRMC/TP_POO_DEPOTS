package gdr.tp.tp3;

public class Entreprise extends Client {

    private int numeroSIRET;
    
    public Entreprise(String nom, String adresse, int numeroSIRET) {
        super(nom, adresse);
        this.numeroSIRET = numeroSIRET;
    }
    
    public int donneNumeroSIRET(){
        return this.numeroSIRET;
    }
    
}
