package gdr.tp.tp5;

/**
 *
 * @author GDR
 */
public abstract class ExpressionBinaire extends ExpressionBooleenne {
    
    public ExpressionBinaire(ExpressionBooleenne gauche, ExpressionBooleenne droite){
        super(gauche, droite);
    }
    
}
