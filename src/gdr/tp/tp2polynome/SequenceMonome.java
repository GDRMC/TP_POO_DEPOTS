package gdr.tp.tp2polynome;

public class SequenceMonome {
    
    private int[][] liste;
    
    public SequenceMonome(){
        this.liste = new int[0][0];
    }
    
    public SequenceMonome(int[][] listeCoeffDeg){
        //compte le nombre de monômes ayant un degré supérieur à 0
        //this.liste = listeCoeffDeg;
        
        //crée un tableau avec la longueur trouvée dans les degrés positifs
        int[][] newList = new int[this.nbDegreePositifs(listeCoeffDeg)][2];
        int curseur = 0;
        for(int j=0;j<listeCoeffDeg.length;j++){
            if(listeCoeffDeg[j][1]>=1){
                newList[curseur][0] = listeCoeffDeg[j][0];
                newList[curseur][1] = listeCoeffDeg[j][1];
                curseur++;
            }
        }
    }
    
    public void ajouterMonome(Monome mono){
        int[][] newList = new int[this.liste.length+1][2];
        newList[0][0] = mono.coeff();
        newList[0][1] = mono.degre();
        for(int i=0;i<this.liste.length;i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    newList[i][j] = mono.coeff();
                }
                else if(j==1){
                    newList[i][j] = mono.degre();
                }
                //debug only
                else{
                    System.out.println("ERREUR");
                }
            }
        }
        this.liste = newList;
    }
    
    public Monome donneMonome(int index){
        return new Monome(this.liste[index][0],this.liste[index][1]);
    }
    
    public int taille(){
        if(this.liste == null){
            return 0;
        } else {
            return this.liste.length;
        }
    }
    
    public int maxDegre(){
        int maxDegre = -1;
        if(this.liste == null){
            maxDegre = 0;
        } else if(this.liste.length>0) {
            for(int i=0;i<this.liste.length;i++){
                if(this.liste[i][1]>maxDegre){
                    maxDegre = this.liste[i][1];
                }
            }
        }
        return maxDegre;
    }
    
    public int maxDegre(int[][]listeNC){
        int maxDegre = -1;
        for(int i=0;i<listeNC.length;i++){
            if(listeNC[i][1]>maxDegre){
                maxDegre = listeNC[i][1];
            }
        }
        return maxDegre;
    }
    
    public int nbDegreePositifs(int[][]listeNC){
        int nb = 0;
        for(int i=0;i<listeNC.length;i++){
            if(listeNC[i][1]>0){
                nb++;
            }
        }
        return nb;
    }
}
