class Chargement{

    static Jeu chargerJeu(String nomFichier){ // à revoir
        //On crée labyrinthe
        int ligne = 0;
        int colonne = 0;

        //Utile pour déterminer les dimensions finales
        int max_colonne = 0;


        FileReader fr = FileReader(nomFichier);
        int lecture;

        while((lecture = fr.read())!=null){
            //Chaque ligne est un nouveau X
            //Chaque caractère est un nouveau Y

            //Chaque fr.read doit incrementer y
            //Chaque saut de ligne : rétablit y à 0  +  incrémente x

                switch(lecture) {
                    case '#':
                        jeu.laby.murs.setMur(ligne,colonne);
                        break;

                    case '$':
                        jeu.caisses.add(new Caisse(ligne,colonne));

                    case '.':
                        jeu.depots.add(new Depot(ligne,colonne));

                    case '@:
                        jeu.perso.setPosition(ligne,colonne);
                        break;

                    case ' ':
                        break;

                    default:
                        break;
                }

                if(lecture == '\n'){colonne= 0;}
                else{colonne++;}


                if (colonne > max_colonne) {max_colonne = colonne;}


        }
        fr.close();
        jeu.laby.setDimensions(ligne + 1, max_colonne);
        return jeu;
    }
    }



}