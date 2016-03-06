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
public abstract class Mammifere extends Animal {

    private boolean carnivore;

    public Mammifere(String nomEspece, boolean carnivore) {
        super(nomEspece);
        this.carnivore = carnivore;
    }
}
