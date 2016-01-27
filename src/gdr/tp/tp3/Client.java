package gdr.tp.tp3;

import java.util.ArrayList;

public class Client {
    
    private String nom;
    private String adresse;
    
    private ArrayList<CompteBancaire> comptes;
    
    
    public Client(String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
        this.comptes = new ArrayList();
    }
    
    public boolean ajouteCompte(CompteBancaire compte){
        boolean ok = true;
        //vérifie l'existance du compte
        for(int i = 0;i<comptes.size();i++){
            if(compte.equals(this.comptes.get(i).donneNumero())){
                ok = false;
            }
        }
        if(ok){
            this.comptes.add(compte);
            return true;
        } else {
            return false;
        }
    }
    
    public String donneNom(){
        return this.nom;
    }
    
    public void changeAdresse(String adresse){
        this.adresse = adresse;
    }
    
    public String donneAdresse(){
        return this.adresse;
    }
    
    public ArrayList<CompteBancaire> donneComptes(){
        return this.comptes;
    }
    
    public boolean supprimeCompte(int numCompte){
        boolean ok = false;
        for(int i = 0;i<comptes.size();i++){
            if(this.comptes.get(i).donneNumero() == numCompte){
                this.comptes.remove(i);
                ok = true;
            }
        }
        return ok;
    }
    
    @Override
    public String toString(){
        String str = "Comptes de Mr/Mme/Mlle "+this.nom+" :\n";
        for(int i = 0;i<comptes.size();i++){
            str+=this.comptes.get(i).toString()+"\n";
        }
        return str;
    }
    
    
}
