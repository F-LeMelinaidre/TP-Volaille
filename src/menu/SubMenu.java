package menu;

import controller.VolailleGroupController;

import static menu.Config.SUB_ACTION;

public class SubMenu extends Menu
{

    public SubMenu() {
        for (String option : SUB_ACTION) {
            this.options.add(option);
        }
        this.options.add("Retour au Menu précédant");
        this.options.add("Retour au Menu principal");
    }

    @Override
    public Menu display() {
        menuRenderer.setTitle("Action");
        menuRenderer.setOptions(this.options);
        menuRenderer.render();

        int choice = sc.nextInt();
        sc.nextLine();

        Menu menu = this;
        switch (choice) {
            case 0:
                System.out.println("Modifier");
                break;
            case 1:
                System.out.println("Sotir");
                break;
            case 2:
                System.out.println("Export");
                break;
            case 3:
                VolailleGroupController vollaileGroup = VolailleGroupController.getINSTANCE();
                boolean result = vollaileGroup.readAll(this.choice); //TODO ATTRIBUER LA VALEUR A UN AUTRE ATTRIBUT POUR UNE MEILLEUR COMPREHENSION lastChoice
                menu = (result) ? MenuManager.VOLAILLE_MENU : MenuManager.MAIN_MENU;
                break;
            case 4:
                menu = MenuManager.MAIN_MENU;
                break;
            default:
                System.out.println("Option invalide, sssveuillez réessayer.");
        }
        return menu;
    }

    @Override
    public void setChoice(int choice) {
        this.choice = choice;
    }
}
