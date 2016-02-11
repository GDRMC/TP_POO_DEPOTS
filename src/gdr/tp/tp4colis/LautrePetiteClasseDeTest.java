package gdr.tp.tp4colis;

/**
 * Classe de test package Colis
 * @author gdr
 */
public class LautrePetiteClasseDeTest {
    
    /**
     * Classe Main
     * @param args
     */
    public static void main(String[]args){
        Conteneur c1 = new Conteneur(25, 8);
        ConteneurUrgent c2 = new ConteneurUrgent(10, 4, 14);
        
        c1.ajout(new Colis(12, 7));
        c1.ajout(new Colis(10, 9));
        if(!c1.ajout(new Colis(20, 10))){
            System.out.println("Dépassement c1 colis 3");
            System.exit(1);
        }
        
        c2.ajout(new Colis(2, 10));
        if(!c2.ajout(new Colis(50, 2))){
            System.out.println("Dépassement c2 colis 2 poids");
            System.exit(1);
        }
        
        if(!c2.ajout(new Colis(3, 60))){
            System.out.println("Dépassement c2 colis 2 volume");
            System.exit(1);
        }
    }
    
}
