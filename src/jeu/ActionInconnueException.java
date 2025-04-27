package jeu;

// Exception personnalisée
public class ActionInconnueException extends Exception {
    ActionInconnueException(String message) {
        super(message);
    }
}