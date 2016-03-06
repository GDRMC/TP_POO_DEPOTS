package gdr.tp.tp6.ex1_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GDR
 */
public class Test1_1 {

    public static void main(String[] args) {
        Animal a1 = new ReptileTerrestre("test", true, "test");
        Animal a2 = new ReptileAquatique("test", true, true);
        Animal a3 = new MammifereTerrestre("test", true, "test");
        Animal a4 = new MammifereAquatique("test", true, true);
        System.out.println(
                a1 + "\n"
                + a2 + "\n"
                + a3 + "\n"
                + a4
        );
        if (Animal.mammifereAquatique == 1) {
            System.out.println("Mammifere Aquatique ok");
        } else {
            try {
                throw new Exception("Erreur classe mammifère aquatique");
            } catch (Exception ex) {
                Logger.getLogger(Test1_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (Animal.mammifereTerrestre == 1) {
            System.out.println("Mammifere Terrestre ok");
        } else {
            try {
                throw new Exception("Erreur classe mammifère terrestre");
            } catch (Exception ex) {
                Logger.getLogger(Test1_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (Animal.reptileAquatique == 1) {
            System.out.println("Reptile Aquatique ok");
        } else {
            try {
                throw new Exception("Erreur classe reptile aquatique");
            } catch (Exception ex) {
                Logger.getLogger(Test1_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (Animal.reptileTerrestre == 1) {
            System.out.println("Reptile Terrestre ok");
        } else {
            try {
                throw new Exception("Erreur classe reptile terrestre");
            } catch (Exception ex) {
                Logger.getLogger(Test1_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(
                Animal.mammifereAquatique + " "
                + Animal.mammifereTerrestre + " "
                + Animal.reptileAquatique + " "
                + Animal.reptileTerrestre + " "
        );
    }

}
