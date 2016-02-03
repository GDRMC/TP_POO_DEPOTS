package gdr.tp.tp3;

import java.util.Random;

public class CompteBancaire {
    
    private int numero;
    private double solde;
    private Client client;
    
    private static int nbComptes = 0;
    
    public CompteBancaire(double soldeInitial, Client client){
        this.client = client;
        this.solde = soldeInitial;
        //genere un numéro de compte aléatoire
        this.numero = this.genererNumeroCompte();
    }
    
    public CompteBancaire(int numero, Client client){
        this.numero = numero;
        this.client = client;
        this.solde = 0.0;
    }
    
    public CompteBancaire(int numero, double soldeInitial, Client client){
        this.client = client;
        this.numero = numero;
        this.solde = soldeInitial;
    }
    
    public double consulter(){
        return this.solde;
    }
    
    public double crediter(double montant){
        this.solde += montant;
        return this.consulter();
    }
    
    public double debiter(double montant){
        this.solde -= montant;
        return this.consulter();
    }
    
    public Client donneDetenteur(){
        return this.client;
    }
    
    public int donneNumero(){
        return this.numero;
    }
    
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
    
    public int genererNumeroCompte(){
        return this.nbComptes++;
    }
    
    @Override
    public String toString(){
        return "Compte n° "+this.numero+" de Mr/Mme/Mlle "+this.client.donneNom()+" : \n - Solde: "+this.solde+" €";
    }
    
    @Deprecated
    public static int randInt(int min, int max) {
        int rand = min + (int)(Math.random() * ((max - min) + 1));
        return rand;
    }
    
}
