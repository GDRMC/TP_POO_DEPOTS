package gdr.tp.tp2;

@Deprecated
public class TestRationnel
{
    // Cette fois-ci c'est vous qui ecrivez les tests...
	// Le principe est simple : vous appelez la methode a tester
	// avec certaines valeurs et vous verifiez que le resultat
	// retourn'e est correct.
    public static void main(String[] args)
    {
        Rationnel r1 = new Rationnel(2, 3);
        Rationnel r2 = new Rationnel(4, 5);
		
		// exemple : test pour l'addition de r1 et r2
        Rationnel resPlus = r1.add(r2);
        Rationnel resPlusRef = new Rationnel(22, 15);
        if (!resPlus.equals(resPlusRef))
        {
            System.out.println("Pb sur l'addition");
        }

        // 'ecrire le test pour la multiplication de r1 et r2...
		
        // test de l'inverse qui consiste qui consiste a appliquer
		// 2 fois la methode inverse a un rationnel et a verifier 
		// qu'au final on retrouve ce rationnel

        // dernier test permettant de verifier qu'on ne peut pas 
		// cr'eer un rationnel avec un d'enominateur 'egal a z'ero.
	
    }
}
