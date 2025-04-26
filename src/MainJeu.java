import java.util.Scanner;

public class MainJeu {

    public static void main(String[] args) {
        // Créer un objet Jeu
        Jeu jeu = new Jeu();

        // Charger un jeu depuis un fichier (par exemple, "labyrinthe.txt")
        jeu = Chargement.chargerJeu("../laby/laby.txt");

        // Afficher le jeu initial
        System.out.println("Jeu chargé avec succès!");
        System.out.println(jeu.jeuToString());

        // Scanner pour les entrées utilisateur
        Scanner scanner = new Scanner(System.in);

        // Boucle principale du jeu
        while (!jeu.etreFini()) {
            System.out.println("Déplacez le personnage (haut, bas, gauche, droite) : ");
            String action = scanner.nextLine();

            // Déplacer le personnage selon l'action donnée
            jeu.deplacerPerso(action);

            // Afficher l'état actuel du jeu après le déplacement
            System.out.println(jeu.jeuToString());
        }

        // Le jeu est terminé
        System.out.println("Félicitations ! Vous avez terminé le jeu !");

        // Fermer le scanner
        scanner.close();
    }
}
