class Jeu {

    Perso perso;
    ListeElements caisses;
    ListeElements depots;
    Labyrinthe laby;

    String HAUT = "Haut";
    String BAS = "bas";
    String DROITE = "droite";
    String GAUCHE = "gauche";

    /*
        Condition de fin
        Renvoi true si le jeu est fini
    */
    static boolean etreFini(){
        boolean trouve;

        for(c : caisses){
            trouve = false;
            int x = c.getX;
            int y = c.getY;

            //On verifie chaque dépôt
            for(d : depots){
                if(x=d.getX && y=d.getY){
                    trouve = true ;
                }
            }
            //Si une des caisses n'est ps sur un depots, alors le jeu continue
            if(trouve==false){
                return false;
            }
        }
        return true;
    }

    static int[] getSuivant(int x, int y, String action){
        switch(action){
            case HAUT:
                return new int[]{x, y-1};
                break;
            case BAS:
                return new int[]{x, y+1};
                break;
            case DROITE:
                return new int[]{x+1, y};
                break;
            case GAUCHE :
                return new int[]{x-1, y};
                break;
            default:
                return null;

        }
    }

    public Element getElement(int x, int y) {
        for (Element e : elements) {
            if (e.getX() == x && e.getY() == y) {
                return e;
            }
        }
        return null;
    }


    void deplacerPerso(String action) {
        int x = perso.getX();
        int y = perso.getY();

        int[] cible = getSuivant(x, y, action);
        int cx = cible[0];
        int cy = cible[1];

        // Mur : déplacement impossible
        if (laby.etreMur(cx, cy)) return;

        // Caisse présente ?
        Element caisse = caisses.getElement(cx, cy);

        if (caisse == null) {
            // Case vide ou dépôt : déplacement libre
            perso.deplacement(action);
        } else {
            // Tenter de pousser la caisse
            int[] cible2 = getSuivant(cx, cy, action);
            int cx2 = cible2[0];
            int cy2 = cible2[1];

            if (!laby.etreMur(cx2, cy2) && caisses.getElement(cx2, cy2) == null) {
                caisse.deplacement(action);
                perso.deplacement(action);
            }
        }
    }





    /*
    savoir quoi afficher à une case donnée.
     */
    char getChar(int x, int y) {
        if (perso.getX() == x && perso.getY() == y) return '@';

        for (Element c : caisses) {
            if (c.getX() == x && c.getY() == y) return '$';
        }

        for (Element d : depots) {
            if (d.getX() == x && d.getY() == y) return '.';
        }

        if (laby.etreMur(x, y)) return '#';

        return ' ';
    }

    String jeuToString() {
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < laby.getHauteur(); x++) {
            for (int y = 0; y < laby.getLargeur(); y++) {
                sb.append(getChar(x, y));
            }
            sb.append('\n');
        }

        return sb.toString();
    }






}