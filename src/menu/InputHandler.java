package menu;

import java.util.Scanner;

public class InputHandler
{
    private static Scanner sc = new Scanner(System.in);

    public static int getChoice(int maxOptionIndex) {
        int choice;

        while(true) {

            System.out.print("Saisir votre choix : ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 0 || choice > maxOptionIndex) {
                    System.out.println("Choix non valide. Réessayez.");
                } else {
                    return choice;
                }

            } catch (NumberFormatException e) {
                System.out.println("Erreur: Veuillez entrer un nombre valide.");
            }
        }
    }
}
