package menu;

import asset.VolailleType;
import controller.App;
import controller.VolailleGroupController;

public class MainMenu extends Menu {

    public MainMenu() {

        this.options.add("Afficher tous les lots");

        for (VolailleType type : VolailleType.values()) {
            this.options.add("Afficher les lots de " + type.getName());
        }
        this.options.add("Modifier les tarifs");
        this.options.add("Quitter");
    }
    @Override
    public Menu display() {

        menuRenderer.setTitle("Menu Principal");
        menuRenderer.setOptions(this.options);
        menuRenderer.render();

        int choice = sc.nextInt();
        sc.nextLine();

        Menu menu = this;
        switch (choice) {
            case 0:
            case 1:
            case 2:
                VolailleGroupController vollaileGroup = VolailleGroupController.getINSTANCE();
                boolean result = vollaileGroup.readAll(choice);
                menu = (result) ? MenuManager.VOLAILLE_MENU : MenuManager.MAIN_MENU;
                menu.setChoice(choice);
                break;
            case 3:
                break;
            case 4:
                app.close();
                break;
            default:
                System.out.println("Option invalide, veuillez réessayer.");
                break;
        }

        return menu;
    }

    @Override
    public void setChoice(int choice) {
        this.choice = choice;
    }
}