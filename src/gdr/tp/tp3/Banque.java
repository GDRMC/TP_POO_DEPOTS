package gdr.tp.tp3;

import java.util.ArrayList;

public class Banque {
    
    private String nomBanque;
    
    private ArrayList<Client> clients;
    
    /**
     *
     * @param nomBanque
     */
    public Banque(String nomBanque){
        this.nomBanque = nomBanque;
        this.clients = new ArrayList();
    }
    
    /**
     *
     * @param soldeInitial
     * @param tauxInteret
     * @param nomClient
     * @return
     */
    public CompteBancaireRemunere creerCompteRemunere(double soldeInitial, double tauxInteret, String nomClient){
        Client c = this.rechercheClient(nomClient);
        boolean insert = false;
        CompteBancaireRemunere compte = null;
        if(c!=null){
            for(int i=0;i<this.clients.size();i++){
                if(this.clients.get(i).donneNom().equals(c.donneNom())){
                    compte = new CompteBancaireRemunere(soldeInitial,tauxInteret, c);
                    this.clients.get(i).ajouteCompte(compte);
                    insert = true;
                }
            }
        }
        if(insert){
            return compte;
        } else {
            return null;
        }
    }
    
    /**
     *
     * @param nomEntreprise
     * @param numeroSIRET
     * @param adresse
     * @return
     */
    public Entreprise creerEntreprise(String nomEntreprise, int numeroSIRET, String adresse){
        //this.clients.add(new Entreprise(nomEntreprise, adresse, numeroSIRET));
        Entreprise e = new Entreprise(nomEntreprise, adresse, numeroSIRET);
        if(!this.clientExiste(e)){
            //si le client n'existe pas
            this.clients.add(e);
        }
        return e;
    }
    
    /**
     *
     * @param nomParticulier
     * @param prenomParticulier
     * @param adresseParticulier
     * @return
     */
    public Particulier creerParticulier(String nomParticulier, String prenomParticulier, String adresseParticulier){
        Particulier p = new Particulier(nomParticulier, prenomParticulier, adresseParticulier);
        if(!this.clientExiste(p)){
            //si le client n'existe pas
            this.clients.add(p);
        }
        return p;
    }
    
    /**
     *
     * @param nom
     * @return
     */
    public Client rechercheClient(String nom){
        int clientN = -1;
        for(int i=0;i<this.clients.size();i++){
            if(this.clients.get(i).donneNom().equals(nom)){
                clientN = i;
            }
        }
        if(clientN == -1){
            return this.clients.get(clientN);
        }
        else {
            return null;
        }
    }
    
    /**
     *
     * @param num
     * @return
     */
    public CompteBancaire rechercheCompte(int num){
        int itrouve = -1;
        int jtrouve = -1;
        CompteBancaire compte;
        for(int i=0;i<this.clients.size();i++){
            for(int j=0;j<this.clients.get(i).donneComptes().size();i++){
                if(this.clients.get(i).donneComptes().get(j).donneNumero() == num){
                    itrouve = i;
                    jtrouve = j;
                }
            }
        }
        if(itrouve!=-1&&jtrouve!=-1){
            compte = this.clients.get(itrouve).donneComptes().get(jtrouve);
        } else {
            compte = null;
        }
        return compte;
    }
    
    /**
     *
     * @param nomClient
     * @return
     */
    public ArrayList<CompteBancaire> rechercheCompte(String nomClient){
        Client c = this.rechercheClient(nomClient);
        boolean clientExiste = this.clientExiste(c);
        if(clientExiste){
            return c.donneComptes();
        } else {
            return null;
        }
    }
    
    /**
     *
     * @param nomClient
     * @return
     */
    public boolean supprimerClient(String nomClient){
        boolean ok = false;
        for(int i=0;i<this.clients.size();i++){
            if(this.clients.get(i).donneNom().equals(nomClient)){
                if(this.clients.get(i).donneComptes().size()==0){
                    this.clients.remove(i);
                    ok = true;
                }
            }
        }
        return ok;
    }
    
    /**
     *
     * @param numeroCompte
     * @return
     */
    public boolean supprimerCompte(int numeroCompte){
        boolean ok = false;
        for(int i=0;i<this.clients.size();i++){
            for(int j=0;i<this.clients.get(i).donneComptes().size();j++){
                if(this.clients.get(i).donneComptes().get(j).donneNumero() == numeroCompte){
                    this.clients.get(i).donneComptes().remove(j);
                    ok = true;
                }
            }
        }
        return ok;
    }
    
    /**
     *
     * @param numeroCpteDebiteur
     * @param banqueCrediteur
     * @param numeroCpteCrediteur
     * @param montant
     * @return
     */
    public boolean transfertInterBancaire(int numeroCpteDebiteur, Banque banqueCrediteur, int numeroCpteCrediteur, double montant){
        CompteBancaire deb = this.rechercheCompte(numeroCpteDebiteur);
        CompteBancaire crd = banqueCrediteur.rechercheCompte(numeroCpteCrediteur);
        
        //effectue les opérations de transfert
        if(deb!=null&&crd!=null){
            //vérifie si le montant du débiteur est supérieur au montant à retirer
            if(deb.consulter()<montant+5.0){
                //montant invalide
                return false;
            } else {
                //montant valide
                deb.debiter(montant+5.0);
                crd.crediter(montant);
            }
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Vérifie l'existance d'un client Particulier ou Entreprise dans la liste des clients
     * @param c Particulier ou Entreprise
     * @return booléen du test d'existance
     */
    public boolean clientExiste(Client c){
        boolean existe = false;
        for(int i=0;i<this.clients.size();i++){
            if(c instanceof Particulier){
                //si le client recherché est un particulier
                Particulier p = (Particulier) c;
                Particulier b = (Particulier) this.clients.get(i);
                if(p.donneNom().equals(b.donneNom()) && p.donnePrenom().equals(b.donnePrenom())){
                    existe = true;
                }
            } else if(c instanceof Entreprise){
                //si le client recherché est une entreprise
                Entreprise e = (Entreprise) c;
                Entreprise b = (Entreprise) this.clients.get(i);
                if(e.donneNom().equals(b.donneNom()) && e.donneNumeroSIRET() == b.donneNumeroSIRET()){
                    existe = true;
                }
            }
        }
        return existe;
    }
}
