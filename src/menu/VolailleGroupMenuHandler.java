package menu;

import asset.VolailleType;
import controller.IController;

import java.util.ArrayList;
import java.util.Arrays;

public class VolailleGroupMenuHandler extends MenuHandler implements IMenuHandler
{

    private ArrayList options = new ArrayList<>(
            Arrays.asList("Afficher un lot", "Ajouter un lot", "Sortir un lot", "Retour au menu principal"));

    /*public VolailleGroupMenuHandler() {

        *//*this.maxOptions = this.options.size();
        this.menu.setTitle("Menu Principal");
        this.menu.setOptions(this.options);
        this.menu.render();*//*

    }*/

    @Override
    public void handleMenu() {


        switch (choice) {
            case 0:
                /*this.controller.read();*/
                break;
            case 1:
                /*this.controller.create();*/
                break;
            case 2:
                /*this.controller.delete();*/
                break;
            case 3:
                /*NavigationManager.mainMenu(this.menu);*/
                break;
        }

    }
}
