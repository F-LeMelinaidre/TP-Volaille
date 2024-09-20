package menu;

import asset.VolailleType;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenuHandler extends MenuHandler implements IMenuHandler
{

    private static IMenuHandler Instance;
    private ArrayList options = new ArrayList<>(
            Arrays.asList("Afficher tous les lots", "Afficher les lots de Canards", "Afficher les lots de Poulets", "Quitter"));

    private MainMenuHandler() {
        this.maxOptions = this.options.size();/*
        this.menu.setTitle("Menu Principal");
        this.menu.setOptions(this.options);*/

    }

    protected static IMenuHandler getInstance() {
        if (Instance == null) {
            Instance = new MainMenuHandler();
        }
        return Instance;
    }


    @Override
    public void handleMenu() {
        this.setCurrentMenu(this);
        switch (choice) {
            case 0:
            case 1:
            case 2:

                break;
            case 3:
                // TODO Enregistrer les données
                System.out.println("Au revoir");
                System.exit(0);
                break;
            default:
                this.currentHandler = new MainMenuHandler();
                break;
        }

    }
}
