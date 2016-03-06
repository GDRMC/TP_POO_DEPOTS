/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdr.tp.tp6.ex1_2;

/**
 *
 * @author GDR
 */
public class Animal {
    
    public static int mammifereTerrestre = 0;
    public static int mammifereAquatique = 0;
    public static int reptileTerrestre = 0;
    public static int reptileAquatique = 0;
    
    private String nomEspece;

    public Animal(String nomEspece) {
        this.nomEspece = nomEspece;
        if(this instanceof MammifereTerrestre){
            mammifereTerrestre++;
        } else if(this instanceof MammifereAquatique){
            mammifereAquatique++;
        } else if(this instanceof ReptileTerrestre){
            reptileTerrestre++;
        } else if(this instanceof ReptileAquatique){
            reptileAquatique++;
        }
    }
}
