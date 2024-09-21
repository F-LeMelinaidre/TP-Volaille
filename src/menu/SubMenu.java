package menu;

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
                menu = MenuManager.VOLAILLE_MENU;
                break;
            case 4:
                menu = MenuManager.MAIN_MENU;
            default:
                System.out.println("Option invalide, veuillez réessayer.");
        }
        return menu;
    }

    @Override
    public void setChoice(int choice) {
        this.choice = choice;
    }
}
