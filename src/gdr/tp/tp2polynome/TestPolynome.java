package gdr.tp.tp2polynome;


/**
 * Repr&eacute;sente une s&eacute;rie de test pour la classe <code>Polynome</code>.
 */ 
public class TestPolynome
{
    public static void main(String[] args)
    {
        Polynome p1 = new Polynome(new int[][]{{1,5},{2,0},{1,2},{3,4}});
        Polynome test1 = new Polynome(new int[][]{{3,4},{1,2},{2,0},{1,5}});
        if (!p1.equals(test1))
        {
            System.out.println("test 1 : pb sur construction p1");
        }
        Polynome test2 = new Polynome(new int[][]{{1,5},{2,0},{1,2},{3,4},{0,2}});
        if (!p1.equals(test2))
        {
            System.out.println("test 2 : pb sur construction p1");
        }
        Polynome p2 = new Polynome(new int[][]{{2,5},{3,2},{3,1}});
        Polynome add = p1.addition(p2);
        Polynome test3 = new Polynome(new int[][]{{3,5},{3,4},{2,0},{3,1},{4,2}});
        if (!add.equals(test3))
        {
            System.out.println("test 3 : pb sur addition");
        }
        else
        {
            System.out.println(p1 + " + " + p2 + " = " + add);
        }
        // A DECOMMENTER LORSQUE LA METHODE derive() SERA REALISEE.
        /*
        Polynome derivation = p1.derive();
        Polynome test4 = new Polynome(new int[][]{{5,4},{12,3},{2,1}});
        if (!derivation.equals(test4))
        {
            System.out.println("test 4 : pb sur derivation");
        }
        else
        {
            System.out.println("Deriv'ee de " + p1 + " = " + derivation);
        }
        */
    }
}
