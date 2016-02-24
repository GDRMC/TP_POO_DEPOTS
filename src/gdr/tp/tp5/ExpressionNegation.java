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
class ExpressionNegation extends ExpressionBooleenne {

    public ExpressionNegation(Variable variable) {
        super(variable.valeur());
    }
    
}
