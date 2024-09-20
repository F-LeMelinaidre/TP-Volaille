package menu;

import java.util.Scanner;

public class MenuHandler {

    private Scanner sc = new Scanner(System.in);
    protected IMenuHandler currentHandler = null;
    protected int choice = -1;
    protected int maxOptions;

    protected void setCurrentMenu(IMenuHandler currentHandler) {
        this.currentHandler = currentHandler;
    }

    private int getChoice(int maxOptions) {

        choice = -1;

        System.out.print("Saisir votre choix : ");

        try {
            choice = Integer.parseInt(sc.nextLine());
            if (choice < 0 || choice > maxOptions) {
                System.out.println("Choix non valide. Réessayez.");
                choice = -1;
            }

        } catch (NumberFormatException e) {
            System.out.println("Erreur: Veuillez entrer un nombre valide.");
        }
        return choice;

    }

    public void run() {
        if (this.currentHandler == null) this.currentHandler = MainMenuHandler.getInstance();
        while(true) {
            System.out.println(choice);
            this.currentHandler.handleMenu();
            this. choice = this.getChoice(this.maxOptions);
        }
    }





    /*public void run() {
        while (true) {
            this.currentHandler.handleMenu();
            this.getChoice(this.maxOptions);
        }
    }

    protected int getChoice(int maxOptions) {

        choice = -1;

        System.out.print("Saisir votre choix : ");

        try {
            choice = Integer.parseInt(sc.nextLine());
            if (choice < 0 || choice > maxOptions) {
                System.out.println("Choix non valide. Réessayez.");
                choice = -1;
            }

        } catch (NumberFormatException e) {
            System.out.println("Erreur: Veuillez entrer un nombre valide.");
        }
        return choice;

    }

    protected void printMenu() {
        this.menu.render();
    }*/
}
