package jeu;

import java.util.ArrayList;

class ListeElements{

    ArrayList<Element> liste;

    ListeElements(){
        liste = new ArrayList<Element>();
    }
    void ajouterElement(Element element) {
        liste.add(element);
    }

    /* etirer un élément de la liste */
    void retirerElement(Element element) {
        liste.remove(element);
    }

    /* Obtenir un élément par index */
    Element obtenirElement(int index) {
        if (index >= 0 && index < liste.size()) {
            return liste.get(index);
        } else {
            System.out.println("Index hors limite.");
            return null;
        }
    }

    /* Obtenir la taille de la liste */
    int taille() {
        return liste.size();
    }

    /* Vérifier si un élément existe dans la liste */
    boolean contient(Element element) {
        return liste.contains(element);
    }

}