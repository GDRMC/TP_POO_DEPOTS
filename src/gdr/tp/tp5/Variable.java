/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdr.tp.tp5;

/**
 *
 * @author GDR
 */
public class Variable extends ExpressionBooleenne {
    
    
    public Variable(String a) {
        super(a);
    }
    
    @Override
    public String toString(){
        return super.valeur().toString();
    }
}
