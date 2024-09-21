package menu;

import static menu.Config.ACTION;

public class VolailleMenu extends Menu
{

    public VolailleMenu() {
        for (String option : ACTION) {
            this.options.add(option);
        }
        this.options.add("Retour au Menu principal");
    }

    @Override
    public Menu display() {
        String title = (this.choice == 0) ? "Volailles" : TypeVolaille.getById(this.choice).getLabel();
        menuRenderer.setTitle(title);
        menuRenderer.setOptions(this.options);
        menuRenderer.render();

        int choice = sc.nextInt();
        sc.nextLine();

        Menu menu = this;
        switch (choice) {
            case 0:
                System.out.println("Ajouter");
                break;
            case 1:
                System.out.println("Afficher / Rechercher");
                menu = MenuManager.SUB_ACTION;
                break;
            case 2:
                System.out.println("Export");
                break;
            case 3:
                menu = MenuManager.MAIN_MENU;
                break;
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
