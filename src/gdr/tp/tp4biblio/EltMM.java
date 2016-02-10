package gdr.tp.tp4biblio;

public class EltMM {
    
    private String titre;
    private int duree;
    private String commentaire;
    private boolean presentEnRayon;
    
    public EltMM(String titre, int duree){
        this.titre = titre;
        this.duree = duree;
        this.presentEnRayon = false;
        this.commentaire = "<pas de commentaire>";
    }
    
    public String donneTitre(){
        return this.titre;
    }
    public int donneDuree(){
        return this.duree;
    }
    
    public void changeEtatRayon(boolean etat) {
        this.presentEnRayon = etat;
    }
    
    public boolean donneEtatRayon() {
        return this.presentEnRayon;
    }
    
    public String donneCommentaires() {
        return this.commentaire;
    }
    
    public void ajouteCommentaire(String str){
        this.commentaire = str;
    }
    
    public String donneType(){
        if(this instanceof CD){
            return "CD";
        } else if(this instanceof DVD){
            return "DVD";
        } else {
            return "EltMM";
        }
    }
    
    public String toString() {
        String s = "";
        s += "Titre : " + this.donneTitre() + "\n";
        s += "Duree : " + this.donneDuree() + "\n";
        s += "Etat : ";
        if (this.donneEtatRayon()) {
            s += "disponible\n";
        } else {
            s += "emprunte\n";
        }
        s += "Commentaires : " + this.donneCommentaires() + "\n";
        return s;
    }
}
