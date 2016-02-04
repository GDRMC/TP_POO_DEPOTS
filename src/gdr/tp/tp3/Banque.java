package gdr.tp.tp3;

import java.util.ArrayList;

public class Banque {

    private String nomBanque;

    private ArrayList<Client> clients;
    private ArrayList<CompteBancaire> comptes;

    /**
     * Constructeur Banque
     * @param nomBanque Nom de la Banque
     */
    public Banque(String nomBanque) {
        this.nomBanque = nomBanque;
        this.clients = new ArrayList();
        this.comptes = new ArrayList();
    }

    /**
     * Crée un compte bancaire rémunéré dans la liste des comptes bancaires de la banque
     * @param soldeInitial solde initial du compte
     * @param tauxInteret taux d'interêt du compte (prend le dessus sur le taux par défaut)
     * @param nomClient nom du client (si le client n'existe pas, le compte n'est pas ajouté
     * @return compte créé
     */
    public CompteBancaireRemunere creerCompteRemunere(double soldeInitial, double tauxInteret, String nomClient) {
        Client c = this.rechercheClient(nomClient);
        boolean insert = false;
        CompteBancaireRemunere compte = null;
        if (c != null) {
            compte = new CompteBancaireRemunere(soldeInitial, tauxInteret, c);
            this.comptes.add(compte);
            insert = true;
        }
        if (insert) {
            return compte;
        } else {
            return null;
        }
    }

    /**
     * Ajoute un client de type Entreprise à l'ArrayList des clients
     * @param nomEntreprise nom de l'entreprise
     * @param numeroSIRET numéro de SIRET de l'entreprise
     * @param adresse adresse de l'entreprise
     * @return entreprise créée
     */
    public Entreprise creerEntreprise(String nomEntreprise, int numeroSIRET, String adresse) {
        Entreprise e = new Entreprise(nomEntreprise, adresse, numeroSIRET);
        boolean ok = false;
        if (this.rechercheClient(nomEntreprise) == null) {
            ok = true;
        }
        if (ok) {
            this.clients.add(e);
            return e;
        } else {
            return null;
        }
    }

    /**
     * Ajoute un client de type Particulier à l'ArrayList des clients
     * @param nomParticulier nom du client
     * @param prenomParticulier adresse du client
     * @param adresseParticulier adresse du client
     * @return particulier créé
     */
    public Particulier creerParticulier(String nomParticulier, String prenomParticulier, String adresseParticulier) {
        Particulier p = new Particulier(nomParticulier, prenomParticulier, adresseParticulier);
        boolean ok = false;
        if (this.rechercheClient(nomParticulier) == null) {
            ok = true;
        }
        if (ok) {
            this.clients.add(p);
            return p;
        } else {
            return null;
        }
    }

    /**
     * Recherche d'un client par son nom (Particulier ou Entreprise)
     * @param nom nom du client (particulier ou entreprise)
     * @return client (si existant)
     */
    public Client rechercheClient(String nom) {
        boolean trouve = false;
        int pos = -1;
        for (int i = 0; i < this.clients.size(); i++) {
            if (this.clients.get(i).donneNom().equals(nom)) {
                trouve = true;
                pos = i;
            }
        }
        if (trouve && pos >= 0) {
            return this.clients.get(pos);
        } else {
            return null;
        }
    }

    /**
     * Recherche d'un compte bancaire dans les comptes clients de la banque
     * @param num numéro de compte recherché
     * @return compte (si existant)
     */
    public CompteBancaire rechercheCompte(int num) {
        int pos = -1;
        boolean trouve = false;
        for (int i = 0; i < this.comptes.size(); i++) {
            if(this.comptes.get(i).donneNumero() == num){
                pos = i;
            }
        }
        if(trouve && pos >= 0){
            return this.comptes.get(pos);
        } else {
            return null;
        }
    }

    /**
     * Recherche d'un ensemble de comptes appartenant à un client
     * @param nomClient nom du client
     * @return ArrayList des comptes associés à ce client
     */
    public ArrayList<CompteBancaire> rechercheCompte(String nomClient) {
        Client c = this.rechercheClient(nomClient);
        ArrayList<CompteBancaire> cpts = new ArrayList();
        if (c!=null) {
            for(int i=0;i<this.comptes.size();i++){
                if(this.comptes.get(i).donneDetenteur().donneNom().equals(nomClient)){
                    cpts.add(this.comptes.get(i));
                }
            }
            return cpts;
        } else {
            return null;
        }
    }

    /**
     * Supprime un client de la liste s'il n'a pas de comptes associés
     * @param nomClient nom du client
     * @return etat de la suppression
     */
    public boolean supprimerClient(String nomClient) {
        boolean peutsupprimer = true;
        if(this.rechercheCompte(nomClient).size()>0){
            peutsupprimer = false;
        }
        for (int i = 0; i < this.clients.size(); i++) {
            if (this.clients.get(i).donneNom().equals(nomClient)) {
                this.clients.remove(i);
            }
        }
        return peutsupprimer;
    }

    /**
     * Supprime un compte par le numéro du compte
     * @param numeroCompte numéro du compte visé
     * @return etat de la suppression
     */
    public boolean supprimerCompte(int numeroCompte) {
        boolean ok = false;
        for (int i = 0; i < this.comptes.size(); i++) {
            if(this.comptes.get(i).donneNumero() == numeroCompte){
                this.comptes.remove(i);
                ok = true;
            }
        }
        return ok;
    }

    /**
     * Transfert interbancaire
     * @param numeroCpteDebiteur numéro de compte du débiteur
     * @param banqueCrediteur objet banque du créditeur
     * @param numeroCpteCrediteur numéro de compte du créditeur dans sa banque
     * @param montant montant à transférer
     * @return état de la transaction
     */
    public boolean transfertInterBancaire(int numeroCpteDebiteur, Banque banqueCrediteur, int numeroCpteCrediteur, double montant) {
        CompteBancaire deb = this.rechercheCompte(numeroCpteDebiteur);
        CompteBancaire crd = banqueCrediteur.rechercheCompte(numeroCpteCrediteur);

        //effectue les opérations de transfert
        if (deb != null && crd != null) {
            //vérifie si le montant du débiteur est supérieur au montant à retirer
            if (deb.consulter() < montant + 5.0) {
                //montant invalide
                return false;
            } else {
                //montant valide
                deb.debiter(montant + 5.0);
                crd.crediter(montant);
            }
            return true;
        } else {
            return false;
        }
    }
}
