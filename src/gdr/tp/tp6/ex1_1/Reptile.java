/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdr.tp.tp6.ex1_1;

/**
 *
 * @author GDR
 */
public abstract class Reptile extends Animal {

    
    
    private String nomEspece;
    private boolean venimeux;

    public Reptile(String nomEspece, boolean venimeux) {
        super(nomEspece);
        this.venimeux = venimeux;
    }

}
