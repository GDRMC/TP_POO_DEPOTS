package gdr.tp.tp4biblio;

public class PetiteClasseDeTest {
    
    public static void main(String[]args){
        BiblioMM bi = new BiblioMM();
        CD cd = new CD("EP II", "Carpenter Brut", 6, 26);
        DVD dvd = new DVD("Diededpool", "jesaisplus", 108);
        
        bi.ajouterCD(cd);
        bi.ajouterDVD(dvd);
        
        System.out.println(cd.toString());
        System.out.println(dvd.toString());
        
        boolean test1 = (!bi.rechercherTitre("Diededpool").isEmpty() && bi.rechercherTitre("Diededpool").get(0).donneEtatRayon());
        boolean test2 = bi.emprunterTitre("Diededpool");
        //System.out.println(test1+"\n"+test2);
        if(!(test1 == test2)){
            System.out.println("Impossible de réemprunter un objet");
            System.exit(1);
        }
        
        String t1 = cd.donneType();
        String t2 = dvd.donneType();
        EltMM elt = new EltMM("Test", 0);
        String t3 = elt.donneType();
        
        if(t1!="CD"){
            System.out.println("Erreur retour type CD");
            System.exit(1);
        }
        
        if(t2!="DVD"){
            System.out.println("Erreur retour type DVD");
            System.exit(1);
        }
        
        if(t3!="EltMM"){
            System.out.println("Erreur retour type EltMM");
            System.exit(1);
        }
    }
    
}
