package menu;

import asset.VolailleType;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenuHandler implements IMenuHandler
{

    private MenuRenderer menu;
    private ArrayList options = new ArrayList<>(
            Arrays.asList("Afficher tous les lots", "Afficher les lots de Canards", "Afficher les lots de Poulets", "Quitter"));

    public MainMenuHandler(MenuRenderer menu) {

        this.menu = menu;
        this.menu.setTitle("Menu Principal");
        this.menu.setOptions(this.options);
        this.menu.render();
    }

    @Override
    public void handleMenu() {

        int choice = InputHandler.getChoice(options.size());

        switch (choice) {
            case 0:
            case 1:
            case 2:

                NavigationManager.menuVolailleGroup(this.menu, VolailleType.getById(choice));
                break;
            case 3:
                // TODO Enregistrer les données
                System.out.println("Au revoir");
                System.exit(0);
                break;
            default:
                NavigationManager.mainMenu(this.menu);
                break;
        }

    }
}
