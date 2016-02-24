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
public class TestClass {

    public static void main(String[] args) {
        System.out.println(new ExpressionEt(new Variable("A"), new ExpressionEt(new Variable("B"), new Variable("C"))));
        System.out.println(new ExpressionOu(new Variable("A"),
                new ExpressionEt(new Variable("B"),
                        new ExpressionNegation(new Variable("C")))));
    }
}
