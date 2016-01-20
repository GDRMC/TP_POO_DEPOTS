package gdr.tp.tp2;

/**
 * Lanceur du programme de test de la classe Relationnel
 * @author USER
 */
public class LauncherRationnel {

    /**
     * Fonction main
     * @param args
     */
    public static void main(String[]args){
        Rationnel r1 = new Rationnel(2, 3);
        Rationnel r2 = new Rationnel(4, 5);
        
        disp(r1.toString());
        disp(r2.toString());
        sp();
        
        Rationnel r3 = r1.add(r2);
        Rationnel r4 = r1.minus(r2);
        Rationnel r5 = r1.multiply(r2);
        Rationnel r6 = r1.divide(r2);
        
        disp(r3.toString());
        disp(r4.toString());
        disp(r5.toString());
        disp(r6.toString());
        sp();
        
        Rationnel r7 = r1.reverse();
        Rationnel r8 = r1.opposite();
        
        disp(r7.toString());
        disp(r8.toString());
        sp();
        
        double r9 = r1.getReal();
        disp(r1.toString()+" -> "+r1.getReal());
    }
    
    public static void disp(String s){
        System.out.println(s);
    }
    public static void sp(){
        System.out.print("\n");
    }
}
