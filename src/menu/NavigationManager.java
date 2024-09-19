package menu;

import asset.VolailleType;
import controller.App;
import controller.VolailleGroupController;

public class NavigationManager
{

    private static IMenuHandler currentHandler;

    public static IMenuHandler getCurrentHandler() {
        return currentHandler;

    }
    public static void mainMenu(MenuRenderer menu) {
        App.getInstance().setCurrentHandler(new MainMenuHandler(menu));
    }
    public static void menuVolailleGroup(MenuRenderer menu, VolailleType volailleType) {
        App.getInstance().setCurrentHandler(new CrudMenuHandler(menu, volailleType.getLabel(), VolailleGroupController.getINSTANCE()));
    }

    /*public void navigateToPouletMenu(Menu menu) {
        CrudController pouletController = new PouletController();
        App.getInstance().setCurrentHandler(new GenericMenuHandler(menu, "Poulet", pouletController));
    }

    public void navigateToCanardMenu(Menu menu) {
        CrudController canardController = new CanardController();
        App.getInstance().setCurrentHandler(new GenericMenuHandler(menu, "Canard", canardController));
    }*/
}
