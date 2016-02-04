package gdr.tp.tp3;

/** classe de test pour CompteBancaire */
public class TestBanque
{

    /**
     * Test classe Banque
     * @param args arguments vm
     */
    public static void main(String[] args)
  {
    Banque banque = new Banque("CLC");

    // test creation intiale
    Particulier durand = banque.creerParticulier("Durand", "Robert", "La Rochelle");
    if (durand == null) {
        System.out.println("Probleme sur creation intiale du client Durand");
        System.exit(-1);        
    }
    // test pour verifier que la creation de doublons n'est pas possible
    durand = banque.creerParticulier("Durand", "Robert", "La Rochelle");
    if (durand != null) {
        System.out.println("Probleme sur creation client : doublon");
        System.exit(-1);        
    }
    Particulier martin = banque.creerParticulier("Martin", "Roger", "Nantes");
    if (martin == null) {
        System.out.println("Probleme sur creation intiale d'un client Martin");
        System.exit(-1);        
    }
    CompteBancaireRemunere c1 = banque.creerCompteRemunere(100,5.5,"Durand");
    if (c1 == null) {
        System.out.println("Probleme sur creation intiale d'un compte");
        System.exit(-1);        
    }  
    CompteBancaireRemunere c2 = banque.creerCompteRemunere(0.,4.5,"Martin");
    if (c2 == null) {
        System.out.println("Probleme sur creation intiale d'un compte");
        System.exit(-1);        
    }
    // test pour verifier que la creation d'un compte n'est pas possible
    // lorsque le client n'existe pas...
    CompteBancaireRemunere c3 = banque.creerCompteRemunere(0.,4.5,"Schtroumpf");
    if (c3 != null) {
        System.out.println("Probleme sur creation intiale d'un compte avec client inconnu");
        System.exit(-1);        
    }   
    
    
    //TEST MANUELS QUESTION 8
    
    //test nombre de comptes maxi par client > 3 part en erreur
    Banque banque2 = new Banque("Banque Picsou");
    Particulier p1 = banque2.creerParticulier("Dupont", "Jean-Daniel", "Poitiers");
    CompteBancaireRemunere cpt1 = banque2.creerCompteRemunere(1685.74, 4.6, "Dupont");
    CompteBancaireRemunere cpt2 = banque2.creerCompteRemunere(764.94, 4.6, "Dupont");
    CompteBancaireRemunere cpt3 = banque2.creerCompteRemunere(78924.45, 4.6, "Dupont");
    CompteBancaireRemunere cpt4 = banque2.creerCompteRemunere(148.94, 4.6, "Dupont");
    if(banque2.rechercheCompte("Dupont").size()>3){
        System.out.println("TEST Q8: Erreur, le client Martin possède plus de 3 comptes");
        System.exit(-1);
    }
    
    //test suppression de client s'il possède des comptes
    banque2.supprimerClient("Dupont");
    if(banque2.rechercheClient("Dupont") == null){
        System.out.println("Test Q8: Erreur, un client possèdant des comptes a été supprimé");
        System.exit(-1);
    }
    
    double montant = 10;
    double crdav = banque.rechercheCompte("Durand").get(0).consulter();
    double debav = banque2.rechercheCompte("Dupont").get(0).consulter();
    banque2.transfertInterBancaire(2, banque, 0, montant);
    double crdap = banque.rechercheCompte("Durand").get(0).consulter();
    double debap = banque2.rechercheCompte("Dupont").get(0).consulter();
    System.out.println(debav+" "+crdav+" > "+debap+" "+crdap);
    if((debap != debav-(montant+5)) || crdap != crdav+montant){
        System.out.println("Test Q8: Erreur, le tranfert interbancaire ne satisfait pas les conditions énoncées");
        System.out.println(debav+" "+crdav+" > "+debap+" "+crdap);
        System.exit(-1);
    }
  }
}