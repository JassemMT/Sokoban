class Labyrinhe{

    int hauteur;
    int largeur;
    boolean[][] murs;
    //murs[x][y] vaut true si et seulement si la case (x,y) est un mur

    int getHauteur(){
        return hauteur;
    }

    int getLargeur(){
        return largeur;
    }

    boolean[][] getMurs(){
        return murs;
    }

    void setDimensions(int x, int y){
        this.hauteur = x;
        this.largeur = y;
        murs = new boolean[x][y];
    }

    /*
    Pour tester si les coordonnées d'un perso + 1 correspondent à un mur
     */
    boolean etreMur(int x,int y){
        if(murs[x][y] == true){
            return true;
        }
    }

    void setMur(int x,int y){
        murs[x][y] = true;
    }
}