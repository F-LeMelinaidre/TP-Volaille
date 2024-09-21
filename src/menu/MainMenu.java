package menu;

public class MainMenu extends Menu {

    public MainMenu() {

        this.options.add("Tous");

        for (TypeVolaille type : TypeVolaille.values()) {
            this.options.add(type.getLabel());
        }

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
                menu =  MenuManager.VOLAILLE_MENU;
                menu.setChoice(choice);

                break;
            case 3:
                System.out.println("Au revoir !");
                System.exit(0);
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