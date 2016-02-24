package gdr.tp.tp5;

/**
 *
 * @author GDR
 */
public abstract class ExpressionBooleenne {
    
    private ExpressionBooleenne gauche;
    private ExpressionBooleenne droite;
    
    private String a;
    
    public ExpressionBooleenne(ExpressionBooleenne gauche, ExpressionBooleenne droite){
        this.gauche = gauche;
        this.droite = droite;
    }
    
    public ExpressionBooleenne(String a){
        this.a = a;
    }
   
    public ExpressionBooleenne getGauche(){
        return this.gauche;
    }
    
    public ExpressionBooleenne getDroite(){
        return this.droite;
    }
    
    public String valeur(){
        return this.a;
    }
    
    @Override
    public String toString(){
        String toReturn = "";
        if(this instanceof Variable){
            toReturn = a;
        } else if(this instanceof ExpressionNegation){
            toReturn = "non ("+a+")";
        } else if(this instanceof ExpressionEt){
            toReturn = "("+getGauche().toString()+" et "+getDroite().toString()+")";
        } else if(this instanceof ExpressionOu){
            toReturn = "("+getGauche().toString()+" ou "+getDroite().toString()+")";
        }
        return toReturn;
    }
}
