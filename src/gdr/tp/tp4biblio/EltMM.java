package gdr.tp.tp4biblio;

/**
 * Classe élément de bibliothèque
 * @author gdr
 */
public class EltMM {
    
    private String titre;
    private int duree;
    private String commentaire;
    private boolean presentEnRayon;
    
    /**
     * Constructeur
     * @param titre titre
     * @param duree durée
     */
    public EltMM(String titre, int duree){
        this.titre = titre;
        this.duree = duree;
        this.presentEnRayon = false;
        this.commentaire = "<pas de commentaire>";
    }
    
    /**
     * Renvoie le titre
     * @return titre
     */
    public String donneTitre(){
        return this.titre;
    }

    /**
     * Renvoie la durée
     * @return durée
     */
    public int donneDuree(){
        return this.duree;
    }
    
    /**
     * Modifie la disponibilité en rayon
     * @param etat en rayon ?
     */
    public void changeEtatRayon(boolean etat) {
        this.presentEnRayon = etat;
    }
    
    /**
     * Renvoie la disponibilité dans le rayon
     * @return disponible ?
     */
    public boolean donneEtatRayon() {
        return this.presentEnRayon;
    }
    
    /**
     * Renvoie le(s) commentaires pour l'élément
     * @return
     */
    public String donneCommentaires() {
        return this.commentaire;
    }
    
    /**
     * Modifie le commentaire pour l'élément
     * @param str commentaire à entrer
     */
    public void ajouteCommentaire(String str){
        this.commentaire = str;
    }
    
    /**
     * Renvoie le type d'héritage de l'élément sous forme de String
     * @return str type élément
     */
    public String donneType(){
        if(this instanceof CD){
            return "CD";
        } else if(this instanceof DVD){
            return "DVD";
        } else {
            return "EltMM";
        }
    }
    
    /**
     *
     * @return
     */
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
