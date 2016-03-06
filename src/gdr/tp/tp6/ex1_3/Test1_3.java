package gdr.tp.tp6.ex1_3;

import java.util.ArrayList;

/**
 *
 * @author GDR
 */
public class Test1_3 {

    public static void main(String[] args) {
        ArrayList<Animal> list = new ArrayList<>();
        Animal a1 = new ReptileTerrestre("test", true, "test");
        Animal a2 = new ReptileAquatique("test", true, true);
        Animal a3 = new MammifereTerrestre("test", true, "test");
        Animal a4 = new MammifereAquatique("test", true, true);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        System.out.println(
                a1 + "\n"
                + a2 + "\n"
                + a3 + "\n"
                + a4
        );
        if (a1 instanceof Reptile && a2 instanceof Reptile) {
            System.out.println("Interface Reptile OK");
        }
        if (a3 instanceof Mammifere && a4 instanceof Mammifere) {
            System.out.println("Interface Mammifere OK");
        }

        int reptTerr = 0;
        int reptAqua = 0;
        int mammTerr = 0;
        int mammAqua = 0;
        for (int i = 0; i < list.size(); i++) {
            Animal item = list.get(i);
            if (item instanceof Reptile && item instanceof Terrestre) {
                reptTerr++;
            }
            if (item instanceof Reptile && item instanceof Aquatique) {
                reptAqua++;
            }
            if (item instanceof Mammifere && item instanceof Terrestre) {
                mammTerr++;
            }
            if (item instanceof Mammifere && item instanceof Aquatique) {
                mammAqua++;
            }

        }
        System.out.println(
                reptTerr + "\n"
                + reptAqua + "\n"
                + mammTerr + "\n"
                + mammAqua
        );
    }
}
