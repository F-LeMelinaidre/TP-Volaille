package menu;

import asset.VolailleType;
import controller.VolailleGroupController;
import static menu.Config.ACTION;

public class VolailleMenu extends Menu
{
    private VolailleGroupController vollaileGroup;

    public VolailleMenu() {

        for (String option : ACTION) {
            this.options.add(option);
        }
        this.options.add("Retour au Menu principal");
    }

    @Override
    public Menu display() {
        VolailleType type = (this.choice == 0) ? null : VolailleType.getById(this.choice);

        String title = (this.choice == 0) ? "Volailles" : type.getName();
        menuRenderer.setTitle(title);
        menuRenderer.setOptions(this.options);
        menuRenderer.render();

        int choice = sc.nextInt();
        sc.nextLine();

        Menu menu = this;
        switch (choice) {
            case 0:
                vollaileGroup = VolailleGroupController.getINSTANCE();
                vollaileGroup.create(type);

                break;
            case 1:
                vollaileGroup = VolailleGroupController.getINSTANCE();
                boolean result = vollaileGroup.read();
                menu = (result) ? MenuManager.SUB_ACTION : MenuManager.VOLAILLE_MENU;
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
