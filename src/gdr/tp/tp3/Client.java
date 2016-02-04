package gdr.tp.tp3;

import java.util.ArrayList;

/**
 * Classe Client
 * @author GDR
 */
public class Client {
    
    private String nom;
    private String adresse;
    
    private ArrayList<CompteBancaire> comptes;
    
    /**
     * Constructeur Client
     * @param nom nom du client
     * @param adresse adresse du client
     */
    public Client(String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
        this.comptes = new ArrayList();
    }
    
    /**
     * Ajoute un compte au client
     * @param compte compte client à ajouter
     * @return etat de l'opération
     */
    public boolean ajouteCompte(CompteBancaire compte){
        boolean ok = true;
        //vérifie l'existance du compte
        for(int i = 0;i<comptes.size();i++){
            if( compte.donneNumero() == this.comptes.get(i).donneNumero() ){
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
    
    /**
     * Renvoie le nom du détenteur du compte
     * @return nom du détenteur
     */
    public String donneNom(){
        return this.nom;
    }
    
    /**
     * Change l'adresse du client
     * @param adresse adresse du client
     */
    public void changeAdresse(String adresse){
        this.adresse = adresse;
    }
    
    /**
     * Renvoie l'adresse du client
     * @param adresse adresse du client
     */
    public String donneAdresse(){
        return this.adresse;
    }
    
    /**
     * Donne tous les comptes associés à un client dans une ArrayList
     * @return comptes du client
     */
    public ArrayList<CompteBancaire> donneComptes(){
        return this.comptes;
    }
    
    /**
     * Supprime un compte
     * @param numCompte numéro du compte a supprimer
     * @return etat de la suppression
     */
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
