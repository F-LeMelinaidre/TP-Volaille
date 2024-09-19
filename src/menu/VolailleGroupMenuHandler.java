package menu;

import controller.IController;

import java.util.ArrayList;
import java.util.Arrays;

public class VolailleGroupMenuHandler implements IMenuHandler
{

    private MenuRenderer menu;
    private IController controller;
    private ArrayList options = new ArrayList<>(
            Arrays.asList("Afficher un lot", "Ajouter un lot", "Sortir un lot", "Retour au menu principal"));

    public VolailleGroupMenuHandler(MenuRenderer menu, String label, IController instance) {

        this.menu = menu;
        this.menu.setOptions(this.options);
        this.menu.setTitle(label);
        this.menu.render();

        this.controller = instance;
    }

    @Override
    public void handleMenu() {
        int choice = InputHandler.getChoice(options.size());

        switch (choice) {
            case 0:
                this.controller.read();
                break;
            case 1:
                this.controller.create();
                break;
            case 2:
                this.controller.delete();
                break;
            case 3:
                NavigationManager.mainMenu(this.menu);
                break;
        }

    }
}
